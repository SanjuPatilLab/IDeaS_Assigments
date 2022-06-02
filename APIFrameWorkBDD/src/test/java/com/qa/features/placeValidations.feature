Feature: Validating Place API's
	@AddPlace @Regression
  Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI
    Given Add Place Payload "<name>" "<language>" "<address>"
    When user calls "AddPlace" API with "POST" HTTP Request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_id is created which maps to "<name>" using "GetPlace" API
		
    Examples: 
      | name                | language   | address        |
      | New Frontline house | English-IN | Panumbre Warun |
 #   	| Old Frontline house | Marathi-IN | Panumbre Warun	|

	@DeletePlace @Regression
	Scenario: Verify if Delete Place functionality is working
	
		Given DeletePlace payload
		When user calls "DeletePlace" API with "POST" HTTP Request
    Then the API call is success with status code 200
    And "status" in response body is "OK"