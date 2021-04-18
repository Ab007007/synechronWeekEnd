package com.testng;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class CreateCustomerTest 
{
	
	
	WebDriver driver = null;
	@BeforeClass
	public void getDriver() {
		driver = ActitimeUtils.getDriver();
	}
	
	@BeforeMethod
	public void setup() {
		ActitimeUtils.launch();
		ActitimeUtils.login("admin", "manager");
	}
	
	@AfterMethod
	public void getStatus(ITestResult result) {
		
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			ActitimeUtils.logout();
		}
		else
		{
			System.out.println(result.getTestName() + " is failed!!!");
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void createCustomerTest()
	{
		ActitimeUtils.selectModule("tasks");
		ActitimeUtils.clickOnNewCustomerButton();
		ActitimeUtils.createCustomer("WE-Selenium-TestNGCust1", "WE-Selenium-CustDesc-1");
	}
	
}
