package com.aarthi.aarthihotel.validator;

import org.springframework.stereotype.Component;

import com.aarthi.aarthihotel.exception.ValidatorException;
@Component
public class FoodDetailValidator {
	boolean msg = true;

	public boolean checkPrice(int price) throws ValidatorException {

		if (price > 0) {
			msg = true;
		} else {
			throw new ValidatorException("Negative number is not allowed");
		}
		if (msg = true) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkFoodName(String itemName) throws ValidatorException {

		if (itemName.matches("[A-Z][a-z]*")) {
			msg = true;
		} else if ("".equals(itemName) || itemName == null) {
			throw new ValidatorException("NullPointerException");
		} else {
			throw new ValidatorException("ItemName must be in Charcters");
		}
		if (msg = true) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkFoodType(String foodType) throws ValidatorException {

		if (foodType.equals("V") || foodType.equals("NV") || foodType.equals("O")) {
			msg = true;
		} else if ("".equals(foodType) || foodType == null) {
			throw new ValidatorException("NullPointerException");
		} else {
			throw new ValidatorException("Invalid Food Type");
		}
		if (msg = true) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkMenuId(int menuId) throws ValidatorException {

		if (menuId == 1 || menuId == 2 || menuId == 3) {
			msg = true;
		} else {
			throw new ValidatorException("Invalid MenuId");
		}
		if (msg = true) {
			return true;
		} else {
			return false;
		}

	}

}
