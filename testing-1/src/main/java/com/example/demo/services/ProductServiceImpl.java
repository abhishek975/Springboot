package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	
    public Product insertProduct(Product p) {
    	return productRepository.save(p);
    }
	
    public List<Product> getEveryProduct() {
    	return productRepository.findAll();
    }
    public Optional<Product> getProduct(Long Id) {
    	return productRepository.findById(Id);
    }
    
    public Product updateProduct(Long Id,Product p) {
    	Optional<Product> checkProduct=getProduct(Id);
    	if(checkProduct.isPresent())
    	{ Product pexist=checkProduct.get();
    		pexist.setName(p.getName());
    		pexist.setDescription(p.getDescription());
    		return checkProduct.get();
    	}
    	else
    		throw new RuntimeException("Product not found with id: " + Id);
    }
    public void removeProduct(Long Id) {
        Product product = getProduct(Id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }
}
