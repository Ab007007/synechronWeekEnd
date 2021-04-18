package com.synechron.selenium.actitime.popup;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class FileDownloadPopup {

	public static void main(String[] args) throws IOException {
		Runtime.getRuntime().exec("D:\\SynechronWeekendBatch\\autoIT\\chromeFileUploader.exe");
		
		WebDriver driver = ActitimeUtils.getDriver();
		ActitimeUtils.launch("http://formy-project.herokuapp.com/fileupload");
		driver.findElement(By.id("file-upload-field")).click();
		
	
	}
}
