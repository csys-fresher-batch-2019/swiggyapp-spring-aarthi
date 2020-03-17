package com.aarthi.aarthihotel.validator;

import org.springframework.stereotype.Component;

import com.aarthi.aarthihotel.exception.ValidatorException;
@Component
public class RatingDetailValidator {
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

	public boolean checkRatingPoints(int ratingPoint) throws ValidatorException {

		if (ratingPoint == 1 || ratingPoint == 2 || ratingPoint == 3 || ratingPoint == 4 || ratingPoint == 5) {
			msg = true;
		} else if (ratingPoint < 0) {
			throw new ValidatorException("Negative value is not allowed");
		} else {
			throw new ValidatorException("Invalid RatingPoint");
		}
		if (msg = true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkItemId(int itemId) throws ValidatorException {

		if (itemId > 0) {
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
