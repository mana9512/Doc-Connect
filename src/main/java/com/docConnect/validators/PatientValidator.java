package com.docConnect.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.docConnect.pojo.Patient;

@Component
public class PatientValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Patient.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "name", "Name cannot be empty", "Please provide name");
		ValidationUtils.rejectIfEmpty(errors, "email", "Email Id cannot be empty", "Please provide email");
		ValidationUtils.rejectIfEmpty(errors, "phone", "Contact Number cannot be empty", "Please provide number");
		ValidationUtils.rejectIfEmpty(errors, "age", "Age cannot be empty", "Please provide age");
		ValidationUtils.rejectIfEmpty(errors, "gender", "Gender cannot be empty", "Please provide  gender");
		ValidationUtils.rejectIfEmpty(errors, "password", "Password cannot be empty", "Please provide password");

	}

}
