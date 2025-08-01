package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer Id;
	@Column(name="product_name")
	 private String name;
		@Column(name="product_description")
	 private String description;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
 
	
}
