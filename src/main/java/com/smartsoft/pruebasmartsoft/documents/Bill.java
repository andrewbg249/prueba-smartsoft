package com.smartsoft.pruebasmartsoft.documents;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(collection = "Bill")
public class Bill implements Serializable {
	
	private String num_bill;
	@NonNull
	private String id_Client;
	private String date;
	
	public String getNum_bill() {
		return num_bill;
	}
	public void setNum_bill(String num_bill) {
		this.num_bill = num_bill;
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
