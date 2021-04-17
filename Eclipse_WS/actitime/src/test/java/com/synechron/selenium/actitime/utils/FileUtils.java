package com.synechron.selenium.actitime.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {

	public static String getPropertyValue(String propertyName) {

		String value = null;
		try {
			File f = new File("data/config.properties");
			FileInputStream fis = new FileInputStream(f);
			Properties props = new Properties();

			props.load(fis);
			value = props.getProperty(propertyName);

			fis.close();
			fis = null;
		} catch (Exception ex) {
			System.out.println("Error while reading config file!!");
		}
		return value;
	}

	public static void main(String[] args) throws IOException {

		System.out.println(getPropertyValue("url"));
		System.out.println(getPropertyValue("browser"));
		System.out.println(getPropertyValue("timeout"));
		System.out.println(getPropertyValue("username"));
		System.out.println(getPropertyValue("password"));

	}

}
