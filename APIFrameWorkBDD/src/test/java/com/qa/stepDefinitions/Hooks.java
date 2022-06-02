package com.qa.stepDefinitions;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws Exception {

		StepDefinition sd = new StepDefinition();
		if(StepDefinition.place_id==null) {
			sd.add_place_payload("New House", "Hindi - IN",	"Panumbre Warun");
			sd.user_calls_api_with_http_request("AddPlace","POST");
			sd.verify_place_id_is_created_which_maps_to_using_api("New House", "GetPlace");
		}


	}

}
