package com.aarthi.aarthihotel.model;

public class Rating {
	private int userId;
	private int itemId;
	private String itemName;
	private int ratingPoint;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setRatingPoints(int ratingPoint) {
		this.ratingPoint = ratingPoint;
	}

	public int getRatingPoint() {
		return ratingPoint;
	}

	@Override
	public String toString() {
		return "RatingDetails [userId=" + userId + ", itemId=" + itemId + ", itemName=" + itemName + ", ratingPoint="
				+ ratingPoint + "]";
	}
}
