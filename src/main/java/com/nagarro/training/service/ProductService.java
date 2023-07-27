package com.nagarro.training.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.dao.ProductDao;
import com.nagarro.training.entity.Product;
import com.nagarro.training.entity.Review;
import com.nagarro.training.entity.ReviewStatus;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	
	public List<Product> getAllProduct()
	{
		return (List<Product>) productDao.findAll();
	}
	
	public List<Product> getProductByString(String searchString)
	{
		
		String likePattern = "%"+searchString+"%";
		return productDao.findByProductCodeLikeOrProductNameLikeOrBrand(likePattern, likePattern, likePattern);
		
	}
	
	public Product getProductByProductCode(String code)
	{
		return productDao.findById(code).get();
	}
	
	public Product updateProduct(Review review, String code)
	{
		review.setStatus(ReviewStatus.PENDING);
		Product product = productDao.findById(code).get();
		List<Review> productReviewList = product.getReview();
		productReviewList.add(review);
		product.setReview(productReviewList);
		return productDao.save(product);
	}
	
	public String getImgPath(String pid)
	{
		Product product = productDao.findById(pid).get();
		if(product.getImage() != null)
		{
			String base64img = Base64.getEncoder().encodeToString(product.getImage());
			return base64img;
		}
		return "";
	}
	
	public Product addProduct(Product product)
	{
		return productDao.save(product);
	}
}
