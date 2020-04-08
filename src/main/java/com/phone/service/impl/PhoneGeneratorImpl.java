package com.phone.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.phone.service.PhoneGenerator;

@Service
public class PhoneGeneratorImpl implements PhoneGenerator {

	private Map<Character, String> numToCharMap = new HashMap<>();

	private List<String> phoneNumberString = new ArrayList<>();

	public PhoneGeneratorImpl() {
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

		phoneNumberString = new ArrayList<>();

		if (StringUtils.isEmpty(phoneNumStr)) {
			return phoneNumberString;
		}

		String phoneNum = phoneNumStr.replaceAll("-", "").replaceAll(" ", "");
		recursiveSwapping(new StringBuilder(), phoneNum, 0);
		return phoneNumberString;
	}

	private void recursiveSwapping(StringBuilder sb, String phoneNum, int index) {
		if (index == phoneNum.length()) {
			phoneNumberString.add(sb.toString());
			return;
		}

		String str = numToCharMap.get(phoneNum.charAt(index));
		for (char c : str.toCharArray()) {
			sb.append(c);
			recursiveSwapping(sb, phoneNum, index + 1);
			sb.setLength(sb.length() - 1);
		}
	}

}
