package com.nagp.orderdetails.services;

import com.nagp.orderdetails.entities.OrderDetail;

public interface OrderDetailService {
	
	OrderDetail getAllOrderDetailsByUserId(String userId);

}