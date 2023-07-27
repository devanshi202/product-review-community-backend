package com.nagarro.training.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.nagarro.training.entity.Review;
import com.nagarro.training.entity.ReviewStatus;

public interface ReviewDao extends JpaRepository<Review, Integer>{

	List<Review> findByStatus(ReviewStatus status);
}
