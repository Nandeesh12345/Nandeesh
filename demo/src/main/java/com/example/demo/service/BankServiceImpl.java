package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BankRepo;
import com.example.demo.entity.BankEO;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.EmptyInputException;
import com.example.demo.exception.NoRecordException;

@Component(value="bankService")
public class BankServiceImpl implements BankService{

	@Autowired
	private BankRepo bankDao;
	
	
	public int save(BankEO bank) {
		if(bank.getName().isEmpty() || bank.getName().length()==0) {
			throw new EmptyInputException("601","Inputs are empty");
		}
		return bankDao.save(bank);
	}
	public List<BankEO> findall(){
		List<BankEO>findall=bankDao.findall();
		if(findall.isEmpty()) {
			throw new NoRecordException("203","No records found");
		}
		return bankDao.findall();
		 
	}
	
	public int deleteById(int custid) {
		int del=bankDao.deleteById(custid);
		if(del==0) {
			throw new BusinessException("201","No data");
		}
	return bankDao.deleteById(custid);
	}
	
	public BankEO getById(int custid) {
		
		return bankDao.getById(custid);
	}
	
	
}
