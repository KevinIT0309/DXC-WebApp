package com.techzone.springmvc.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.techzone.springmvc.entity.User;
import com.techzone.springmvc.model.UserModel;
import com.techzone.springmvc.service.UserService;

@Component
public class UserValidator implements Validator {
	
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

//	@Override
//	public void validate(Object target, Errors errors) {
//		User user = (User) target;
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
//        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
//            errors.rejectValue("username", "Size.userForm.username");
//        }
//        if (userService.findByUsername(user.getUsername()) != null) {
//            errors.rejectValue("username", "Duplicate.userForm.username");
//        }
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
//        if (user.getPassword().length() < 5 || user.getPassword().length() > 32) {
//            errors.rejectValue("password", "Size.userForm.password");
//        }
//
//        if (!user.getPasswordConfirm().equals(user.getPassword())) {
//            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
//        }
////        if (user.getRoles().size() == 0) {
////        	ValidationUtils.rejectIfEmpty(errors, "roles", "NoSelect.userForm.role");
////        	errors.rejectValue("roles","NoSelect.userForm.role");
////        }
//		
//	}
	
	
	// test for model object //
	@Override
	public void validate(Object target, Errors errors) {
		UserModel userModel = (UserModel) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.username", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.email", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.password", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.passwordConfirm", "NotEmpty");
        
        if (userModel.getUser().getUsername().length() < 6 || userModel.getUser().getUsername().length() > 32) {
            errors.rejectValue("user.username", "Size.userForm.username");
        }
        if (userService.findByUsername(userModel.getUser().getUsername()) != null) {
            errors.rejectValue("user.username", "Duplicate.userForm.username");
        }
        
        if (userModel.getUser().getPassword().length() < 5 || userModel.getUser().getPassword().length() > 32) {
            errors.rejectValue("user.password", "Size.userForm.password");
        }

        if (!userModel.getUser().getPasswordConfirm().equals(userModel.getUser().getPassword())) {
            errors.rejectValue("user.passwordConfirm", "Diff.userForm.passwordConfirm");
        }
//        if (user.getRoles().size() == 0) {
//        	ValidationUtils.rejectIfEmpty(errors, "roles", "NoSelect.userForm.role");
//        	errors.rejectValue("roles","NoSelect.userForm.role");
//        }
		
	}
	// test for model object //

}
