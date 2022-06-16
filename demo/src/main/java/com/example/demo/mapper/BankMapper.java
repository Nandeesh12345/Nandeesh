package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.bo.BankBO;
import com.example.demo.entity.BankEO;
@Mapper(componentModel="spring")
public interface BankMapper {
	BankBO modelToDto(BankEO ue);
	BankEO dtoToModel(BankBO ue);
}
