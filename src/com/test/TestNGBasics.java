package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	//Pre-conditions annotations-->Starting with @Before
	@BeforeSuite//1
	public void setUp() {
		System.out.println("SetUp system properly for Chrome");
		
	}
	@BeforeTest//2
	public void launchBrowser() {
		System.out.println("launch the browser");
	}
	@BeforeClass//3
	public void login() {
		System.out.println("login to app");
	}
	@BeforeMethod//4
	public void enterURL() {
		System.out.println("enter URL");
	}
	//Test cases starting with @Test
	@Test
	public void searchTest() {
		System.out.println("Search Test");
	}
	@Test
	public void regTest() {
		System.out.println("reg Test");
	}

	//post conditions -->starting with @After
	@AfterMethod//6
	public void logout() {
		System.out.println("logout from app");
	}
	@AfterClass//7
	public void closeBrowser() {
		System.out.println("close browser");
	}
	@AfterTest//8
	public void deleteAllCookies() {
		System.out.println("delete All Cookies");
	}
	@AfterSuite//9
	public void generateTestReport() {
		System.out.println("generate test report");
	}
	

}
