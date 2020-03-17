package com.aarthi.aarthihotel.validator;

import org.springframework.stereotype.Component;

import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.exception.ValidatorException;
import com.aarthi.aarthihotel.model.User;
import com.aarthi.aarthihotel.service.UserService;
@Component
public class RegisterFormValidator {
	UserService user = new UserService();
	User ob = new User();

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

	public boolean checkPhoneNo(Long phoneno) throws ValidatorException, DbException {
		boolean msg = true;
		String phoneNo = String.valueOf(phoneno);
		int phoneNoLength = phoneNo.length();
		int number = user.validNumber(phoneno);
		if (phoneNoLength == 10 && number == 0) {
			msg = true;
		} else if (number == 1) {
			throw new ValidatorException("PhoneNo already Exists");
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

	public boolean checkUserName(String username) throws ValidatorException {
		boolean msg = true;
		int nameLength = username.length();
		if (username.matches("^[a-zA-Z_-]{5}$")) {
			msg = true;
		} else if (nameLength <= 6 || nameLength >= 6) {
			throw new ValidatorException("UserName must be 5 Characters");
		} else if ("".equals(username) || username == null) {
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

	public boolean checkPassWord(String password) throws ValidatorException {
		boolean msg = true;
		int nameLength = password.length();
		if (password.matches("^[a-zA-Z_-]{5}$")) {
			msg = true;
		} else if (nameLength < 6 || nameLength > 6) {
			throw new ValidatorException("PassWord must be 5 Characters");
		} else if ("".equals(password) || password == null) {
			throw new ValidatorException("NullPointerException");
		} else {
			throw new ValidatorException("PassWord must be Characters");
		}
		if (msg == true) {
			return true;
		} else {
			return false;
		}

	}

}
