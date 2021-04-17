package com.synechron.selenium.actitime.switchto;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class MultiBrowserDemo {
	
	public static void main(String[] args) {
		
		WebDriver driver = ActitimeUtils.getDriver("chrome");
		ActitimeUtils.launch();
		ActitimeUtils.login("admin", "manager");
		driver.findElement(By.xpath("//div[contains(text(),'Help') and @class='popup_menu_label']")).click();
		driver.findElement(By.linkText("User Guide")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();
		
		String parentWID = it.next();
		String childWID = it.next();
		System.out.println("parentWID" + parentWID);
		System.out.println("childWID" + childWID);
				
		driver.switchTo().window(childWID);
		
		List<WebElement> headingLinks = driver.findElements(By.xpath("//h3[a]"));
		for (WebElement heading : headingLinks) {
			System.out.println(heading.getText());
			
		}
		
		driver.close();
		
		driver.switchTo().window(parentWID);
		ActitimeUtils.logout();
	}

}
