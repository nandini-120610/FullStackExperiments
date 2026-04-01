package com.example.ProductApplication;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	List<Product> findByCategory(String category);
	List<Product> findByPriceBetween(double min, double max);
	
	//Sorting products by price
	//select * from Product order by price ASC/DESC;
	@Query("select p From Product p order by p.price ASC")
	List<Product> getProductByPrice();
	
	//Fetching products above a price value
	//select * from product where price>given value
	@Query("select p from Product p where p.price>:price")
	List<Product> getProductAbovePrice(@Param("price") float price);
	
	
	//Fetching products by category
	//select * from product where category=given value
	@Query("select p from Product p where p.category=:category")
	List<Product> getProductsByCategory(@Param("category") String category);

	
	
	
	
	

}
