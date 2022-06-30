package com.qa.stepDefinitions;

import static io.restassured.RestAssured.given;

import com.qa.resources.TestDataBuild;
import com.qa.resources.Utils;

import io.cucumber.java.en.Given;



public class userStepDefinition extends Utils{

	/*RequestSpecification resp;
	ResponseSpecification responseSp;
	Response response;*/
	TestDataBuild payload = new TestDataBuild();
	
	
	@Given("User details to be created")
	public void user_details_to_be_created(io.cucumber.datatable.DataTable dataTable) throws Exception {

		
		 Utils.requestSp = given().
				spec(requestSpecification()).
				body(payload.userDetailsPayLoad(dataTable));
		
		
	}
	
	
	
	
	
	
}
