package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.SearchProductPage;

public class TC004_AddToCartTest extends BaseClass{
	
	@Test(groups = "Master")
	public void addCart() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		Thread.sleep(3000);
		LoginPage lp = new LoginPage(driver);
		lp.setEmailID("ramkumar1999@gmail.com");
		lp.setPassword("qwerty");
		lp.clickSubmitButton();
		Thread.sleep(3000);
		SearchProductPage sp = new SearchProductPage(driver);
		sp.searchProduct("HP LP3065");
		sp.clickSearchBtn();
		
		ProductPage product = new ProductPage(driver);
		product.clickProductDetails("HP LP3065");
		//product.setQuantity("1");
		Thread.sleep(3000);
		product.clickAddtoCart();
		Thread.sleep(3000);
		try {
			Assert.assertTrue(product.isProductAdded());
		}
		catch (AssertionError e) {
			Assert.fail();
		}
	}
	
	
	
	
	

}
