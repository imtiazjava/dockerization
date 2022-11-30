package com.cgi.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.main.entity.Product;
import com.cgi.main.service.ProductService;

@RestController
@RequestMapping("/api/")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public String welcome() {
		return "Welcome-To-Home-Page";
	}
	
	@PostMapping(path="save")
	public String saveProduct(@RequestBody Product product)
	{
		Product pr=this.productService.saveProduct(product);
		if(pr!=null)
			return "SUCCESS";
		else
			return "failure";
	}
	
	@GetMapping(path="products",produces="application/json")
	public ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok(this.productService.getProducts());
	}
}
