package com.phone.generator;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phone.service.PhoneGeneratorService;

@CrossOrigin(origins = "*")
@RestController
public class PhoneController {

	@Autowired
	PhoneGeneratorService phoneGenerator;

	@GetMapping("/Generator/{phnNum}")
	public Optional<List<String>> getGeneratedPhoneNumbers(@PathVariable("phnNum") String phnNum) {

		return Optional.ofNullable(phoneGenerator.genereAllPossiblePhoneNumbers(phnNum));

	}

	@GetMapping("/pageGenerator/{phnNum}")
	public Optional<Page<String>> getGeneratedPhoneNumbersPage(@PathVariable("phnNum") String phnNum,
			@RequestParam("page") int page, @RequestParam("size") int size) {
//		System.out.println("Phone:" + phnNum + ", Page: " + page + ", Size: " + size);
		return Optional.ofNullable(phoneGenerator.findBasedOnPageNumber(phnNum, page, size));

	}
}
