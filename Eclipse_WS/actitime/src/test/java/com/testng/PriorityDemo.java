package com.testng;

import org.testng.annotations.Test;

public class PriorityDemo
{
  @Test(priority = 0)
  public void launch() 
  {
	  System.out.println("HEllo All Welcome to TestNG.!!!");
  }
  
  @Test(priority = 1)
  public void login() 
  {
	  System.out.println("HEllo All Welcome to TestNG.!!!");
  }
  
  @Test(priority = 2)
  public void createCustomer() 
  {
	  System.out.println("HEllo All Welcome to TestNG.!!!");
  }
  @Test(priority = 3)
  public void logout() 
  {
	  System.out.println("HEllo All Welcome to TestNG.!!!");
  }
}
