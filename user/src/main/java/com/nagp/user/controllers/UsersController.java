package com.nagp.user.controllers;

import com.nagp.user.entities.UserDTO;
import com.nagp.user.services.UsersDetailService;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private int port;

	@Resource
	UsersDetailService usersDetailService;

	@GetMapping(value = "/{id}")
	UserDTO getUserDetails(@PathVariable(name = "id") int id) {
		logger.info(String.format("Working from port %s of user service.", port));
		logger.info(String.format("Getting user by userId %s", id));
		return usersDetailService.getUserById(id);
	}

	public RestTemplate getRestTemplate() { return restTemplate; }

	public void setRestTemplate(RestTemplate restTemplate) { this.restTemplate =
			restTemplate; }

}