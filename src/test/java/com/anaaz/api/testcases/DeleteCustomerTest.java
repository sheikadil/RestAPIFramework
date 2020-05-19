package com.anaaz.api.testcases;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.anaaz.api.APIs.DeleteCustomerAPI;
import com.anaaz.api.listeners.ExtentListeners;
import com.anaaz.api.setup.BaseTest;
import com.anaaz.api.utilities.DataUtil;
import com.anaaz.api.utilities.TestUtil;

import io.restassured.response.Response;

public class DeleteCustomerTest extends BaseTest{

	@Test(dataProviderClass=DataUtil.class,dataProvider="getData")
	public void deleteCustomer(HashMap<String,String> data) {
		
		Response response = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerAPIWithValidId(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.statusCode());
		
		/*
		 * String actual_id = response.jsonPath().get("id").toString();
		 * System.out.println(response.jsonPath().get("id"));
		 * Assert.assertEquals(response.statusCode(), 200);
		 * 
		 * Assert.assertEquals(actual_id, data.get("ID"));
		 */
		/*
		 * JSONObject jObject = new JSONObject(response.asString());
		 * System.out.println(jObject.has("id"));
		 */
		String actual_id = TestUtil.getJsonKeyValue(response.asString(), "id");
		Assert.assertEquals(actual_id, data.get("ID"));
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"),"ID key is not present in the JSON response");
		
	}
	
	
	
	
}
