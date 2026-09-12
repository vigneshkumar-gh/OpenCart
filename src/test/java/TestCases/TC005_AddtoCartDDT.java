package TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import baseTest.BaseClass;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductPage;

import pageObjects.SearchProductPage;
import pageObjects.ViewCart;

public class TC005_AddtoCartDDT extends BaseClass{

	@Test(dataProvider = "ProductData", dataProviderClass = DataProviders.class)
	public void OrderProduct(String Item, String Quantity, String ExpectResult) throws InterruptedException {
		String item = Item;
		String quantity = Quantity;
		HomePage hp = new HomePage(driver);
		MyAccountPage myaccount = new MyAccountPage(driver);

		logger.info("------------- Account Login in Progress");
		hp.clickMyAccount();
		hp.clickLogin();
		LoginPage lp = new LoginPage(driver);
		lp.setEmailID("vigneshkumar2002@gmail.com");
		lp.setPassword("qwerty");
		lp.clickSubmitButton(); 
		logger.info("------ Account Login Successful");

		logger.info("------ Searching for Product ---------");
		SearchProductPage sp = new SearchProductPage(driver);
		sp.searchProduct(item);
		sp.clickSearchBtn();
		
		ProductPage product = new ProductPage(driver);

		try {
			product.clickProductDetails(item);
		}
		catch(Exception e) {
			myaccount.clickMyAccount();
			myaccount.clickLogOutButton();
			logger.info("Product Not Found!");
			Assert.fail();
		}
		logger.info("------ Product Found");
		ViewCart mycart = new ViewCart(driver);
		product.clickAddtoCart();
		Assert.assertEquals(product.isProductAdded(), true);
		logger.info("------ Product is added to cart Successfully");

		mycart.clickFullViewCart();
		logger.info("------ View Full Cart ---------");
		Thread.sleep(3000);
		
		myaccount.clickMyAccount();
		myaccount.clickLogOutButton();

	}
}
