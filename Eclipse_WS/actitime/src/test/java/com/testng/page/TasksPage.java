package com.testng.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TasksPage {
	
	
	WebDriver driver = null;
	
	@FindBy(xpath = "//div[@class='addNewContainer']")
	WebElement addNewButton;
	
	@FindBy(xpath = "//div[contains(text(),'New Customer')]")
	WebElement newCustomerButton;
	
	@FindBy(id = "customerLightBox_nameField")
	WebElement customerNameTxtBox;
	
	@FindBy(id = "customerLightBox_descriptionField")
	WebElement customerDescTxtBox;
	
	@FindBy(id = "customerLightBox_commitBtn")
	WebElement createcustomerButton;
	
	
	@FindBy(id = "customerLightBox_nameDuplicateError")
	WebElement errorMsg;
	
	@FindBy(id = "customerLightBox_cancelBtn")
	WebElement cancelButton;
	
	public void clickOnNewCustomerButton() {
		addNewButton.click();
		newCustomerButton.click();
	}
	
	
	public void createExistingCustomer(String cn, String cd)
	{
		customerNameTxtBox.sendKeys(cn);
		customerDescTxtBox.sendKeys(cd);
		createcustomerButton.click();
		
		Assert.assertTrue(errorMsg.isDisplayed());
		cancelButton.click();
		
		driver.switchTo().alert().accept();
		
		
	}
	
	public void createCustomer(String cn, String cd)
	{
		customerNameTxtBox.sendKeys(cn);
		customerDescTxtBox.sendKeys(cd);
		createcustomerButton.click();
		
		System.out.println("Waiting for the Visiblity of Toast message ");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement sussessMsg = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
		System.out.println("SUCCESS MESSAGE : " + sussessMsg.getText());

		System.out.println("Waiting for the Element to be invisible ");
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));

		System.out.println("Success message disappeared successfully!!!");
	}

	public TasksPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
