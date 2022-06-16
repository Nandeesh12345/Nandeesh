package com.example.sample.mapper;

import com.example.sample.bo.BankBO;
import com.example.sample.entity.BankEO;

public interface BankMapper {
	BankBO modelToDto(BankBO ue);
	BankEO dtoToModel(BankEO ue);
}
