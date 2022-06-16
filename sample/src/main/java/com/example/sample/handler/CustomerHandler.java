package com.example.sample.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component(value="customerHandler")
public class CustomerHandler {
	Logger logger = (Logger) LoggerFactory.getLogger(CustomerHandler.class);
	public String findall(){
		RestTemplate restTemplate = new RestTemplate();
		String uri="http://localhost:8080/retrieval";
		String result=restTemplate.getForObject(uri, String.class);
		if(result.length()>0) {
			logger.info("The data is successfully Retreived");
			return result;
			
		}else {
			logger.info("The data is available ");
			return null;
			
		}
		
		
	}
}
