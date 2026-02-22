package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.User;
import com.cts.exception.UserAlreadyExixtsException;
import com.cts.service.UserService;

@RequestMapping("auth")
@RestController
public class UserController {
	
	@Autowired
	UserService userservice;
	
	
	@PostMapping("/addNewUser")
	public void addNewUser(@RequestBody User user) {
		
		try {
			userservice.addUser(user);
		} catch (UserAlreadyExixtsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/get")
	public List<User> getUser(){
		List<User>users = userservice.getUser();
		return users;
	}
}
