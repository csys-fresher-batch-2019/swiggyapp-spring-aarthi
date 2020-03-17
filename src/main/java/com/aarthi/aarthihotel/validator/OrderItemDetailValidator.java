package com.aarthi.aarthihotel.validator;

import org.springframework.stereotype.Component;

import com.aarthi.aarthihotel.exception.ValidatorException;
@Component
public class OrderItemDetailValidator {
	boolean msg = true;

	public boolean checkOrderId(int OrderId) throws ValidatorException {

		if (OrderId > 0) {
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

	public boolean checkItemId(int ItemId) throws ValidatorException {

		if (ItemId > 0) {
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

	public boolean checkQuantity(int quantity) throws ValidatorException {

		if (quantity > 0) {
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

	public boolean checkTotalAmts(int TotalAmts) throws ValidatorException {

		if (TotalAmts > 0) {
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
