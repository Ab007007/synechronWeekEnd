package com.testng.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testng.page.DashboardPage;
import com.testng.page.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMLoginTest {

	WebDriver driver = null;
	LoginPage lp = null;
	DashboardPage dp = null;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterTest
	public void cleanup() {
		driver.close();
		driver = null;
	}

	@BeforeClass
	public void init()
	{
		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
	}
	
	@Test
	public void loginTest()
	{
		driver.get("http://localhost/login.do");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
		lp.enterUserName("admin");
		lp.enterPassword("manager");
		lp.clickOnLoginButton();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		dp.logout();
	}
	
	@Test
	public void inValidloginTest()
	{
		driver.get("http://localhost/login.do");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
		lp.enterUserName("admin1");
		lp.enterPassword("manager1");
		lp.clickOnLoginButton();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
	}
	
		
}
