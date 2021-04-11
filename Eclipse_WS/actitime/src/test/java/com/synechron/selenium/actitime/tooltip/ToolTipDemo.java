package com.synechron.selenium.actitime.tooltip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTipDemo {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
		String toolTip = driver.findElement(By.xpath("//a[@class='gb_D']")).getAttribute("aria-label");
		
		
		if (toolTip.equals("Google apps"))
		{
			System.out.println("Tooltip Matched!!" + toolTip);
		}
		else
		{
			System.out.println("Tooltip Didnt Match!!" + toolTip);
		}
		
		driver.close();
		
		
	}

}
