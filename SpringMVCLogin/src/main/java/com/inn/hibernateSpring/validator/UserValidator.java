package com.inn.hibernateSpring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.inn.hibernateSpring.model.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object command, Errors errs) {
		System.out.println("Inside validate()");
		User user=(User)command;
		if(user.getUsername() == null || user.getUsername().length() == 0){
			errs.rejectValue("username", "err.username.required", null,
					"Username Required");
		}
		if(user.getPassword() == null ||user.getPassword().length() ==0){
			errs.rejectValue("password", "err.password.required", null,
					"Password Required");
		}
			
		
	}

}
