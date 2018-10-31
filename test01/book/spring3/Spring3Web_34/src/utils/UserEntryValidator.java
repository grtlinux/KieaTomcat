package utils;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import logic.User;

public final class UserEntryValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		User user = (User) command;
		if (!StringUtils.hasLength(user.getUserId())) {
			errors.rejectValue("userId", "error.required");
		}
		if (!StringUtils.hasLength(user.getPassword())) {
			errors.rejectValue("password", "error.required");
		}
		if (!StringUtils.hasLength(user.getUserName())) {
			errors.rejectValue("userName", "error.required");
		}
		if (!StringUtils.hasLength(user.getPostCode())) {
			errors.rejectValue("postCode", "error.required");
		}
		if (!StringUtils.hasLength(user.getAddress())) {
			errors.rejectValue("address", "error.required");
		}
		if (!StringUtils.hasLength(user.getEmail())) {
			errors.rejectValue("email", "error.required");
		}
		
		if (errors.hasErrors()) {
			errors.reject("error.input.user");
		}
	}
}