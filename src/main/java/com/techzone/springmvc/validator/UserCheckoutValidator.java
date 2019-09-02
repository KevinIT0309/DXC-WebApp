package com.techzone.springmvc.validator;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.techzone.springmvc.model.UserCheckoutModel;

@Component
public class UserCheckoutValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserCheckoutValidator.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		UserCheckoutModel userCheckoutModel = (UserCheckoutModel) target;
		
		if (isCurrentAuthentication()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "UserCheckoutModel.NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "UserCheckoutModel.NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "UserCheckoutModel.NotEmpty");
		} else {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.firstName", "UserCheckoutModel.NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.lastName", "UserCheckoutModel.NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.email", "UserCheckoutModel.NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "UserCheckoutModel.NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "UserCheckoutModel.NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "UserCheckoutModel.NotEmpty");
		}
		
		if (userCheckoutModel.getAddress().length() < 10) {
			errors.rejectValue("address", "UserCheckoutModel.SizeAddress");
		}
		
	}
	
	// == == == == == == == == == == == == == == //
	public boolean isCurrentAuthentication() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			System.err.println("USER IS ON LOGIN");
			return true; // Authenticated User
		}
		System.err.println("IS ANONYMOUS");
		return false; // Anonymous
	}
	// == == == == == == == == == == == == == == //

}
