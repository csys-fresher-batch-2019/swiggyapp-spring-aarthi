package com.aarthi.aarthihotel.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {
	private int orderId;
	private int userId;
	private LocalDateTime orderedDate;
	private LocalDate deliveredDate;
	private LocalDateTime approxDeliveryTime;
	private int totalAmt;
	private String statusInfo;
	private String comments;
	private int afterDiscount;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}

	public LocalDate getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(LocalDate deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public LocalDateTime getApproxDeliveryTime() {
		return approxDeliveryTime;
	}

	public void setApproxDeliveryTime(LocalDateTime approxDeliveryTime) {
		this.approxDeliveryTime = approxDeliveryTime;
	}

	public int getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmts(int totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getAfterDiscount() {
		return afterDiscount;
	}

	public void setAfterDiscount(int afterDiscount) {
		this.afterDiscount = afterDiscount;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", userId=" + userId + ", orderedDate=" + orderedDate
				+ ", deliveredDate=" + deliveredDate + ", totalAmt=" + totalAmt + ", statusInfo=" + statusInfo
				+ ", comments=" + comments + ", afterDiscount=" + afterDiscount + "]";
	}

}
