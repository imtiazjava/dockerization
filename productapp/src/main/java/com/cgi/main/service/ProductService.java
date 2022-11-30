package com.cgi.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.main.entity.Product;
import com.cgi.main.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {
		 
		return this.productRepository.save(product);
	}

	public List<Product> getProducts() {
		 
		return this.productRepository.findAll();
	}

}
