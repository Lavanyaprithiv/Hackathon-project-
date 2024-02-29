package com.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.Factory.BaseClass;
import com.pageObject.BookShelves;
import com.pageObject.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC001_GettingTopThree_Bookshelves {
	
	WebDriver driver;
	HomePage hp;
	BookShelves bs;
	String nameArr[]=new String[3];
	String priceArr[]=new String[3];
	
	@Given("the homepage of the website for searching bookshelves")
	public void the_homepage_of_the_website_for_searching_bookshelves() {
		hp=new HomePage(BaseClass.getDriver());
		bs=new BookShelves(BaseClass.getDriver());
	}
	
	@When("the user enters {string} in the sesrch box")
	public void the_user_enters_in_the_sesrch_box(String string) {
	    hp.search(string);
	}

	@Then("the user navigates to the result page")
	public void the_user_navigates_to_the_result_page() {
	    System.out.println(hp.navigationResult());
	    bs.closeAd();
	}

	@When("the user click the category button to choose Bookshelves as a category")
	public void the_user_click_the_category_button_to_choose_bookshelves_as_a_category() throws InterruptedException {
	   bs.choseCategory();
	}

	@When("the user clicks the price button to fix the price range as below {int}")
	public void the_user_clicks_the_price_button_to_fix_the_price_range_as_below(Integer int1) throws InterruptedException {
	    bs.chosePriceRange();
	}

	@When("click the exclude out of stock option")
	public void click_the_exclude_out_of_stock_option() throws InterruptedException {
	    bs.ExcludingStock();
	}

	@When("sort by price high to low")
	public void sort_by_price_high_to_low() throws InterruptedException {
	    bs.sortingProduct();
	}

	@Then("print the top three bookshelve's name and price")
	public void print_the_top_three_bookshelve_s_name_and_price() {
		for(int i=0;i<3;i++) {
			nameArr[i]=bs.getName().get(i).getText();
			priceArr[i]=bs.getPrice().get(i).getText();
		}
		
		for(int i=0;i<nameArr.length;i++) {
			System.out.print(nameArr[i]+"-");
			System.out.println(priceArr[i]);
		}
	}

}
