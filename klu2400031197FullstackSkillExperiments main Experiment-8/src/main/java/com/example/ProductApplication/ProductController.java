package com.example.ProductApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	
	@PostMapping("/insert")
	public void insert(@RequestBody Product p) {
		ps.addProduct(p);
	}
	
	@GetMapping("/fetch")
	public List<Product> fetch() {
		
		return ps.fetch();
	}
	
	@GetMapping("/findbycategory")
	public List<Product> findByCategory(@RequestParam String category){
		return ps.fetchBycategory(category);
		
	}
}
	
