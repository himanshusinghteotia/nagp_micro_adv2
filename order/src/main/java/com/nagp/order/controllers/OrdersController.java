package com.nagp.order.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.nagp.order.entities.OrderDTO;
import com.nagp.order.services.OrdersService;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {

	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private int port;

	@Resource
	OrdersService ordersDetailService;

	@GetMapping(value = "{userId}")
	public List<OrderDTO> getOrderByUserId(@PathVariable(name = "userId") String userId) {
		logger.info(String.format("Working from port %s of order service.", port));
		logger.info(String.format("Getting order by userId %s", userId));
		return ordersDetailService.getAllOrderByUserId(userId);
	}

	@GetMapping
	public OrderDTO[] getOrder(@RequestParam(name = "userId") String userId) {
		logger.info(String.format("In RequestParam"));
		List<OrderDTO> user = getOrderByUserId(userId);
		OrderDTO [] array = user.stream().toArray(n -> new OrderDTO[n]);
		return array;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
