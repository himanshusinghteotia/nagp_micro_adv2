package com.nagp.order.entities;

import java.util.Date;

public class Order {

	private String orderId;
	private String userId;
	private String orderAmount;
	private Date orderDate;
	
	public Order(String orderId, String userId,String orderAmount,Date orderDate) {
		this.orderId = orderId;
		this.userId = userId;
		this.orderAmount=orderAmount;
		this.orderDate=orderDate;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderDate() {
		return orderDate.toString();
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}
