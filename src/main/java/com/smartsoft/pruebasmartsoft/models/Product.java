package com.smartsoft.pruebasmartsoft.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "Product")
public class Product{
	@Id
	private String id;
	private String name;
	private Double cost;
	private Integer stock;
	
	public Product(String name, Double cost, Integer stock) {
		super();
		this.name = name;
		this.cost = cost;
		this.stock = stock;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}
