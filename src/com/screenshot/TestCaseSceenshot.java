package com.screenshot;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

@Listeners(com.screenshot.ListenerTest.class)

public class TestCaseSceenshot extends MainTest {

	//test to pass to verify listeners
	@Test 
	public void Login() {
	System.setProperty("webdriver.chrome.driver", "C:\\sj_testing\\Selenium testing\\drivers\\chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
    
    driver.get("http://demo.guru99.com/V4/");					
    driver.findElementByName("uid").sendKeys("mngr222055");							
    driver.findElementByName("password").sendKeys("YmAmUsa");							
    driver.findElementByName("btnLogin").click();
    driver.close();
	}
	
	//forcefully to verify listener.
	@Test
	public void TestToFail() {
		System.out.println("this method is to fail");
		Assert.assertTrue(false);
	
	}
}
