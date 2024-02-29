package com.TestCases;

import org.testng.annotations.Test;

import com.pageObject.GiftCards;
import com.pageObject.HomePage;

public class TC004_FormFilling extends BasePage{
	
	HomePage hp;
	public static int opt=1;
	@Test(dataProvider="testData",groups= {"regression"})
	public void giftcardForm(String rname,String rmail,String rmob,String cname,String cmail,String cmob,String cadd,String pin) throws InterruptedException {
		HomePage hp=new HomePage(driver);
		BasePage.getLogger().info("************Opening gift card page************");
		hp.openGiftPage();
		GiftCards gift=new GiftCards(driver);
		BasePage.getLogger().info("************Choosing occasion as Anniversary/Birthday************");
		gift.ChoseOccasion();
		BasePage.getLogger().info("************Entering amount as 1000***********");
		gift.enterAmount("1000");
		BasePage.getLogger().info("************Filling the details in the form***********");
		gift.setRecipientName(rname);
		gift.setRecipientEmail(rmail);
		gift.setRecipientMobNo(rmob);
		gift.setCustomerName(cname);
		gift.setCustomerEmail(cmail);
		gift.setCustomerMobNo(cmob);
		gift.setCustomerAddress(cadd);
		gift.setPincode(pin);
		BasePage.getLogger().info("************Submitting the form************");
		gift.submit();
		BasePage.getLogger().info("************Printing the Confirmation Message************");
		gift.getMessage(opt);
		opt++;
	}
}
