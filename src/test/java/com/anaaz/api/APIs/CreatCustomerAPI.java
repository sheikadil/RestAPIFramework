package com.anaaz.api.APIs;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import com.anaaz.api.setup.BaseTest;

import io.restassured.response.Response;

public class CreatCustomerAPI extends com.anaaz.api.setup.BaseTest{

	public static Response sendPostRequestToCreateCustomeAPIWithValidAuthKey(HashMap<String,String> data) {

		//Sample Comment
		Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
		.formParam("name", data.get("Name"))		
		.formParam("email",  data.get("Email"))
		.formParam("description",  data.get("Description"))
		.post(config.getProperty("customerEndPoint"));
		
		return response;
	}

	public static Response sendPostRequestToCreateCustomeAPIWithinValidAuthKey(HashMap<String,String> data) {

		 Response response =  given().auth().basic(config.getProperty("inValidSecretKey "), "")
				  .formParam("name", data.get("Name"))		
				  .formParam("email",  data.get("Email"))
				  .formParam("description",  data.get("Description"))
				  .post(config.getProperty("customerEndPoint"));
		 return response;
	}
}
