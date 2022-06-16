package com.example.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.entity.BankEO;
import com.example.sample.service.ExternalService;

@RestController
public class FeignController {

	@Autowired
	private ExternalService externalService;
	@GetMapping("/CallByFeign")
	public List<BankEO> retrival(){
	return externalService.retrive();	
		
	}
}
