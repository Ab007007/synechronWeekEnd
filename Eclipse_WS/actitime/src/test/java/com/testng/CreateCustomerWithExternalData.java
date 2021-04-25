package com.testng;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class CreateCustomerWithExternalData 
{
	WebDriver driver = null;
	@BeforeClass
	public void getDriver() {
		driver = ActitimeUtils.getDriver();
	}
	
	@Parameters({"username","password"})
	@BeforeMethod
	public void setup(String un, String pwd) {
		ActitimeUtils.launch();
		ActitimeUtils.login(un, pwd);
	}
	
	@AfterMethod(alwaysRun = true)
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
	
	@Test(dataProvider = "createcustomerdata", dataProviderClass = TestData.class)
	public void createCustomerTest(String cn, String cd)
	{
		ActitimeUtils.selectModule("tasks");
		ActitimeUtils.clickOnNewCustomerButton();
		ActitimeUtils.createCustomer(cn, cd);
	}
	
}
