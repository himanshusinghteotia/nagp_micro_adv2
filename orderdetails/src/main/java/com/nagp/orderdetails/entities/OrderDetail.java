package com.nagp.orderdetails.entities;

public class OrderDetail {
	
	private UserDTO users;
	private OrderDTO[] orderDetails;
	
	public OrderDetail() {}
	
	public OrderDetail(UserDTO users, OrderDTO[] orderDetails) {
		this.users = users;
		this.orderDetails = orderDetails;
	}
	
	public UserDTO getUsers() {
		return users;
	}
	public void setUsers(UserDTO users) {
		this.users = users;
	}
	public OrderDTO[] getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderDTO[] orderDetails) {
		this.orderDetails = orderDetails;
	}
	
//	private String orders;
//
//	private String userDetails;
//
//	public OrderDetail() {}
//	
//	public OrderDetail(String orders, String userDetails) {
//		this.orders = orders;
//		this.userDetails = userDetails;
//	}
//
//	public String getOrders() {
//		return orders;
//	}
//
//	public void setOrders(String orders) {
//		this.orders = orders;
//	}
//
//	public String getUserDetails() {
//		return userDetails;
//	}
//
//	public void setUserDetails(String userDetails) {
//		this.userDetails = userDetails;
//	}
	
}