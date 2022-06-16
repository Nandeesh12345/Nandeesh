package com.example.sample;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.tomakehurst.wiremock.WireMockServer;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import junit.framework.Assert;


class SampleApplicationTests {

	/*
	 * WireMockServer wireMockServer=new WireMockServer();
	 * 
	 * @BeforeClass void setup() { wireMockServer.start(); }
	 * 
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Test void testcase() { String testApi="http://localhost:8080/retrieval";
	 * System.out.println("Service to be hit");
	 * 
	 * io.restassured.response.Response r=RestAssured.given().header(new
	 * Header("Accept", "application/json")).when().get(testApi);
	 * Assert.assertEquals(r.getStatusCode(), 200); }
	 * 
	 * 
	 * @AfterClass void tearDown() { wireMockServer.stop(); }
	 */

}
