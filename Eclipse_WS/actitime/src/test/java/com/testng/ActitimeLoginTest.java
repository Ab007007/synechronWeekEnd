package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActitimeLoginTest {
	
	@Test
	public void validLoginTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://localhost/login.do");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		System.out.println("--- Logout and Close Browser ---");
		driver.findElement(By.id("logoutLink")).click();
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
		driver.close();
	}
	
	
}
