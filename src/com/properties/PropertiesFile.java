package com.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class PropertiesFile {
	public FileInputStream stream;
	public Properties pObj = new Properties();
	 
	public void Property(String fileName) throws IOException {
	
		stream=new FileInputStream("C:\\sj_testing\\Test Framework\\Property\\application.properties");
	    pObj.load(stream);
	}
	public By getLocator(String locatorName) {
		String locatorProperty=pObj.getProperty(locatorName);
		System.out.println(locatorProperty.toString());
		String locatorType=locatorProperty.split(":")[0];
		String locatorValue=locatorProperty.split(":")[1];
		
		By locator=null;
		switch(locatorType) {
		case "Id":
			locator=By.id(locatorValue);
		break;
		case "Name":
			locator=By.name(locatorValue);
		break;
		case "CssSelector":
			locator=By.cssSelector(locatorValue);
		break;
		case "LinkText":
			locator=By.linkText(locatorValue);
		break;
		case "PartialLinkText":
			locator=By.partialLinkText(locatorValue);
		break;
		case "TagName":
			locator=By.tagName(locatorValue);
		break;
		case "Xpath":
			locator=By.xpath(locatorValue);
		break;
		
		}

		return locator;
		
	}

}
