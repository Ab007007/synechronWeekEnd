package com.synechron.selenium.actitime.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.selenium.actitime.utils.ActitimeUtils;
import com.synechron.selenium.actitime.utils.DriverUtils;

public class LoginTest {

	public static void main(String[] args) {

		ActitimeUtils.getDriver();
		ActitimeUtils.launch();
		ActitimeUtils.login("admin", "manager");
		ActitimeUtils.logout();
	}

	

}
