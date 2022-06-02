package com.qa.resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification requestSp;

	public RequestSpecification requestSpecification() throws Exception {

		if(requestSp == null) {

			PrintStream log = new PrintStream(new FileOutputStream("logging.text"));

			requestSp = new RequestSpecBuilder().setBaseUri(getGlobalProperties("BaseURL"))
					.addQueryParam("key", "qaclick123")

					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))

					.setContentType(ContentType.JSON)
					.build();

			return requestSp;
		}
		return requestSp;

	}

	public static String getGlobalProperties(String key) throws IOException {

		FileInputStream fis = new FileInputStream("../APIFrameWorkBDD/src/test/java/com/qa/resources/global.properties");

		Properties prop = new Properties();

		prop.load(fis);

		return (String) prop.get(key);

	}

	public String getJsonPathValue(Response resp, String key) {

		String res = resp.asString();
		JsonPath jp = new JsonPath(res);
		return jp.get(key).toString();

	}

}
