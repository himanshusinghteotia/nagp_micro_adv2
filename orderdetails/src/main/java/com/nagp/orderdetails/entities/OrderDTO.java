package com.nagp.orderdetails.entities;


public class OrderDTO {

	private String orderId;
	private String orderAmount;
	private String orderDate;
	
	public OrderDTO() {}
	
	public OrderDTO(String orderId,String orderAmount,String orderDate) {
		this.orderId = orderId;
		this.orderAmount=orderAmount;
		this.orderDate=orderDate;
	}
		
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
}
