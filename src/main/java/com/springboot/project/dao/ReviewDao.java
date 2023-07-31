package com.springboot.project.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.springboot.project.entity.Review;
import com.springboot.project.entity.ReviewStatus;

public interface ReviewDao extends JpaRepository<Review, Integer>{

	List<Review> findByStatus(ReviewStatus status);
}
