package com.nagarro.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.dao.ReviewDao;
import com.nagarro.training.entity.Review;
import com.nagarro.training.entity.ReviewStatus;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;
	
	public List<Review> getAllReviews()
	{
		return (List<Review>) reviewDao.findAll();
	}
	
	public Review updateReview(String status, int rid)
	{
		Review review = reviewDao.findById(rid).get();
		review.setStatus(ReviewStatus.valueOf(status.toUpperCase()));
		return reviewDao.save(review);
	}
	
	public Review addReview(Review review)
	{
		review.setStatus(ReviewStatus.PENDING);
		return reviewDao.save(review);
	}
	
	public List<Review> getPendingReviews()
	{
		return reviewDao.findByStatus(ReviewStatus.PENDING);
	}
}
