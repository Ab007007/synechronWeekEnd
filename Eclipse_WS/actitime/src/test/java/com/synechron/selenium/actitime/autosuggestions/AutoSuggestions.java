package com.synechron.selenium.actitime.autosuggestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver  =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Synechron");
		Thread.sleep(2000);
		List<WebElement> suggestions = driver.findElements(By.xpath("//ul/li[@role='presentation']//div[@class='sbl1']/span"));
	
		System.out.println("Total Suggestions displayed -> " + suggestions.size());
	
		for (WebElement suggestion : suggestions) 
		{
			System.out.println(suggestion.getText());
		}
	
		//driver.close();
		//driver = null;
	}
}
