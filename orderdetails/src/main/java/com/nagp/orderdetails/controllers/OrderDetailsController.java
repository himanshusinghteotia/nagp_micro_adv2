package com.nagp.orderdetails.controllers;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagp.orderdetails.entities.OrderDetail;
import com.nagp.orderdetails.services.OrderDetailService;

@RestController
@RequestMapping(value = "/orderdetails")
public class OrderDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(OrderDetailsController.class);

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private int port;

	@Resource
	OrderDetailService orderDetailService;

	@GetMapping(value = "{userId}")
	public OrderDetail getAllOrderDetailsByUserId(@PathVariable(name = "userId") String userId) {
		logger.info(String.format("Working from port %s of order detail service.", port));
		logger.info(String.format("Getting order by userId %s", userId));
		return orderDetailService.getAllOrderDetailsByUserId(userId);
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}