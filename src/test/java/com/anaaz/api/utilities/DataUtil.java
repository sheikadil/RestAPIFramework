package com.anaaz.api.utilities;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

import com.anaaz.api.setup.BaseTest;

public class DataUtil  extends BaseTest{

	@DataProvider(name="getData",parallel=true)
	public Object[][] getData(Method m) {
		
		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\testData\\TestData.xlsx");
		int rows =excel.getRowCount("TestData");
		//System.out.println("Total Rows are "+rows);
		
		String testName = m.getName();
		
		int testCaseRowNum=1;
		
		for(testCaseRowNum=1;testCaseRowNum<=rows;testCaseRowNum++) {
			
			String testCaseName = excel.getCellData("TestData", 0, testCaseRowNum);
			if(testCaseName.equalsIgnoreCase(testName)) {
				break;
			}	
		}
		//System.out.println("TestCase starts from row num: "+testCaseRowNum);
		
		//Checking total rows in test case
		int dataStartRowNum = testCaseRowNum +2;
		
		int testRows = 0;
		while(!excel.getCellData("TestData", 0, dataStartRowNum+testRows).equals("")) {
			testRows++;
		}
		//System.out.println("Total Rows of Data are "+testRows);
		
		//Checking total columns in test case
		
		int colStartColNum = testCaseRowNum+1;
		int testCols=0;
		while(!excel.getCellData("TestData", testCols, colStartColNum).equals("")) {
			testCols++;
		}
		//System.out.println("Total Columns are "+testCols);
		
		//Printing data
		Object [][] data = new Object[testRows][1];
		
		int i=0;
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+testRows;rNum++) {
			
			HashMap<String,String> map = new HashMap<String,String>();
			for(int cNum=0;cNum<testCols;cNum++) {
				//System.out.println(excel.getCellData("TestData", cNum, rNum));
				String value = excel.getCellData("TestData", cNum, rNum);
				String key = excel.getCellData("TestData", cNum, colStartColNum);
				map.put(key, value);
			}
			data[i][0] = map;
			i++;
		}
		
		return data;
	}
}
