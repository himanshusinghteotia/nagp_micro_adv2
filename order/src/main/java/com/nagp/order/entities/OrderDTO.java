package com.nagp.order.entities;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderDTO {

	private String orderId;
	private String orderAmount;
	private Date orderDate;
	
	public OrderDTO(String orderId,String orderAmount,Date orderDate) {
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
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
	    String strDate = formatter.format(orderDate);  		
		return strDate;
	}

	public void setOrderDate(Date orderDate) { 
		this.orderDate = orderDate;
	}
}
