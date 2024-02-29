package com.TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageObject.GiftCards;
import com.pageObject.HomePage;

public class TC003_EnteringIncorrectAmount extends BasePage{

	@Test(priority=1,groups= {"sanity","regression"})
	@Parameters("Amount1")
	public void amount1(String Amount1) throws InterruptedException {
	HomePage hp=new HomePage(driver);
	BasePage.getLogger().info("************Opening gift card page************");
	hp.openGiftPage();
	GiftCards gift=new GiftCards(driver);
	BasePage.getLogger().info("************Choosing occasion as Anniversary/Birthday************");
	gift.ChoseOccasion();
	BasePage.getLogger().info("************Entering amount as 1000***********");
	gift.enterAmount(Amount1);
}
	@Test(priority=2)
	@Parameters("Amount2")
	public void amount2(String Amount2) throws InterruptedException {
		HomePage hp=new HomePage(driver);
		BasePage.getLogger().info("************Opening gift card page************");
		hp.openGiftPage();
		GiftCards gift=new GiftCards(driver);
		BasePage.getLogger().info("************Choosing occasion as Anniversary/Birthday************");
		gift.ChoseOccasion();
		BasePage.getLogger().info("************Entering amount as 1000***********");
		gift.enterAmount(Amount2);
	}
}
