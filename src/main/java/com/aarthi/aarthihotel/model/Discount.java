package com.aarthi.aarthihotel.model;

public class Discount {
	private int minvalue;
	private int maxValue;
	private int discountRate;

	public int getMinvalue() {
		return minvalue;
	}

	public void setMinvalue(int minvalue) {
		this.minvalue = minvalue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public String toString() {
		return "DiscountDetails [minvalue=" + minvalue + ", maxValue=" + maxValue + ", discountRate=" + discountRate
				+ "]";
	}
}
