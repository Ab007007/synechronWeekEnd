package com.synechron.selenium.actitime.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicOperations 
{

	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Welcome to Selenium Basics!");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("http://formy-project.herokuapp.com/form");
		
	//WebElement firstNameTextBox = driver.findElement(By.id("first-name"));
	//	firstNameTextBox.sendKeys("Aravinda");
		
		driver.findElement(By.id("first-name")).sendKeys("Aravinda");
		driver.findElement(By.id("last-name")).sendKeys("H");
		driver.findElement(By.id("job-title")).sendKeys("Software - Trainer");
		
		driver.findElement(By.id("radio-button-3")).click();
		driver.findElement(By.id("checkbox-1")).click();
		
		driver.findElement(By.id("datepicker")).sendKeys("04/14/2021");
		
		driver.findElement(By.linkText("Submit")).click();
		
		String successMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		
		System.out.println(successMsg);
		
		driver.close();
	}
}
