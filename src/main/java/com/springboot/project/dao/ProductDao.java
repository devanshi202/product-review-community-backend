package com.springboot.project.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.project.entity.Product;
import com.springboot.project.entity.User;

public interface ProductDao extends JpaRepository<Product, String>{
	

	
	@Query(value = "SELECT p FROM Product p WHERE p.productCode LIKE :pattern or p.productName LIKE :pattern1 or p.brand LIKE :pattern2")
	List<Product> findByProductCodeLikeOrProductNameLikeOrBrand(@Param("pattern") String pattern, 
	  @Param("pattern1") String pattern1, @Param("pattern2") String pattern2);

	

//	List<Product> findByProductCodeLikeOrProductNameLikeOrBrand(String likePattern, String likePattern2, String likePattern3);
}
