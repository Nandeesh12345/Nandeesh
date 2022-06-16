package com.example.demo.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BankEO;
import com.example.demo.service.BankService;
import com.example.demo.service.BankServiceImpl;
@RestController
public class BankController {
	
	@Autowired
	BankService bankService;
	Logger logger = (Logger) LoggerFactory.getLogger(BankController.class);
	
	@ResponseBody
    @RequestMapping(value = "/create", headers = {
            "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public int createTutorial(@RequestBody BankEO bank) {
		logger.info("adding a user details");
		
		return bankService.save(new BankEO(bank.getCustId(), bank.getName(), bank.getAddress()));
		
	}
	@GetMapping("/user/{custId}")
	public BankEO getUser(@PathVariable("custId") int custId) {
		logger.info("finding a user details");
		return bankService.getById(custId);
	}
	@RequestMapping(value="/retrieval",method = RequestMethod.GET)
	public List<BankEO> retrieveall() {
		logger.info("retreiving the all user details");
		return bankService.findall();
	}
	@DeleteMapping("/healthCheck/{custId}")
	public int deleteUser(@PathVariable("custId") int custId) {
		logger.info("deketing the user details depending on the custId");
		return bankService.deleteById(custId);
	}
}
