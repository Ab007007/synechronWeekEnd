package com.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class AnnotationsDemo 
{
	WebDriver driver = null;
	@BeforeClass
	public void getDriver() {
		driver = ActitimeUtils.getDriver();
	}
	
	
	@BeforeMethod
	public void setup() {
		ActitimeUtils.launch();
	}
	
	@AfterMethod
	public void getStatus(ITestResult result) throws IOException {
		
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			ActitimeUtils.logout();
		}
		else
		{
			System.out.println(result.getTestName() + " is failed!!!");
			TakesScreenshot ss =  (TakesScreenshot)driver;
			File screenShot = ss.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File("results/" + result.getName() + "_" 
			+ com.synechron.selenium.actitime.utils.FileUtils.getDateAndTime() + ".png"));
		}
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	@Test
	public void validLoginTest()
	{
		ActitimeUtils.login("admin", "manager");
	}
	
	@Test
	public void inValidLoginTest()
	{

		ActitimeUtils.login("admin1", "manager1");
	}
	
	
	

}
