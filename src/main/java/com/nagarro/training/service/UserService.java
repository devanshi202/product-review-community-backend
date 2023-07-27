package com.nagarro.training.service;
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

import com.nagarro.training.dao.ProductDao;
import com.nagarro.training.dao.ReviewDao;
import com.nagarro.training.dao.RoleDao;
import com.nagarro.training.dao.UserDao;
import com.nagarro.training.entity.Product;
import com.nagarro.training.entity.Review;
import com.nagarro.training.entity.ReviewStatus;
import com.nagarro.training.entity.Role;
import com.nagarro.training.entity.User;

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
