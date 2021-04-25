package com.testng.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	
	
	@FindBy(id = "logoutLink")
	WebElement logoutLink;
	
	
	@FindBy(xpath = "//div[text()='TASKS']/parent::a")
	WebElement tasksLink;
	
	public void clickOnTasks()
	{
		tasksLink.click();
		
	}
	
	public void logout()
	{
		logoutLink.click();
	}
	
	
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
