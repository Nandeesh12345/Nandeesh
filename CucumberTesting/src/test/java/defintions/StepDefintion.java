package defintions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepDefintion {

	String addURI ;
	String retrieveURI;
	String deleteURI;
	ResponseEntity<String> createAPIResponse;
	String retreivalAPIResponse;
	ResponseEntity<String> deleteAPIResponse;
	Logger logger = (Logger) LoggerFactory.getLogger(StepDefintion.class);
	   int id=103;
	   String name="Nnadi";
	   String adress="Kerala";
	@Given("^I set POST bank details api endpoint$")
	  public void given() throws Throwable {
		 addURI = "http://localhost:8080/create";
	      logger.info("Add URL :"+addURI);
	  }

	  @When("^I Send POST HTTP request$")
	  public void when() throws Throwable {
		   RestTemplate restTemplate = new RestTemplate ();
		   
		   String jsonBody="{\"cust_Id\":\""+103+"\",+\"name\":\"\""+name+"\"adress\":\""+adress+"}";
		   createAPIResponse=restTemplate.postForEntity(addURI, jsonBody, String.class);
	  }

	  @Then("^I receive valid Response$")
	  public void then() throws Throwable {
		  Assert.assertEquals(200, createAPIResponse.getStatusCode());
		  logger.info("Bank details is Added successfully");
		  
	}	 
	  @Given("^I set GET for bank details api endpoint$")
	  public void given1() throws Throwable {
		 retrieveURI = "http://localhost:8080/retrieval";
		 logger.info("Retreival URL :"+ retrieveURI);
		
	  }
	  @When("^I Send POST HTTP request for second api$")
	  public void when1() throws Throwable {
		   RestTemplate restTemplate = new RestTemplate ();
		   retreivalAPIResponse=restTemplate.getForObject( retrieveURI, String.class);
	  }
	  @Then("^I receive valid Response for second api$")
	  public void then1() throws Throwable {
		  Assert.assertEquals(50,  retreivalAPIResponse.length());
		  logger.info("Bank details sucessfully retreived");
		}
	  @Given("^I set DELETE api endpoint for bank details$")
      public void given2() throws Throwable {
	 deleteURI = "http://localhost:8080/healthCheck";
	 logger.info("Retreival URL :"+ deleteURI);
    
}
	  @When("^I Send POST HTTP request for delete api$")
	  public void when2() throws Throwable {
		   RestTemplate restTemplate = new RestTemplate ();
		   String jsonBody="{\"cust_Id\":\""+102+"}";
		   deleteAPIResponse=restTemplate.postForEntity(retrieveURI, jsonBody, String.class);
		   
	  }  
	  @Then("^I receive valid Response for delete api$")
	  public void then2() throws Throwable {
		 Assert.assertEquals(1, deleteAPIResponse.getStatusCodeValue());
		 logger.info("Bank details are sucessfully deleted");
		}
}