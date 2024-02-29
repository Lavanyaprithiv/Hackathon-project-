package com.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.Factory.BaseClass;
import com.pageObject.GiftCards;
import com.pageObject.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC003_CustomizeGiftCard {
	
	WebDriver driver;
	HomePage home;
	GiftCards gift;
	
	@Given("the homepage of the website")
	public void the_homepage_of_the_website() {
	   home=new HomePage(BaseClass.getDriver());
	}

	@When("the user clicks the gift cards")
	public void the_user_clicks_the_gift_cards() throws InterruptedException {
	   home.openGiftPage();
	}

	@When("choose an Occasion as Birthday\\/Anniversary")
	public void choose_an_occasion_as_birthday_anniversary() {
		gift=new GiftCards(BaseClass.getDriver());
	    gift.ChoseOccasion();
	}

	@When("customize the gift card by entering the amount as {string}")
	public void customize_the_gift_card_by_entering_the_amount_as(String string) {
	   gift.enterAmount(string);
	}

	@Then("verify that the next button is enabled are not")
	public void verify_that_the_next_button_is_enabled_are_not() {
	    System.out.println(gift.Isenabled());
	}


}
