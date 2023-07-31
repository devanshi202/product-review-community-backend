package com.springboot.project.controller;

import java.util.List;


import javax.annotation.PostConstruct;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.entity.User;
import com.springboot.project.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping({"/registerNewUser"})
	public User registerNewUser(@RequestBody User user)
	{
		
		return userService.registerNewUser(user);
	}
	
	@GetMapping({"/home"})
	public String checkApp()
	{
		return "server is running fine !!!";
	}
	
	@GetMapping({"/users"})
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
}
