package com.anaaz.api.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.anaaz.api.utilities.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest {

	public static Properties config = new Properties();
	private FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\testData\\TestData.xlsx");
	
	@BeforeSuite
	public void setUp() {
		
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\proprties\\config.properties");
			config.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestAssured.baseURI = config.getProperty("baseURI");
		RestAssured.basePath = config.getProperty("basePath");
	}
	
	
	@AfterSuite
	public void	tearDown() {
		
	}
}
