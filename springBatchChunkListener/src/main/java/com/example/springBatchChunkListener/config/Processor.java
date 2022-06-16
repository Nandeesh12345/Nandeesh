package com.example.springBatchChunkListener.config;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<Employee, Employee>{
	
	{
		
	}

	@Override
	public Employee process(Employee employee) throws Exception {
		System.out.println("Inserting employee : " + employee);
	    return employee;
	}
}
