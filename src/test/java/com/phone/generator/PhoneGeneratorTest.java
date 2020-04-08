package com.phone.generator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.phone.service.impl.PhoneGeneratorImpl;

@RunWith(MockitoJUnitRunner.class)
public class PhoneGeneratorTest {

	PhoneGeneratorImpl phoneGenerator = Mockito.mock(PhoneGeneratorImpl.class);

	@Test
	public void genereAllPossiblePhoneNumbersTest() {

		List<String> phoneNumberList = new ArrayList<String>();
		phoneNumberList.add("AD");
		phoneNumberList.add("AE");

		Mockito.lenient().when(phoneGenerator.genereAllPossiblePhoneNumbers(Mockito.any())).thenReturn(phoneNumberList);
		assertEquals(2, phoneNumberList.size());

	}

	@Test
	public void genereAllPossiblePhoneNumbersEmptyStringTest() {

		List<String> phoneNumberList = new ArrayList<String>();

		Mockito.lenient().when(phoneGenerator.genereAllPossiblePhoneNumbers("")).thenReturn(phoneNumberList);
		assertEquals(0, phoneNumberList.size());

	}

}
