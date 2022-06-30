package com.qa.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import pojo.Location;
import pojo.Place;
import user.Pojo.User;

public class TestDataBuild extends Utils{


	public Place placePayload(String name,String language,String address) {

		// Preparing JSON request body 
		Place placeJson = new Place();
		placeJson.setAccuracy(50);
		placeJson.setName(name);
		placeJson.setPhone_number("(+91) 983 893 3937");
		placeJson.setAddress(address);
		placeJson.setWebsite("http://google.com");
		placeJson.setLanguage(language);

		// Setting list of nested Array values
		List<String> typesList = new ArrayList<String>();

		typesList.add("shoe park");
		typesList.add("shop");

		placeJson.setTypes(typesList);

		Location locDetails = new Location();

		locDetails.setLat(-38.383494);
		locDetails.setLng(33.427362);

		placeJson.setLocation(locDetails);
		
		return placeJson;

	}

	public String deletePlacePayload(String place_Id) {
		
		return "{\"place_id\":\""+place_Id+"\"}";
		
	}
	
	public String userDetailsPayLoad(DataTable dataTable) throws Exception {
		
						
		 Map <String,String>data = dataTable.transpose().asMap();
		 
		 return requestBodyMapper(data,User.class);
		 		
		 
		
	}
	
	
}
