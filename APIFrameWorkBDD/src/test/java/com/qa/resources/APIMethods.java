package com.qa.resources;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIMethods {

	private String resourcePath;
	private RequestSpecification resp;
	private String method;

	public APIMethods(String method,String reourcePath,RequestSpecification resp){
	 this.method = method;
	 this.resourcePath=reourcePath;
	 this.resp=resp;
	}

	public Response getResponse() {

	    // this will refer to the object SMALL
		
		if(this.method.equals("GET")) {
			return resp.get(resourcePath) ;
			
		}else if(this.method.equals("PUT")) {
			
			return resp.put(resourcePath);
		}else if(this.method.equals("POST")) {
			
			return resp.post(resourcePath);
		}else if(this.method.equals("DELETE")) {
			
			return resp.delete(resourcePath);
		}else {
			return null;
		}
		
	   
	}
 

}
