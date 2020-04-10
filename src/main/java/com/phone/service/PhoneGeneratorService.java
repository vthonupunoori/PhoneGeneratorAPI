package com.phone.service;

import java.util.List;

import org.springframework.data.domain.Page;

public interface PhoneGeneratorService {

	public List<String> genereAllPossiblePhoneNumbers(String phoneNum);
	
	public Page<String> findBasedOnPageNumber(String phoneNum, int pageNum, int size);
}
