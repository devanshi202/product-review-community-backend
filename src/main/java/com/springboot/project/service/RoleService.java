package com.springboot.project.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.dao.RoleDao;
import com.springboot.project.entity.Role;

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
