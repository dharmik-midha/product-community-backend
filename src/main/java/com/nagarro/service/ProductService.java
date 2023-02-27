package com.nagarro.service;

import java.util.List;

import com.nagarro.entity.Product;

public interface ProductService {
	
	Product addProduct(Product product);
	List<Product> getAllProducts();
	int deleteProduct(long productId);
}
