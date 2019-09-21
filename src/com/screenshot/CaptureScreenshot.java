package com.screenshot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.screenshot.ListenerTest.class)
public class CaptureScreenshot extends MainTest  {
	@Test
	public void captureScreenshot() {
		System.setProperty("webdriver.chrome.driver", "C:\\sj_testing\\Selenium testing\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	    
	    driver.get("http://www.automationtesting.in");
	    String title=driver.getTitle();
	    Assert.assertEquals("Home-Automation Test", title);
	    driver.close();

		
	}

}
