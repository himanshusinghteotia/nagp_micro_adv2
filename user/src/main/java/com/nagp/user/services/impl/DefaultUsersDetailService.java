package com.nagp.user.services.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import com.nagp.user.controllers.UsersController;
import com.nagp.user.entities.User;
import com.nagp.user.entities.UserDTO;
import com.nagp.user.entities.UserRepository;
import com.nagp.user.services.UsersDetailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DefaultUsersDetailService  implements UsersDetailService {

	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Value("${server.port}")
	private int port;

	@Resource
	private RestTemplate restTemplate;

	@Autowired 
	private UserRepository userRepository;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public UserDTO getUserById(int id) {
		Optional<User> resultUser = getAllUsers().stream().filter(u -> id == u.getId()).findFirst();

		if (resultUser.isPresent()) {
			UserDTO userDTO = new UserDTO();
			userDTO.setName(resultUser.get().getName());
			userDTO.setAge(resultUser.get().getAge());
			userDTO.setEmail(resultUser.get().getEmail());
			logger.info(String.format("Getting all user details by user Id %s", id));
			return userDTO;
		}
		logger.error(String.format("No User exist against user Id %s", id));
		return null;
	}

	protected List<User> getAllUsers() {
		logger.info(String.format("Getting all user details from database"));
		return (List<User>) userRepository.findAll();
	}
}