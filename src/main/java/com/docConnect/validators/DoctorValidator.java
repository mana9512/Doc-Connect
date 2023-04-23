package com.docConnect.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.docConnect.pojo.Doctor;

@Component
public class DoctorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Doctor.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "name", "Name cannot be empty", "Please provide name");
		ValidationUtils.rejectIfEmpty(errors, "email", "Email Id cannot be empty", "Please provide email");
		ValidationUtils.rejectIfEmpty(errors, "specialization", "Specialization cannot be empty",
				"Please select specialization");
		ValidationUtils.rejectIfEmpty(errors, "password", "Password cannot be empty", "Please provide password");

	}

}