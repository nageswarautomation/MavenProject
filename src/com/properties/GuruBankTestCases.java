package com.properties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GuruBankTestCases {
	WebDriver  driver;
	public PropertiesFile prop;
	@BeforeMethod
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\sj_testing\\Selenium testing\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
		//driver.get("http://toolsqa.com/automation-practice-form/");
		prop = new PropertiesFile();
		
	}
	@Test
	public void login() {
		driver.findElement(prop.getLocator("userName")).sendKeys("mngr222055");
		driver.findElement(prop.getLocator("userPassword")).sendKeys("YmAmUsa");
		driver.findElement(prop.getLocator("login")).click();
		driver.close();
	}
	@Test
	public void EnterValue()
	{
		//Lets see how we can find the first name field
		WebElement FirstName = driver.findElement(prop.getLocator("FirstName"));
		WebElement LastName = driver.findElement(prop.getLocator("LastName"));
		FirstName.sendKeys("Virender");
		LastName.sendKeys("Singh");
	}

}
