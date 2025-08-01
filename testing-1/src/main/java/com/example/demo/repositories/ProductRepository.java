package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import com.example.demo.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
