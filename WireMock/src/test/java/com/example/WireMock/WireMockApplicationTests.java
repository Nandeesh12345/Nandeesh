package com.example.WireMock;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.boot.test.context.SpringBootTest;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import junit.framework.Assert;
@SpringBootTest
class WireMockApplicationTests {

	Logger logger = (Logger) LoggerFactory.getLogger(WireMockApplicationTests.class);
	  WireMockServer wireMockServer=new WireMockServer();
	  
	  @BeforeClass void setup() { wireMockServer.start(); }
	  
	  @SuppressWarnings("deprecation")
	 
	  @Test
	  void testcase() {
	  String retreivalAPI="http://localhost:8080/retrieval";
	  logger.info("Api to test:"+retreivalAPI);
	 
	 io.restassured.response.Response r=RestAssured.given().header(new
	  Header("Accept", "application/json")).when().get(retreivalAPI);
	 logger.info("Response after the API"+r);
	  Assert.assertEquals(r.getStatusCode(), 200);
	  }
	  @Test
	  void testcase1() {
		  String deleteAPI="http://localhost:8080/healthCheck/101";
		  logger.info("Api to test:"+deleteAPI);
		  io.restassured.response.Response r=RestAssured.given().header(new
				  Header("Accept", "application/json")).when().get(deleteAPI);
		  Assert.assertEquals(r.getStatusCode(), 200);
	  }
	  
	  
	  @AfterClass void tearDown() { wireMockServer.stop(); }
	 
}
