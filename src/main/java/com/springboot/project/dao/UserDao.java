package com.springboot.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.project.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String>
{

}
