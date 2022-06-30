Feature: Validate the User API's
  
  Scenario: Verify Create User API
    Given User details to be created
    |name|job|
    |Test Name | leader|
    When user calls "CreateUser" API with "POST" HTTP Request
    Then the API call is success with status code 201

  
