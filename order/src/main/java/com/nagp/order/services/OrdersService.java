package com.nagp.order.services;

import java.util.List;

import com.nagp.order.entities.OrderDTO;

public interface OrdersService {
	
	List<OrderDTO> getAllOrderByUserId(String userId);

}