package com.example.springBatchH2toCSV.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<Student,Student>{
	Logger logger = (Logger) LoggerFactory.getLogger(StudentProcessor.class);

	@Override
	public Student process(Student item) throws Exception {
		logger.info("Student Id: " + item.getStudentId() + 
        		", Student Name: " + item.getStudentName() + ", Student Age:" + item.getStudentAge());
		return new Student(item.getStudentId(),item.getStudentName(),item.getStudentAge()); 
	}
	
	

}
