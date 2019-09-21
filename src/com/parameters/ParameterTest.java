package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	ChromeDriver driver;
	
	@Parameters({"url","emailid","password"})
	@Test
	public void gmailLoginTest(String url, String emailid, String password) {
		System.setProperty("webdriver.chrome.driver","C:\\sj_testing\\Selenium testing\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Actions act=new Actions(driver);
		driver.findElementById("identifierId").sendKeys(emailid);
		WebElement wb=driver.findElementByXPath("//span[@class='CwaK9']");
		act.sendKeys(Keys.ENTER).perform();
		driver.findElementByName("password").sendKeys(password);
		driver.findElementByXPath("//span[@class='CwaK9']");
		act.sendKeys(Keys.ENTER).perform();
        driver.close();
	}

}
