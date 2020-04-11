package com.nagp.orderdetails.services.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagp.orderdetails.controllers.OrderDetailsController;
import com.nagp.orderdetails.entities.OrderDTO;
import com.nagp.orderdetails.entities.OrderDetail;
import com.nagp.orderdetails.entities.UserDTO;
import com.nagp.orderdetails.services.OrderDetailService;
import org.springframework.core.env.Environment;

@Service
public class DefaultOrderDetailService implements OrderDetailService {

	private static final Logger logger = LoggerFactory.getLogger(OrderDetailsController.class);

	@Value("${server.port}")
	private int port;

	@Autowired
	private Environment env;

	@Resource
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public OrderDTO[] getOrder(String userId) {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<OrderDTO[]> response = null;
		try {

			String url = "http://"+env.getProperty("orderhost")+":8041/orders?userId=" + userId;

			response = restTemplate.exchange(url, HttpMethod.GET, null, OrderDTO[].class);

			return response.getBody();

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	public UserDTO getUser(String userId) {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserDTO> response = null;
		try {
			String url = "http://"+env.getProperty("userhost")+":8040/users/" + userId;
			response = restTemplate.exchange(url, HttpMethod.GET, null, UserDTO.class);
			return response.getBody();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	public OrderDetail getAllOrderDetailsByUserId(String userId) {

		OrderDetail orderDetail =new OrderDetail();
		UserDTO user = getUser(userId);
		if (!user.equals(null)) {
			orderDetail.setUsers(user);
			OrderDTO[] orders = getOrder(userId);
			if (!orders.equals(null)) {
				orderDetail.setOrderDetails(orders);
				logger.info(String.format("Orderdetails against user Id %s", userId));
				return orderDetail;
			}
		}
		logger.error(String.format("Cannot get details against user Id %s", userId));
		return null;

	}

}