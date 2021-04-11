package com.synechron.selenium.actitime.dropdown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver  =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("file:///D:/SynechronWeekendBatch/html/multiSelect.html");
		
		Select sel = new Select(driver.findElement(By.tagName("select")));
		
		sel.selectByIndex(3);
		Thread.sleep(2000);
		sel.selectByValue("volvo");
		Thread.sleep(2000);
		sel.selectByVisibleText("Mercedes");
		Thread.sleep(2000);
		sel.deselectByIndex(2);
		Thread.sleep(2000);
		sel.deselectByValue("audi");
		Thread.sleep(2000);
		sel.deselectByVisibleText("Volvo");
		Thread.sleep(2000);
		
		sel.selectByIndex(3);
		Thread.sleep(2000);
		sel.selectByValue("volvo");
		Thread.sleep(2000);
		sel.selectByVisibleText("Mercedes");
		Thread.sleep(2000);
		
		sel.deselectAll();
		Thread.sleep(2000);
		
		driver.close();
		
		
	}
}
