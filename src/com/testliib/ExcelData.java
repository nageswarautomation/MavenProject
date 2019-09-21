package com.testliib;

import java.util.ArrayList;

public class ExcelData {
	
static Excel_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel() {
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		
		try {
			reader=new Excel_Reader("C:\\sj_testing\\Selenium testing\\src\\com\\datadriven\\test\\data.xlsx");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		for(int rowNum=2; rowNum<=reader.getRowCount("testData");rowNum++) {
			String firstname=reader.getCellData("testData", "firstname", rowNum);
			String lastname=reader.getCellData("testData", "lastname", rowNum);
			String address1=reader.getCellData("testData", "address1", rowNum);
			String address2=reader.getCellData("testData", "address2", rowNum);
			String city=reader.getCellData("testData", "city", rowNum);
			String state=reader.getCellData("testData", "state", rowNum);
			String zipcode=reader.getCellData("testData", "zipcode", rowNum);
			String emailaddress=reader.getCellData("testData", "emailadrress", rowNum);
			Object ob[]= {firstname, lastname, address1, address2, city, state, zipcode, emailaddress};
			myData.add(ob);

			
		}
		return myData;
	}
}
