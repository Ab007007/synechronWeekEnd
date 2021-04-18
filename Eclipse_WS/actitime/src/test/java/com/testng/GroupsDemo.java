package com.testng;

import org.testng.annotations.Test;

public class GroupsDemo {

	@Test(groups = {"maruthi" , "cars" })
	public void swift() {

	}

	@Test(groups = {"maruthi", "lax-car"})
	public void ertiga() {

	}

	@Test(groups = {"mahendra", "lax-car"})
	public void xuv500() {

	}

	@Test(groups = "mahendra")
	public void xuv300() {

	}

	@Test(groups = "kia")
	public void celtos() {

	}

	@Test(groups = {"kia", "lax-car"})
	public void carnival() {

	}

}
