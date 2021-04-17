package com.synechron.selenium.actitime.switchto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class AlertsDemo {
	
	
	private static WebDriver driver;

	public static void main(String[] args) {
		
		driver = ActitimeUtils.getDriver("edge");
		ActitimeUtils.launch();
		ActitimeUtils.login("admin", "manager");
		ActitimeUtils.selectModule("tasks");
		ActitimeUtils.clickOnNewCustomerButton();
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys("JUNK CUST");
		driver.findElement(By.id("customerLightBox_cancelBtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys("JUNK CUST124");
		driver.findElement(By.id("customerLightBox_cancelBtn")).click();
		driver.switchTo().alert().accept();
		
		ActitimeUtils.logout();
		
		
	}

}
