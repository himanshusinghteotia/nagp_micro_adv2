package com.nagp.order.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagp.order.controllers.OrdersController;
import com.nagp.order.entities.Order;
import com.nagp.order.entities.OrderDTO;
import com.nagp.order.services.OrdersService;

@Service
public class DefaultOrdersService implements OrdersService {

	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);

	@Value("${server.port}")
	private int port;

	@Resource
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	List<Order> orders = new ArrayList<>();

	public List<OrderDTO> getAllOrderByUserId(String userId) {

		List<Order> resultOrder = getAllOrders().stream().filter(c -> userId.equals(c.getUserId()))
				.collect(Collectors.toList());
		if (resultOrder.size() != 0) {
			logger.info(String.format("Getting all order details place by user Id %s", userId));
			List<OrderDTO> orderDTO=new ArrayList<OrderDTO>();
			resultOrder.forEach(r -> {
				try {
					orderDTO.add(new OrderDTO(r.getOrderId(),r.getOrderAmount(),new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy").parse(r.getOrderDate())));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			});
			return orderDTO;
		}
		logger.error(String.format("No Orders exist against user Id %s", userId));
		return null;
	}

	protected List<Order> getAllOrders() {
		String sDate = "22-Jan-2020";
		List<Order> orders = new ArrayList<>();
		try {
			orders.add(new Order("1", "1", "10000", new SimpleDateFormat("dd-MMM-yyyy").parse(sDate)));
			orders.add(new Order("2", "1", "21000", new SimpleDateFormat("dd-MMM-yyyy").parse(sDate)));
			orders.add(new Order("3", "2", "900000", new SimpleDateFormat("dd-MMM-yyyy").parse(sDate)));
			orders.add(new Order("4", "2", "999999", new SimpleDateFormat("dd-MMM-yyyy").parse(sDate)));
			orders.add(new Order("5", "3", "10000", new SimpleDateFormat("dd-MMM-yyyy").parse(sDate)));
			orders.add(new Order("6", "3", "21000", new SimpleDateFormat("dd-MMM-yyyy").parse(sDate)));
			orders.add(new Order("7", "4", "900000", new SimpleDateFormat("dd-MMM-yyyy").parse(sDate)));
			orders.add(new Order("8", "4", "999999", new SimpleDateFormat("dd-MMM-yyyy").parse(sDate)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return orders;
	}

}
