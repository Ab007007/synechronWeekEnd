package com.synechron.selenium.actitime.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils 
{

	public static WebDriver driver  = null;
	
	public static WebDriver getDriver()
	{
		System.out.println(" --- Creating a Browser Object ---");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static WebDriver getDriver(String browserType)
	{
		System.out.println(" --- Creating a Browser Object ---"  + browserType);
		switch (browserType.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "ff":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Driver Creation Failed!!! Contact Framework Development Team to support You Browser " + browserType);
			break;
		}
		driver.manage().timeouts().implicitlyWait(Integer.valueOf(FileUtils.getPropertyValue("timeout")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	
	
}
