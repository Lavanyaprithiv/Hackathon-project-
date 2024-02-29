package com.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.Factory.BaseClass;
import com.pageObject.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC002_GetSubOptions {
	
	WebDriver driver;
	HomePage hp;
	
	@Given("the homepage of the website containing all options")
	public void the_homepage_of_the_website_containing_all_options() {
	    hp=new HomePage(BaseClass.getDriver());
	}

	@When("the user clicks the living option menu")
	public void the_user_clicks_the_living_option_menu() throws InterruptedException {
//		System.out.println("Option-1");
	    hp.getAllOptions1();
	}

	@Then("the user should see all the sub-options of the menu")
	public void the_user_should_see_all_the_sub_options_of_the_menu(){
		System.out.println("All the Options available");
	}

	@Then("the user should print all the value")
	public void the_user_should_print_all_the_value() throws InterruptedException {
		System.out.println("Option-1");
		System.out.println(hp.getAllOptions1());
		System.out.println("Option-2");
		System.out.println(hp.getAllOptions2());
		System.out.println("Option-3");
		System.out.println(hp.getAllOptions3());
	}

}
