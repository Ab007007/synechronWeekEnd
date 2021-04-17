package com.synechron.selenium.actitime.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.synechron.selenium.actitime.utils.ActitimeUtils;
import com.synechron.selenium.actitime.utils.ExcelUtils;
import com.synechron.selenium.actitime.utils.FileUtils;

public class CreateCustomerUsingExternalData 
{
	
	public static void main(String[] args) throws IOException {
		
		ActitimeUtils.getDriver();
		ActitimeUtils.launch(FileUtils.getPropertyValue("url"));
		ActitimeUtils.login(FileUtils.getPropertyValue("username"),FileUtils.getPropertyValue("password"));
		ActitimeUtils.selectModule("tasks");
		
		int rowCount = ExcelUtils.getRowCount("createcustomer");
		String cn,cd;
		for (int i = 1; i < rowCount; i++)
		{
			cn = ExcelUtils.getCellValue("createcustomer", i, 0);
			cd = ExcelUtils.getCellValue("createcustomer", i, 1);
			System.out.println("Creating a customer with " + cn + " and " + cd );
			ActitimeUtils.clickOnNewCustomerButton();
			ActitimeUtils.createCustomer(cn,cd);
		}
		ActitimeUtils.logout();
	}

}
