package com.springboot.project.service;
import java.awt.image.BufferedImage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.util.*;

import javax.imageio.ImageIO;
import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.project.dao.ProductDao;
import com.springboot.project.dao.ReviewDao;
import com.springboot.project.dao.RoleDao;
import com.springboot.project.dao.UserDao;
import com.springboot.project.entity.Product;
import com.springboot.project.entity.Review;
import com.springboot.project.entity.ReviewStatus;
import com.springboot.project.entity.Role;
import com.springboot.project.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public List<User> getAllUsers()
	{
		return (List<User>) userDao.findAll();
	}
	public User registerNewUser(User user)
	{
		Role role = roleDao.findById("User").get();
		Set<Role> userRole = new HashSet<>();
		userRole.add(role);
		user.setRole(userRole);
		user.setPassword(getEncodedPassword(user.getPassword()));
		
		return userDao.save(user);
	}
	
	public String getEncodedPassword(String password)
	{
		return passwordEncoder.encode(password);
	}
}
