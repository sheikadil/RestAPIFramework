package com.anaaz.api.testcases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.anaaz.api.APIs.CreatCustomerAPI;
import com.anaaz.api.listeners.ExtentListeners;
import com.anaaz.api.setup.BaseTest;
import com.anaaz.api.utilities.DataUtil;
import io.restassured.response.Response;

public class CreateCustomerTest extends BaseTest{

	@Test(dataProviderClass=DataUtil.class,dataProvider="getData")
	public void validateCreateCustomerAPIWithValidSecretKey(HashMap<String,String> data) {
		
		Response response = CreatCustomerAPI.sendPostRequestToCreateCustomeAPIWithValidAuthKey(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(dataProviderClass=DataUtil.class,dataProvider="getData") 
	public void inValidateCreateCustomerAPIWithInValidSecretKey(HashMap<String,String> data) {
	  
	  Response response = CreatCustomerAPI.sendPostRequestToCreateCustomeAPIWithinValidAuthKey(data);
	  ExtentListeners.testReport.get().info(data.toString());
	  response.prettyPrint(); System.out.println(response.statusCode());
	  Assert.assertEquals(response.statusCode(), 200);
	 }
	 
	
	
}
