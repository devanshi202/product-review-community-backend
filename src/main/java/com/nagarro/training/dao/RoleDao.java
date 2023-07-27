package com.nagarro.training.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.training.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String>{

}
