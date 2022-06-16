@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Add Bank Details
    Given I set POST bank details api endpoint
    When I Send POST HTTP request
    Then I receive valid Response
    
  @tag2
  Scenario: Retrieve Bank Details
    Given I set GET for bank details api endpoint
    When I Send POST HTTP request for second api
    Then I receive valid Response for second api
    
    @tag3
     Scenario: Delete Bank Details
     Given I set DELETE api endpoint for bank details
     When I Send POST HTTP request for delete api
    Then I receive valid Response for delete api
  
