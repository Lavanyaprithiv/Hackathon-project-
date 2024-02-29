package com.TestCases;

import org.testng.annotations.Test;
import com.pageObject.BookShelves;
import com.pageObject.HomePage;

public class TC001_GettingTopThree_BookShelves extends BasePage{
	
	//WebDriver driver;
	HomePage hp;
	BookShelves book;
	String nameArr[]=new String[3];
	String priceArr[]=new String[3];
	
	@Test(groups= {"regression"})
	public void getBookshelves() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		BookShelves book=new BookShelves(driver);
		BasePage.getLogger().info("************Starts searching************");
		hp.search("Bookshelves");
		hp.navigationResult();
		book.closeAd();
		BasePage.getLogger().info("************Choosing category as Bookshelves************");
		book.choseCategory();
		BasePage.getLogger().info("************Choosing price range below 15000************");
		book.chosePriceRange();
		BasePage.getLogger().info("************Excluding out of stock************");
		book.ExcludingStock();
		BasePage.getLogger().info("************sorting as high to low************");
		book.sortingProduct();
		for(int i=0;i<3;i++) {
			nameArr[i]=book.getName().get(i).getText();
			priceArr[i]=book.getPrice().get(i).getText();
		}
		BasePage.getLogger().info("************TOP 3 Bookshelves************");
		for(int i=0;i<nameArr.length;i++) {
			System.out.print(nameArr[i]+"-");
			System.out.println(priceArr[i]); 
		}
	}
	
}
