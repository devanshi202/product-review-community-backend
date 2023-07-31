package com.springboot.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.entity.Review;
import com.springboot.project.service.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@PutMapping("/updateReview/{rid}")
	@PreAuthorize("hasRole('Admin')")
	public Review updateReviewStatus(@RequestBody String status, @PathVariable("rid") int rid)
	{
		return reviewService.updateReview(status, rid);
	}
	
	@GetMapping({"/getPendingReviews"})
	@PreAuthorize("hasRole('Admin')")
	public List<Review> getPendingReviews()
	{
		return reviewService.getPendingReviews();
	}
	
	@GetMapping({"/reviews"})
	public List<Review> getAllReviews()
	{
		return reviewService.getAllReviews();
	}
	
	@PostMapping({"/addReview"})
	@PreAuthorize("hasRole('User')")
	public Review addReview(@RequestBody Review review)
	{
		return reviewService.addReview(review);
	}
}
