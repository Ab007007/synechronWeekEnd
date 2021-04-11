package com.synechron.selenium.actitime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldTest {
	
	public static void main(String[] args) 
	{
		System.out.println("Welcome to Selenium Training!");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
	}

}
