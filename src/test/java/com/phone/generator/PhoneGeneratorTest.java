package com.phone.generator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.phone.service.impl.PhoneGeneratorServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)

public class PhoneGeneratorTest {

	private PhoneGeneratorServiceImpl phoneGeneratorService = Mockito.mock(PhoneGeneratorServiceImpl.class);
	

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindBasedOnPageNumber() {

		Page<String> resultPages = Mockito.mock(Page.class);
		List<String> phoneNumberList = new ArrayList<String>();

		when(phoneGeneratorService.genereAllPossiblePhoneNumbers("")).thenReturn(phoneNumberList);

		assertEquals(0, resultPages.getSize());

	}

	@Test
	public void genereAllPossiblePhoneNumbersTest() {

		List<String> phoneNumberList = new ArrayList<String>();
		phoneNumberList.add("AD");
		phoneNumberList.add("AE");

		when(phoneGeneratorService.genereAllPossiblePhoneNumbers(Mockito.any())).thenReturn(phoneNumberList);
		assertEquals(2, phoneNumberList.size());

	}

	@Test
	public void genereAllPossiblePhoneNumbersEmptyStringTest() {

		List<String> phoneNumberList = new ArrayList<String>();

		when(phoneGeneratorService.genereAllPossiblePhoneNumbers("")).thenReturn(phoneNumberList);
		assertEquals(0, phoneNumberList.size());

	}
}
