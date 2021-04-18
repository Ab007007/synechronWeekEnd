package com.synechron.selenium.actitime.popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class HiddenDivisionPopup {
	
	public static void main(String[] args) {
		
		WebDriver driver = ActitimeUtils.getDriver();
		ActitimeUtils.launch();
		ActitimeUtils.login("admin", "manager");
		ActitimeUtils.selectModule("tasks");
		
		driver.findElement(By.xpath("//div[@class='scrollableContainer']//tr[1]//td[@class='selection']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Delete']/parent::div"))));
		ele.click();
		driver.findElement(By.id("deleteTaskPopup_deleteConfirm_submitBtn")).click();
		
		System.out.println("Waiting for the Visiblity of Toast message ");
		WebElement sussessMsg = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
		System.out.println("SUCCESS MESSAGE : " + sussessMsg.getText());

		System.out.println("Waiting for the Element to be invisible ");
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));

		System.out.println("Success message disappeared successfully!!!");

		ActitimeUtils.logout();
	}

}
