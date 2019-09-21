package com.testliib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;


public class HalfeBaytestNG {
	ChromeDriver driver;
	@BeforeMethod
	public void setUp() {
	
		System.setProperty("webdriver.chrome.driver", "C:\\sj_testing\\Selenium testing\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	    driver.get("https://scgi.half.ebay.com/ws/eBayISAP.dll?RegisterEnterInfo&usage=2943&ru=");	
	}
	
	
	@Test(dataProvider = "userData")
	public void halfEbayRegPageTest(String firstname, String lastname, String address1, String adddress2, String city, String state, String zipcode, String emailaddress ) {
		driver.findElementByXPath("//*[@id='firstname']").clear();
		driver.findElementByXPath("//*[@id='firstname']").sendKeys();
		
		driver.findElementByXPath("//*[@id='lastname']").clear();
		driver.findElementByXPath("//*[@id='lastname']").sendKeys();
		
		driver.findElementByXPath("//*[@id='address1']").clear();
		driver.findElementByXPath("//*[@id='address1']").sendKeys();
		
		driver.findElementByXPath("//*[@id='address2']").clear();
		driver.findElementByXPath("//*[@id='address2']").sendKeys();
		
		driver.findElementByXPath("//*[@id='city']").clear();
		driver.findElementByXPath("//*[@id='city']").sendKeys();
		
		Select sel=new Select(driver.findElementByXPath("//*[@id='state']"));
		sel.selectByValue("IN");
		
		driver.findElementByXPath("//*[@id='zip']").clear();
		driver.findElementByXPath("//*[@id='zip']").sendKeys();
		
		driver.findElementByXPath("//*[@id='email']").clear();
		driver.findElementByXPath("//*[@id='email']").sendKeys();
		
		driver.findElementByXPath("//*[@id='retype_email']").clear();
		driver.findElementByXPath("//*[@id='retype_email']").sendKeys();
	}
	
	@DataProvider(name="userData")
	public  Iterator<Object[]> getuserData() {
		ArrayList<Object[]> testData=TestUtil.getDataFromExcel1();
		return testData.iterator();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	
	}
	public static class TestUtil {
		
		static FileLib reader;
		public TestUtil(String string) {
			// TODO Auto-generated constructor stub
		}
		public static ArrayList<Object[]> getDataFromExcel1() {
			ArrayList<Object[]> myData=new ArrayList<Object[]>();
			
			try {
				reader=new FileLib("C:\\sj_testing\\Selenium testing\\src\\com\\datadriven\\test\\data.xlsx");
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
}

