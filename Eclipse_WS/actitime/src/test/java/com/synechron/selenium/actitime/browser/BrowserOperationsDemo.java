package com.synechron.selenium.actitime.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserOperationsDemo {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver  =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://formy-project.herokuapp.com");
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("Current URL " + driver.getCurrentUrl());
		Thread.sleep(3000);
		System.out.println("Window ID " + driver.getWindowHandle());
		Thread.sleep(3000);
		System.out.println("Title " + driver.getTitle());
		Thread.sleep(3000);
		
		driver.navigate().to("http://www.google.com");
		Thread.sleep(3000);
		driver.manage().window().fullscreen();
		Thread.sleep(3000);
		driver.close();
	}
}
