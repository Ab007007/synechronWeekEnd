package com.testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.synechron.selenium.actitime.utils.DriverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestionTest 
{
	
	@Test
	public void autoSuggestionsTest() throws InterruptedException
	{
		System.out.println(" --- Creating a Browser Object ---");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
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
