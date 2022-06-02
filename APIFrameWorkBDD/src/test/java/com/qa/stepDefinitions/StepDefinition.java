package com.qa.stepDefinitions;

import com.qa.resources.APIMethods;
import com.qa.resources.APIResources;
import com.qa.resources.TestDataBuild;
import com.qa.resources.Utils;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class StepDefinition extends Utils{

	RequestSpecification resp;
	ResponseSpecification responseSp;
	Response response;
	TestDataBuild payload = new TestDataBuild();
	
	static String place_id;


	@Given("Add Place Payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws Exception {

		resp = given().
				spec(requestSpecification()).
				body(payload.placePayload(name,language,address));


	}
	@When("user calls {string} API with {string} HTTP Request")
	public void user_calls_api_with_http_request(String resource,String method) {


		APIResources apiResource = APIResources.valueOf(resource);
		System.out.println("Resource :"+apiResource.getResourcePath());		
		responseSp = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
		
		APIMethods apiResponse = new APIMethods(method.toUpperCase(),apiResource.getResourcePath(),resp);
		
		response = apiResponse.getResponse();
				

	}
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer statusCode) {
		
				
		assertTrue("Status code not matching", statusCode.equals(response.getStatusCode()));


	}
	@And("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedValue) {

		String actualValue = getJsonPathValue(response, key);
		assertTrue("Json doesnot contain value",expectedValue.equals(actualValue));


	}

	@And("verify place_id is created which maps to {string} using {string} API")
	public void verify_place_id_is_created_which_maps_to_using_api(String expectedName, String resource) throws Exception {
	    
		
		place_id = getJsonPathValue(response, "place_id");
		resp = given().spec(requestSpecification()).queryParam("place_id", place_id);
		
		
		user_calls_api_with_http_request(resource, "GET");
		
		String actualName = getJsonPathValue(response,"name");
		
		assertTrue("Name value not mapping with GetPlace API",expectedName.equals(actualName));
		
	}
	
	@Given("DeletePlace payload")
	public void delete_place_payload() throws Exception {
	    
		resp = given().spec(requestSpecification())
				.body(payload.deletePlacePayload(place_id));
				
	}

}
