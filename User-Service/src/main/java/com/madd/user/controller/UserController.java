package com.madd.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madd.user.VO.ResponseTemplateVO;
import com.madd.user.entity.User;
import com.madd.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("UserController.saveUser start");
		return userService.saveUser(user);
	}
	
	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("UserController.getUserWithDepartment start");
		return userService.getUserWithDepartment(userId);
	}

}
