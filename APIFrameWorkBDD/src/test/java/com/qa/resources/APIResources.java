package com.qa.resources;

public enum APIResources {

		
	AddPlace("/maps/api/place/add/json"),
	DeletePlace("/maps/api/place/delete/json"),
	GetPlace("/maps/api/place/get/json"),
	UpdatePlace("/maps/api/place/update/json");
	
	private String resource;
	
	APIResources(String resource){
		this.resource=resource;	
	}
	
	public String getResourcePath() {
		
		return resource;
		
	}
	
	
}
