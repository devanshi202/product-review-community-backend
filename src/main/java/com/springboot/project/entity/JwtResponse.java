package com.springboot.project.entity;

public class JwtResponse {

	private User user;
	private String jwtToken;
	
	
	
	public JwtResponse(User user, String jwtToken) {
		super();
		this.user = user;
		this.jwtToken = jwtToken;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJetToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	
	
}
