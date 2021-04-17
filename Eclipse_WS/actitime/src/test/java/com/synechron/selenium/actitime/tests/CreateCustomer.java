package com.synechron.selenium.actitime.tests;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class CreateCustomer 
{
	
	public static void main(String[] args) {
		
		ActitimeUtils.getDriver();
		ActitimeUtils.launch();
		ActitimeUtils.login("admin", "manager");
		ActitimeUtils.selectModule("tasks");
		ActitimeUtils.clickOnNewCustomerButton();
		ActitimeUtils.createCustomer("WE-Selenium-Cust1"
				, "WE-Selenium-CustDesc-1");
		ActitimeUtils.logout();
	}

}
