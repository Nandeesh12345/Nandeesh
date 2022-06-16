package com.example.sample.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.entity.BankEO;
//import com.example.sample.entity.Bank;
import com.example.sample.service.CustomerService;
import com.example.sample.service.ExternalService;



@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	
	@GetMapping("/CallByRest")
	public String retrieveall() {
	return customerService.findall();
	}
	

}
