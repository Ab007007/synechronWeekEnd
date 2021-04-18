package com.synechron.selenium.actitime.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActitimeUtils extends DriverUtils {

	public static void login(String un, String pwd) {
		System.out.println("--- Login to the application with " + un + " and " + pwd);
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.id("loginButton")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
	}

	public static void launch() {
		System.out.println(" --- Launching application ---");
		driver.get("http://localhost/login.do");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
	}
	
	public static void launch(String url) {
		System.out.println(" --- Launching application ---" + url);
		driver.get(url);
	}

	public static void logout() {
		System.out.println("--- Logout and Close Browser ---");
		driver.findElement(By.id("logoutLink")).click();
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
		//driver.close();
	}

	public static void selectModule(String moduleName) {

		System.out.println("--- Selecting " + moduleName + " module");
		driver.findElement(By.xpath("//div[text()='" + moduleName.toUpperCase() + "']/parent::a")).click();
		/*
		 * //div[text()='TASKS']/parent::a switch (moduleName) { case "tasks":
		 * driver.findElement(By.xpath("//div[text()='TASKS']/parent::a")).click();
		 * break; case "reports":
		 * driver.findElement(By.xpath("//div[text()='REPORTS']/parent::a")).click();
		 * break;
		 * 
		 * default: break; }
		 */
	}

	public static void clickOnNewCustomerButton() {
		System.out.println("--- Clicking on Add New Customer ---");
		driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click();
	}

	public static void createCustomer(String cn, String cd) {
		System.out.println("--- Creating a customer with " + cn + " and " + cd);
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys(cn);
		driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(cd);
		driver.findElement(By.id("customerLightBox_commitBtn")).click();

		System.out.println("Waiting for the Visiblity of Toast message ");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement sussessMsg = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
		System.out.println("SUCCESS MESSAGE : " + sussessMsg.getText());

		System.out.println("Waiting for the Element to be invisible ");
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));

		System.out.println("Success message disappeared successfully!!!");

	}

}
