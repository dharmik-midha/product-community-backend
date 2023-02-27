package com.nagarro.serviceimpl;

import java.util.List;

import com.nagarro.dao.ProductDao;
import com.nagarro.entity.Product;
import com.nagarro.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	public ProductDao productRepo;
	
	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public int deleteProduct(long productId) {
		try {			
		productRepo.deleteById(productId);
		return 1;
		}
		catch(Exception e){
			return 0;
		}
	}
}
