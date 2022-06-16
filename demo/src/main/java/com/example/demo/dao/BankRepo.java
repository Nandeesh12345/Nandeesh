package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.BankEO;

public interface BankRepo {
	
	int save(BankEO bank);
	BankEO getById(int custId);
	List<BankEO> findall();
	int deleteById(int custId);
}
