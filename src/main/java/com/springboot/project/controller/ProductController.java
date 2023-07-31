package com.springboot.project.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.entity.Product;
import com.springboot.project.entity.Review;
import com.springboot.project.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping({"/products"})
	public List<Product> getProductById()
	{
		return productService.getAllProduct();
	}
	
	@PutMapping("/updateProduct/{pid}")
	@PreAuthorize("hasRole('User')")
	public Product updateProduct(@RequestBody Review review, @PathVariable("pid") String code)
	{
		return productService.updateProduct(review, code);
	}
	
	@GetMapping("/getProductByString/{searchString}")
	@PreAuthorize("hasRole('User')")
	public List<Product> getProductByString(@PathVariable String searchString)
	{
		return productService.getProductByString(searchString.toLowerCase());
	}
	
	@GetMapping("/getProductById/{code}")
	@PreAuthorize("hasRole('User')")
	public Product getProductByProductCode(@PathVariable("code") String code)
	{
		return productService.getProductByProductCode(code);
	}
	
	
	@GetMapping("/getImgPath/{pid}")
	@PreAuthorize("hasRole('User')")
	public String getImgPath(@PathVariable("pid") String pid)
	{
		return productService.getImgPath(pid);
	}
	
	@PostMapping({"/addProduct"})
	@PreAuthorize("hasRole('User')")
	public Product addProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
	
}
