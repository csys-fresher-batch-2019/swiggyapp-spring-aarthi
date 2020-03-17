package com.aarthi.aarthihotel.validator;

import org.springframework.stereotype.Component;

import com.aarthi.aarthihotel.exception.ValidatorException;
@Component
public class LoginFormValidator {
	public boolean checkName(String name) throws ValidatorException {
		boolean msg = true;
		int nameLength = name.length();
		if (name.matches("^[a-zA-Z_-]{6,15}$")) {
			msg = true;
		} else if (nameLength < 6 || nameLength > 15) {
			throw new ValidatorException("UserName must be above 6 and below 15 Characters");
		} else if ("".equals(name) || name == null) {
			throw new ValidatorException("NullPointerException");
		} else {
			throw new ValidatorException("UserName must be Characters");
		}
		if (msg == true) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkPhoneNo(Long phoneno) throws ValidatorException {
		boolean msg = true;
		String phoneNo = String.valueOf(phoneno);
		int phoneNoLength = phoneNo.length();
		if (phoneNoLength == 10) {
			msg = true;
		} else if ("".equals(phoneNo) || phoneNo == null) {
			throw new ValidatorException("NullPointerException");
		}

		else {
			throw new ValidatorException("PhoneNo must be 10 digit");
		}
		if (msg == true) {
			return true;
		} else {
			return false;
		}
	}

}
