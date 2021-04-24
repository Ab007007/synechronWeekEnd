package com.synechron.selenium.actitime.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

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
	
	public static WebDriver getRemoteDriver(String browserType, String nodeIp, String port) throws MalformedURLException
	{
		String nodeUrl = "http://" + nodeIp + ":" + port + "/wd/hub";
		switch (browserType) {
		case "chrome":
			ChromeOptions cOptions = new ChromeOptions();
			cOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			cOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			cOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			driver = new RemoteWebDriver(new URL(nodeUrl),cOptions);
			break;
		case "ff" :
			FirefoxOptions fOptions = new FirefoxOptions();
			fOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			fOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			fOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			driver = new RemoteWebDriver(new URL(nodeUrl),fOptions);
			
			break;

		default:
			break;
		}
		return driver;
	}
	
	public static WebDriver getRemoteDriver(String browserType, String nodeUrl) throws MalformedURLException
	{
		switch (browserType) {
		case "chrome":
			ChromeOptions cOptions = new ChromeOptions();
			cOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			cOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			cOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			driver = new RemoteWebDriver(new URL(nodeUrl),cOptions);
			break;
		case "ff" :
			FirefoxOptions fOptions = new FirefoxOptions();
			fOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			fOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			fOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			driver = new RemoteWebDriver(new URL(nodeUrl),fOptions);
			
			break;

		default:
			break;
		}
		return driver;
	}
	
}
