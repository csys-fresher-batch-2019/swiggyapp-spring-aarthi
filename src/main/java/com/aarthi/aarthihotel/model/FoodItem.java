package com.aarthi.aarthihotel.model;

public class FoodItem {
	private int itemId;
	private String itemName;
	private String foodType;
	private int price;
	private int menuId;
	private String image;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getImage() {
		return image;
	}

	public void setImages(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "FoodItem [itemId=" + itemId + ", itemName=" + itemName + ", foodType=" + foodType + ", price=" + price
				+ ", menuId=" + menuId + ", image=" + image + "]";
	}

	public String display() {
		return "FoodDetails [image=" + image + ",itemId=" + itemId + ",itemName=" + itemName + ", foodType=" + foodType
				+ ", price=" + price + "]";
	}

	public String displayItem() {
		return "FoodDetails [itemName=" + itemName + ", price=" + price + "]";
	}

}
