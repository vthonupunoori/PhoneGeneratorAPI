package com.phone.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.phone.service.PhoneGeneratorService;

@Service
public class PhoneGeneratorServiceImpl implements PhoneGeneratorService {

	private Map<Character, String> numToCharMap = new HashMap<>();

	private List<String> phoneNumberStringList = new ArrayList<>();

	public PhoneGeneratorServiceImpl() {
		numToCharMap.put('0', "+");
		numToCharMap.put('1', "1");
		numToCharMap.put('2', "ABC");
		numToCharMap.put('3', "DEF");
		numToCharMap.put('4', "GHI");
		numToCharMap.put('5', "JKL");
		numToCharMap.put('6', "MNO");
		numToCharMap.put('7', "PQRS");
		numToCharMap.put('8', "TUV");
		numToCharMap.put('9', "WXYZ");

	}

	@Override
	public List<String> genereAllPossiblePhoneNumbers(String phoneNumStr) {

		phoneNumberStringList = new ArrayList<>();

		if (StringUtils.isEmpty(phoneNumStr)) {
			return phoneNumberStringList;
		}

		String phoneNum = phoneNumStr.replaceAll("-", "").replaceAll(" ", "");
		recursiveSwapping(new StringBuilder(), phoneNum, 0);
		return phoneNumberStringList;
	}

	private void recursiveSwapping(StringBuilder sb, String phoneNum, int index) {
		if (index == phoneNum.length()) {
			phoneNumberStringList.add(sb.toString());
			return;
		}

		String str = numToCharMap.get(phoneNum.charAt(index));
		for (char c : str.toCharArray()) {
			sb.append(c);
			recursiveSwapping(sb, phoneNum, index + 1);
			sb.setLength(sb.length() - 1);
		}
	}

	@Override
	public Page<String> findBasedOnPageNumber(String phoneNum, int pageNum, int size) {
		genereAllPossiblePhoneNumbers(phoneNum);

		Pageable pageable = PageRequest.of(pageNum, size, Sort.unsorted());

		long start = pageable.getOffset();
		long end = (start + pageable.getPageSize()) > phoneNumberStringList.size() ? phoneNumberStringList.size()
				: (start + pageable.getPageSize());
		Page<String> pages = new PageImpl<String>(phoneNumberStringList.subList((int)start, (int)end), pageable,
				phoneNumberStringList.size());

		return pages;
	}

}
