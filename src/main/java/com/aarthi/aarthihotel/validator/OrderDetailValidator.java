package com.aarthi.aarthihotel.validator;

import org.springframework.stereotype.Component;

import com.aarthi.aarthihotel.exception.ValidatorException;
@Component
public class OrderDetailValidator {
	boolean msg = true;

	public boolean checkUserId(int userId) throws ValidatorException {

		if (userId > 0) {
			msg = true;
		} else {
			throw new ValidatorException("Negative Value is not allowed");
		}
		if (msg = true) {
			return true;
		} else {
			return false;
		}
	}

}
