package com.docConnect.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.docConnect.pojo.UserRole;

@Component

public class UserRoleValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserRole.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "email", "Name cannot be empty", "Please provide name");
		ValidationUtils.rejectIfEmpty(errors, "role", "Role cannot be empty", "Please provide role");
		ValidationUtils.rejectIfEmpty(errors, "password", "Password cannot be empty", "Please provide password");

	}

}
