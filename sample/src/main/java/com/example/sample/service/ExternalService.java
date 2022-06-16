package com.example.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.sample.entity.BankEO;



@FeignClient(name="External-Service", url="http://localhost:8080")
public interface ExternalService {

	
	@GetMapping(value="/retrieval",consumes=MediaType.APPLICATION_JSON_VALUE)
	List<BankEO> retrive();
}
