package com.smartsoft.pruebasmartsoft.models;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bill")
public class Bill {
	
	@Id
	private String id;
	
	private String id_Client;
	private String date;
	
	public Bill(String id_Client, String date) {
		super();
		this.id_Client = id_Client;
		this.date = date;
	}
	
	public String getNum_bill() {
		return id;
	}
	public void setNum_bill(String num_bill) {
		this.id = num_bill;
	}
	public String getId_Client() {
		return id_Client;
	}
	public void setId_Client(String id_Client) {
		this.id_Client = id_Client;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
}
