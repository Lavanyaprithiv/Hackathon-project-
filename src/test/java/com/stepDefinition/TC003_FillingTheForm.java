package com.stepDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.Factory.BaseClass;
import com.TestCases.BasePage;
import com.Utility.DataReader;
import com.pageObject.GiftCards;
import com.pageObject.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC003_FillingTheForm {

	WebDriver driver;
	HomePage hp;
	GiftCards gift;
	List<HashMap<String, String>> datamap;
	public static int opt=1;
	
	@Given("the homepage of the website having giftcard option")
	public void the_homepage_of_the_website_having_giftcard_option() {
	    hp=new HomePage(BaseClass.getDriver());
	    BasePage.getLogger().info("************gift card page************");
	}

	@When("the user clicks the gift card option in the homepage")
	public void the_user_clicks_the_gift_card_option_in_the_homepage() throws InterruptedException {
	    hp.openGiftPage();
	    BasePage.getLogger().info("************Home page************");
	    
	    
	}

	@Then("the user should be navigated to the giftcard page")
	public void the_user_should_be_navigated_to_the_giftcard_page() {
	    gift=new GiftCards(BaseClass.getDriver());
	    BasePage.getLogger().info("************user navigated to the giftcard page************");
	    
	}

	@When("the user clicks the Anniversary\\/Birthday in the occasion")
	public void the_user_clicks_the_anniversary_birthday_in_the_occasion() {
	    gift.ChoseOccasion();
	    BasePage.getLogger().info("************Choosing occasion as Anniversary/Birthday************");
	    
	}

	@When("enters the amount in the text and click the next button")
	public void enters_the_amount_in_the_text_and_click_the_next_button() {
		gift.enterAmount("1000");
		BasePage.getLogger().info("************Entering amount as 1000***********");
		
	}

	@When("fill the form with incorrect details as below fields")
	public void fill_the_form_with_incorrect_details_as_below_fields(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		gift.setRecipientName(dataMap.get("RecipientName"));
		gift.setRecipientEmail(dataMap.get("RecipientEmail"));
		gift.setRecipientMobNo(dataMap.get("RecipientMobileNo"));
		gift.setCustomerName(dataMap.get("CustomerName"));
		gift.setCustomerEmail(dataMap.get("CustomerEmail"));
		gift.setCustomerMobNo(dataMap.get("CustomerMobileNo"));
		gift.setCustomerAddress(dataMap.get("CustomerAddress"));
		gift.setPincode(dataMap.get("Pincode"));
		gift.submit();
		BasePage.getLogger().info("************Filling the incorrect details in the form***********");
	}

	@Then("the user should get the error message")
	public void the_user_should_get_the_error_message() {
	   System.out.println(gift.getErrorMsg());
	}
	
	@When("fill the form with correct details as below fields")
	public void fill_the_form_with_correct_details_as_below_fields(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		gift.setRecipientName(dataMap.get("RecipientName"));
		gift.setRecipientEmail(dataMap.get("RecipientEmail"));
		gift.setRecipientMobNo(dataMap.get("RecipientMobileNo"));
		gift.setCustomerName(dataMap.get("CustomerName"));
		gift.setCustomerEmail(dataMap.get("CustomerEmail"));
		gift.setCustomerMobNo(dataMap.get("CustomerMobileNo"));
		gift.setCustomerAddress(dataMap.get("CustomerAddress"));
		gift.setPincode(dataMap.get("Pincode"));
		gift.submit();
		BasePage.getLogger().info("************Filling the correct details in the form***********");
	}
	
	@Given("the form section in the giftcard page")
	public void the_form_section_in_the_giftcard_page() {
	    System.out.println("3. Nice! So who is this lucky person?");
	}

	@Then("the user should fill the form with the data excel row {string}")
	public void the_user_should_fill_the_form_with_the_data_excel_row(String rows) throws InterruptedException {
		datamap=DataReader.data("C:\\Users\\2303655\\eclipse-workspace\\HackathonProject\\testData\\TestData.xlsx" ,"Sheet1");
		int index=Integer.parseInt(rows)-1;
		gift.setRecipientName(datamap.get(index).get("RecipientName"));
		gift.setRecipientEmail(datamap.get(index).get("RecipientEmail"));
		gift.setRecipientMobNo(datamap.get(index).get("RecipientMobileNo"));
		gift.setCustomerName(datamap.get(index).get("CustomerName"));
		gift.setCustomerEmail(datamap.get(index).get("CustomerEmail"));
		gift.setCustomerMobNo(datamap.get(index).get("CustomerMobileNo"));
		gift.setCustomerAddress(datamap.get(index).get("CustomerAddress"));
		gift.setPincode(datamap.get(index).get("Pincode"));
		gift.submit();
		BasePage.getLogger().info("************Submitting the form************");
	}
	
	@Then("the user should get the error or confirmation message")
	public void the_user_should_get_the_error_or_confirmation_message() {
	    gift.getMessage(opt);
	    opt++;
	    
	}

	@Then("the user should get the confirmation message")
	public void the_user_should_get_the_confirmation_message() {
	    System.out.println(gift.confirmationMsg());
	    BasePage.getLogger().info("************Printing the Confirmation Message************");
	}

}
