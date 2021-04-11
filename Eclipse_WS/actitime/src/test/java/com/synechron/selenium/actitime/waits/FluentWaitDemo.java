package com.synechron.selenium.actitime.waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver  =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("file:///D:/SynechronWeekendBatch/html/tiimeout.html");
		
		driver.findElement(By.tagName("button")).click();
		
		FluentWait<WebElement> wait =  new FluentWait<WebElement>(
				driver.findElement(By.id("demo"))).
				withTimeout(Duration.ofSeconds(10)).
				pollingEvery(Duration.ofMillis(100)).
				ignoring(NoSuchElementException.class);
		
		
		Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>() 
		{

			@Override
			public Boolean apply(WebElement ele) {
				boolean flag = false;
				if(ele.getText().equals("Hello"))
				{
					System.out.println("Element Found!!!!");
					flag = true;
				}
				else
				{
					System.out.println("Waiting for the element!!!!!");
				}
				return flag;
			}
		};
				
		wait.until(fun);		
				
		String demo = driver.findElement(By.id("demo")).getText();
		String demo2 = driver.findElement(By.id("demo2")).getText();
		
		System.out.println("Demo : " + demo);
		System.out.println("Demo2 : " + demo2);
		
		
	}

}
