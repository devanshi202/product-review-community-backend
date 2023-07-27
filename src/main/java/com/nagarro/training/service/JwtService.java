package com.nagarro.training.service;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.training.dao.UserDao;
import com.nagarro.training.entity.JwtRequest;
import com.nagarro.training.entity.JwtResponse;
import com.nagarro.training.entity.User;
import com.nagarro.training.util.JwtUtil;
import com.nagarro.training.util.JwtUtil;

@Service
public class JwtService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception
	{
		String userName = jwtRequest.getUserName();
		String userPassword = jwtRequest.getUserPassword();
		
		authenticate(userName, userPassword);
		
		final UserDetails userDetails = loadUserByUsername(userName);
		
		String newGeneratedToken = jwtUtil.generateToken(userDetails);
		
		User user = userDao.findById(userName).get();
		
		return new JwtResponse(user, newGeneratedToken);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userDao.findById(username).get();
		if(user!=null)
		{
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
		}
		else
		{
			throw new UsernameNotFoundException("username is not found");
		}
	}
	
	private Set getAuthorities(User user)
	{
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRole().forEach(role->{
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
		});
		
		return authorities;
	}
	
	private void authenticate(String userName, String userPassword) throws Exception
	{
		try 
		{			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
		}
		catch(DisabledException e)
		{
			throw new Exception("user is no longer active");
		}
		catch(BadCredentialsException e)
		{
			throw new Exception("bad credentials from user");
		}
	}

}
