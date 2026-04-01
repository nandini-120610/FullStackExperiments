package com.example.ProductApplication;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	
	List<Product> findByCategory(String category);
	
	List<Product> findByPriceBetween(double min, double max);
	
	
	//sorting products by price
	//select * from Product p order by price ASC
	
	@Query("Select p From Product p order by p.price ASC")
	List<Product> getProductByPrice();
	
	
	//fetching products by above the price
	//select * from Product where price>given value
	
	@Query("select p From Product p where p.price >: price")
	List<Product> getProductAbovePrice(@Param("price") double price);
	
	
	//fetch using category
	//select * from Product where category = given category
	@Query("select p From Product p where p.category =: category")
	List<Product> getProductByCategory(@Param("category")String category);
}
	