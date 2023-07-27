package com.nagarro.training.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.dao.RoleDao;
import com.nagarro.training.entity.Role;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;
	
	public Role createNewRole(Role role)
	{
		return roleDao.save(role);
		
	}
	
	public List<Role> getAllRoles(){
		return (List<Role>) roleDao.findAll();
	}
}
