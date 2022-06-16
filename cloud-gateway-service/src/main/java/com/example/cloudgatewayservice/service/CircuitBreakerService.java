package com.example.cloudgatewayservice.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@Service
public class CircuitBreakerService {
	
	
	 @HystrixCommand(fallbackMethod = "testFallBack")
	 public String readProductDetails() {
	        return new RestTemplate().getForObject("http://localhost:8080/retrieval", String.class);
	    }
	 
	 public String testFallBack() {
	        return "product not found.";
	}
	
	
	  
}
