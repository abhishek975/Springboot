package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app")
public class ProductController {
   @Autowired
	private ProductService  productService;
   @PostMapping("/storeproducts")
	public ResponseEntity<?> storeProduct(@Valid @RequestBody Product p){
		Product savedProduct=productService.insertProduct(p);
		return ResponseEntity.status(HttpStatus.CREATED).body("Product saved successfully");
	}
   @GetMapping("/getProduct/{id}")
   public ResponseEntity<?> searchProduct(@PathVariable Long id) {
       Optional<Product> p = productService.getProduct(id);
   if(p.isPresent())
   {
	 return  ResponseEntity.ok(p);
   }
 return ResponseEntity
         .status(HttpStatus.NOT_FOUND)
         .body("Product not found with id: " + id);     
   }  

@GetMapping("/allProducts")
public ResponseEntity<?> allProducts(){
	List<Product> allproducts=productService.getEveryProduct();
	 return  ResponseEntity.ok(allproducts);
}
@PutMapping("/updateProduct/{id}")
public ResponseEntity<?> updateproduct(@PathVariable Long id,@Valid @RequestBody Product p){
	productService.updateProduct(id, p);
	return ResponseEntity.status(HttpStatus.CREATED).body("Product updated successfully");
}
@DeleteMapping("/removeProduct/{id}")
public ResponseEntity<?> updateProduct(@PathVariable Long id){
	productService.removeProduct(id);
	return ResponseEntity.status(HttpStatus.CREATED).body("Product deleted successfully");
}
}
