package com.TestCases;

import org.testng.annotations.Test;

import com.pageObject.HomePage;

public class TC002_GettingAllSubOptions extends BasePage{
	
	HomePage hp;

	@Test(groups= {"regression"})
	public void getAllOptions() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		BasePage.getLogger().info("************Sub menu 1************");
		System.out.println(hp.getAllOptions1());
		BasePage.getLogger().info("************Sub menu 2************");
		System.out.println(hp.getAllOptions2());
		BasePage.getLogger().info("************Sub menu 3************");
		System.out.println(hp.getAllOptions3());
	}
}
