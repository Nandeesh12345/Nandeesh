package com.example.demo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.example.demo.dao.BankRepo;
import com.example.demo.entity.BankEO;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class DemoApplicationTests {

	  @MockBean
	  private BankRepo bankRepo;
	  
	 @Test
	 void saveBankTest() {
		 BankEO bank=new BankEO(102,"Nandi","Mysuru");
		 when(bankRepo.save(bank)).thenReturn(1);
		  assertEquals(1,bankRepo.save(bank));
		 
	}
	 @Test
	 void findall() {
		 when(bankRepo.findall()).thenReturn(Stream.of(new BankEO(105,"Vinay","Kerala"),new BankEO(106,"Arun","Pune")).collect(Collectors.toList()));
		 assertEquals(2,bankRepo.findall().size());
	 }
	 @Test
	 void deletebyId() {
		 when(bankRepo.deleteById(101)).thenReturn(1);
		 assertEquals(200,bankRepo.deleteById(101));
		 
	 }

}
