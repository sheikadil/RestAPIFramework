package com.anaaz.api.APIs;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import com.anaaz.api.APIs.CreatCustomerAPI;
import com.anaaz.api.listeners.ExtentListeners;
import com.anaaz.api.setup.BaseTest;

import io.restassured.response.Response;

public class DeleteCustomerAPI extends com.anaaz.api.setup.BaseTest{

	public static Response sendDeleteRequestToDeleteCustomerAPIWithValidId(HashMap<String,String> data) {
		
		Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
				.delete(config.getProperty("customerEndPoint")+"/"+data.get("ID"));
				
		return response;
	}
}
