package com.testliib;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTExcel {
	ChromeDriver driver;

	@Test(dataProvider = "testData")
	public void DemoProject(String userName, String password) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\sj_testing\\Selenium testing\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	    driver.get("https://newtours.demoaut.com");
	    driver.findElementByName("username").sendKeys(userName);
	    driver.findElementByName("password").sendKeys(password);
	    driver.findElementByName("login").click();
	    Thread.sleep(3000);
	    
	    Assert.assertTrue(driver.getTitle().matches("Find a flight:Mercury Tours:"),"Invalid Credentials");
	    System.out.println("Login successful'");
	    driver.quit();
	    
	}   
	   
	
	@DataProvider(name="testData")
	public Object[][] TestDataFeed(){
		Object[][] myData=new Object[1][];
	
		ReadExcelFile config=new ReadExcelFile("C:\\sj_testing\\Test Framework\\src\\com\\test\\data.xlsx");
		int rows=config.getRowCount(1);
		Object[][] credentials=new Object[rows][2];
		
		for(int i=0; i<=rows;i++) {
		credentials[i][0]=config.getData(0,i,0);
		credentials[i][1]=config.getData(0, i, 1);	
		}
		
		

		return myData;
		
	}
	
	
}
