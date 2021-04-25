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
	//      new Object[] { "WE-TestNG-Cus01", "WE-TestNG-Cus1-Desc" },
	//     new Object[] { "WE-TestNG-Cus02", "WE-TestNG-Cus2-Desc" },
	      new Object[] { "WE-TestNG-Cus03", "WE-TestNG-Cus3-Desc" },
	//      new Object[] { "WE-TestNG-Cus04", "WE-TestNG-Cus4-Desc" },
	    };
	  }
	  
	  @DataProvider
	  public Object[][] createtask() {
	    return new Object[][] {
	      new Object[] { "Task-1", "Apr-24-2021","writing" },
	      new Object[] { "Task-1", "Apr-24-2021","analysis" },
	      new Object[] { "Task-1", "Apr-24-2021","Non-Billable" },
	      new Object[] { "Task-1", "Apr-24-2021","programming" },
	    };
	  }
	  
	  @DataProvider
	  public Object[][] createtaskWithCondition() {
	    return new Object[][] {
	      new Object[] {"true", "Task-1", "Apr-24-2021","writing" },
	      new Object[] {"true", "Task-1", "Apr-24-2021","analysis" },
	      new Object[] {"false","Task-1", "Apr-24-2021","Non-Billable" },
	      new Object[] {"true", "Task-1", "Apr-24-2021","programming" },
	    };
	  }
	  
	  
}
