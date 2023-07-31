package com.springboot.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.project.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String>{

}
