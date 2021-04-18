package com.testng;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderDemo {
  @Test(dataProvider = "dp",dataProviderClass = TestData.class)
  public void test(Integer n, String s) {
	  System.out.println(n + "--" + s);
  }


}
