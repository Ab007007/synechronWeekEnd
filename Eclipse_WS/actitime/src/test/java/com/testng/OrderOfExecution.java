package com.testng;

import org.testng.annotations.Test;

public class OrderOfExecution {
	@Test
	public void launch() {
		System.out.println("HEllo All Welcome to TestNG.!!!");
	}

	@Test(dependsOnMethods = "launch")
	public void login() {
		System.out.println("HEllo All Welcome to TestNG.!!!");
	}

	@Test(dependsOnMethods = "login")
	public void createCustomer() {
		System.out.println("HEllo All Welcome to TestNG.!!!");
	}

	@Test(dependsOnMethods = "logout")
	public void logout1() {
		System.out.println("HEllo All Welcome to TestNG.!!!");
	}
	@Test(dependsOnMethods = { "login", "createCustomer" })
	public void logout() {
		System.out.println("HEllo All Welcome to TestNG.!!!");
	}

}
