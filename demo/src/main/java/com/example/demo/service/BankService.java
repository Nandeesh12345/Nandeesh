package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BankEO;

public interface BankService {
	int save(BankEO bank);
	BankEO getById(int custId);
	List<BankEO> findall();
	int deleteById(int custId);
	
}
