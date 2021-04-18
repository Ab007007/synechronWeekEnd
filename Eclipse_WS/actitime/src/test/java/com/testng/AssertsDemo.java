package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertsDemo {

	@Test
	public void assertsDemo() {
		int a = 10;
		int b = 20;
		Assert.assertEquals((a + b), 30);
		System.out.println("Assert Program ended");
	}

	@Test
	public void softAssertsDemo() {
		int a = 10;
		int b = 20;
		SoftAssert sa = new SoftAssert();
		sa.assertEquals((a + b), 39);
		System.out.println("SoftAssert Program ended");
		sa.assertAll();
	}

}
