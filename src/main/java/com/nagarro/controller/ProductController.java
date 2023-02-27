package com.nagarro.controller;

import java.util.List;

import com.nagarro.entity.Product;
import com.nagarro.exception.ProductNotFoundException;
import com.nagarro.service.ProductService;
import com.nagarro.utils.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	public ProductService productService;

	@PostMapping
	public ResponseEntity<Object> addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return ResponseHandler.generateResponse("Product added Successfully!", HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return ResponseHandler.generateResponse("Products Fetched Successfully!", HttpStatus.OK, products);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable long id) {
		int status = productService.deleteProduct(id);
		if (status == 1)
			return ResponseHandler.generateResponse("Product Deleted Successfully", HttpStatus.OK);

		throw new ProductNotFoundException("Invalid Product Id");

	}
}
