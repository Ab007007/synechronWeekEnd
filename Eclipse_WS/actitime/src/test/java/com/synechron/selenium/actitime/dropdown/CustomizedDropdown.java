package com.synechron.selenium.actitime.dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomizedDropdown {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver  =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("http://formy-project.herokuapp.com");
		
		driver.findElement(By.id("navbarDropdownMenuLink")).click();
		List<WebElement> dropDownItems = driver.findElements(By.xpath("//div[@class='dropdown-menu show']/a"));
		
		for (WebElement ele : dropDownItems) {
			System.out.println(ele.getText());
		}
		
		driver.findElement(By.linkText("File Upload")).click();
		Thread.sleep(3000);
		driver.close();
	
	}
}
