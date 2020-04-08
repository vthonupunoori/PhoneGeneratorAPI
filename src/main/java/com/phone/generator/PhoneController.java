package com.phone.generator;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.phone.service.PhoneGenerator;

@RestController
public class PhoneController {

	@Autowired
	PhoneGenerator phoneGenerator;

	@CrossOrigin
	@GetMapping("/Generator/{phnNum}")
	public Optional<List> getGeneratedPhoneNumbers(@PathVariable("phnNum") String phnNum) {

		return Optional.ofNullable(phoneGenerator.genereAllPossiblePhoneNumbers(phnNum));

	}
}
