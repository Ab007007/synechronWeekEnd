package com.synechron.selenium.actitime.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.synechron.selenium.actitime.utils.ActitimeUtils;
import com.synechron.selenium.actitime.utils.FileUtils;

public class CreateCustomerUsingExcelData 
{
	
	public static void main(String[] args) {
		
		ActitimeUtils.getDriver();
		ActitimeUtils.launch(FileUtils.getPropertyValue("url"));
		ActitimeUtils.login(FileUtils.getPropertyValue("username"),FileUtils.getPropertyValue("password"));
		ActitimeUtils.selectModule("tasks");
		ActitimeUtils.clickOnNewCustomerButton();
		ActitimeUtils.createCustomer("WE-Selenium-Cust1", "WE-Selenium-CustDesc-1");
		ActitimeUtils.logout();
	}

}
