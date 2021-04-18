package com.testng;

import org.testng.annotations.DataProvider;

public class TestData {

	
	  
	  
	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	      new Object[] { 3, "a" },
	      new Object[] { 4, "b" },
	    };
	  }
	  
	  
	  @DataProvider
	  public Object[][] createcustomerdata() {
	    return new Object[][] {
	      new Object[] { "WE-TestNG-Cus1", "WE-TestNG-Cus1-Desc" },
	      new Object[] { "WE-TestNG-Cus2", "WE-TestNG-Cus2-Desc" },
	      new Object[] { "WE-TestNG-Cus3", "WE-TestNG-Cus3-Desc" },
	      new Object[] { "WE-TestNG-Cus4", "WE-TestNG-Cus4-Desc" },
	    };
	  }
	  
	  
}
