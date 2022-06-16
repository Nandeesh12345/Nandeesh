package com.example.cloudgatewayservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cloudgatewayservice.service.CircuitBreakerService;



@RestController
public class ReadingApplicationController {

	
	@Autowired 
	CircuitBreakerService circuitBreakerService;
	 
	@RequestMapping("/test-hystrix")
	public String StringtoRead() {
		return circuitBreakerService.readProductDetails();
	}
	
}
