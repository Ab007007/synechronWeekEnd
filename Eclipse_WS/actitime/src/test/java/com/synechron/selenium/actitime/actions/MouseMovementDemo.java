package com.synechron.selenium.actitime.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class MouseMovementDemo {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = ActitimeUtils.getDriver();
		ActitimeUtils.launch("https://www.flipkart.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement loginCloseButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"))));
		loginCloseButton.click();
		
		WebElement electronicsEle = driver.findElement(By.xpath("//div[text()='Electronics']"));
		WebElement homeEle = driver.findElement(By.xpath("//div[text()='Home']"));
		WebElement appliancesEle = driver.findElement(By.xpath("//div[text()='Appliances']"));
		WebElement toysEle = driver.findElement(By.xpath("//div[text()='Beauty, Toys & More']"));
	
		Actions act = new Actions(driver);
		
		act.moveToElement(electronicsEle).perform();
		List<WebElement> electronicsObjects = driver.findElements(By.xpath("//div[div[text()='Electronics']]/following-sibling::div//a"));
		printCollectionObj(electronicsEle,electronicsObjects);
	
		Thread.sleep(3000);
		act.moveToElement(homeEle).perform();
		List<WebElement> homeOptions = driver.findElements(By.xpath("//div[div[text()='Home']]/following-sibling::div//a"));
		printCollectionObj(homeEle, homeOptions);
			
		Thread.sleep(3000);
		act.moveToElement(appliancesEle).perform();
		List<WebElement> appliancesOptions = driver.findElements(By.xpath("//div[div[text()='Appliances']]/following-sibling::div//a"));
		printCollectionObj(appliancesEle, appliancesOptions);
		
		Thread.sleep(3000);
		act.moveToElement(toysEle).perform();
		List<WebElement> toysOptions = driver.findElements(By.xpath("//div[div[text()='Beauty, Toys & More']]/following-sibling::div//a"));
		printCollectionObj(toysEle, toysOptions);
		
	
	}

	
		public static void printCollectionObj(WebElement ele1,  List<WebElement> options)
		{
			System.out.println("----------Printing Collection Objs ------------------" + ele1.getText());
			for (WebElement ele : options)
			{
				System.out.println(ele.getText());
				
			}
			System.out.println("#########################################################");
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
