package com.smartsoft.pruebasmartsoft.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "Detail")
public class Detail{
	
	@Id
	private String num_detail;
	private String id_bill;
	private String id_product;
	private Integer amount;
	private Double cost;

	public Detail(String id_bill, String id_product, Integer amount, Double cost) {
		super();
		this.id_bill = id_bill;
		this.id_product = id_product;
		this.amount = amount;
		this.cost = cost;
	}
	
	public String getNum_detail() {
		return num_detail;
	}
	public void setNum_detail(String num_detail) {
		this.num_detail = num_detail;
	}
	public String getId_bill() {
		return id_bill;
	}
	public void setId_bill(String id_bill) {
		this.id_bill = id_bill;
	}
	public String getId_product() {
		return id_product;
	}
	public void setId_product(String id_product) {
		this.id_product = id_product;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
}
