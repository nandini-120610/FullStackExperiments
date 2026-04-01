package com.example.ProductApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository pr;
	
	public void addProduct(Product p) {
		pr.save(p);
	}

	public List<Product> fetch() {
		return pr.findAll();
	}
	
	public List<Product> fetchBycategory(String category){
		return pr.findByCategory(category);
		
	}
	

}
