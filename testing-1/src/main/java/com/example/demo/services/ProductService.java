package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Product;

public interface ProductService {
	public Product insertProduct(Product p);
	 public Optional<Product> getProduct(Long Id);
	 public Product updateProduct(Long Id,Product p);
	 public void removeProduct(Long Id);
	 public List<Product> getEveryProduct();
	 
}
