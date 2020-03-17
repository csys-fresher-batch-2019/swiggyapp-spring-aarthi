package com.aarthi.aarthihotel.dto;

import java.time.LocalDateTime;

public class Item {

	private int orderId;
	private int itemId;
	private int quantity;
	private int totalAmount;
	private String status;
	private LocalDateTime orderedDate;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}

	@Override
	public String toString() {
		return "ItemList [orderId=" + orderId + ", itemId=" + itemId + ", quantity=" + quantity + ", totalAmount="
				+ totalAmount + ", status=" + status + ", orderedDate=" + orderedDate + "]";
	}
}
