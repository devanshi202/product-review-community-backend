package com.springboot.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.entity.JwtRequest;
import com.springboot.project.entity.JwtResponse;
import com.springboot.project.service.JwtService;

@RestController
public class JwtController {

	@Autowired
	private JwtService jwtService;
	
	@PostMapping({"/authenticate"})
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		return jwtService.createJwtToken(jwtRequest);
	}
}
