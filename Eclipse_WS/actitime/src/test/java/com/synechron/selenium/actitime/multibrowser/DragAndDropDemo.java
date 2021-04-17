package com.synechron.selenium.actitime.multibrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class DragAndDropDemo {

	
	public static void main(String[] args) {
		
		WebDriver driver  = ActitimeUtils.getDriver("edge");
		ActitimeUtils.launch("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement srcEle = driver.findElement(By.id("draggable"));
		WebElement destEle = driver.findElement(By.id("droppable"));
		System.out.println("--- Text Before DD ---");
		System.out.println("source Element : " +  srcEle.getText());
		System.out.println("dest Element : " +  destEle.getText());
		Actions act  = new Actions(driver);
		act.dragAndDrop(srcEle, destEle).perform();
		
		System.out.println("--- Text After DD ---");
		System.out.println("source Element : " +  srcEle.getText());
		System.out.println("dest Element : " +  destEle.getText());
		
	}
}
