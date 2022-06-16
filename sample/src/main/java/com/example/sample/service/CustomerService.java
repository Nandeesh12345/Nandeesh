package com.example.sample.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.example.sample.handler.CustomerHandler;

@Component(value="customerService")
public class CustomerService {

	@Autowired
	private CustomerHandler customerHandler;
	
	public String findall(){
		return customerHandler.findall();
		 
	}
}
