package com.testng;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.synechron.selenium.actitime.utils.ActitimeUtils;
import com.synechron.selenium.actitime.utils.FileUtils;

public class AutoSuggestionUsingGrid 
{
	
	@Test
	public void autoSuggestionsTest() throws InterruptedException, MalformedURLException
	{
		System.out.println(" --- Creating a Browser Object ---");
		String nodeUrl  = "http://192.168.1.104:5556/wd/hub";
		
		//WebDriver driver = ActitimeUtils.getRemoteDriver("chrome", "192.168.1.104", "5556");
		WebDriver driver = ActitimeUtils.getRemoteDriver(FileUtils.getPropertyValue("browser"), FileUtils.getPropertyValue("node1"));
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Synechron");
		Thread.sleep(2000);
		List<WebElement> suggestions = driver.findElements(By.xpath("//ul/li[@role='presentation']//div[@class='sbl1']/span"));
	
		Reporter.log("Total Suggestions displayed -> " + suggestions.size());
	
		for (WebElement suggestion : suggestions) 
		{
			Reporter.log(suggestion.getText() + "<br>");
		}
	
		driver.close();
	}
	
	
	

}
