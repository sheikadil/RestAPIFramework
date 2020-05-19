package com.anaaz.api.utilities;

import org.json.JSONObject;

import com.anaaz.api.listeners.ExtentListeners;

public class TestUtil {

	public static boolean jsonHasKey(String json,String key) {
		
		JSONObject jObject = new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating the presence of Key : "+key);
		return jObject.has(key);
	}
	
	public static String getJsonKeyValue(String json,String key) {
		
		JSONObject jObject = new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating Value of Key : "+key);
		return jObject.getString(key).toString();
	}
}
