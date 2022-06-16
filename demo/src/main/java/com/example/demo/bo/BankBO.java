package com.example.demo.bo;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Getter;

public class BankBO {
	@Id
	@Column
	private int custId;
	@Column
	private String name;
	@Column
	private String address;
	public BankBO(int custId, String name, String address) {
		super();
		this.custId = custId;
		this.name = name;
		this.address = address;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
