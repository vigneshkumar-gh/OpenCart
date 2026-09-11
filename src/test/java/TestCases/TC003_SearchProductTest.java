package TestCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchProductPage;

public class TC003_SearchProductTest extends BaseClass{
	
	@Test(groups = "sanity")
	public void searchForProduct() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		Thread.sleep(3000);
		LoginPage lp = new LoginPage(driver);
		lp.setEmailID("ramkumar2002");
		lp.setPassword("qwerty");
		lp.clickSubmitButton();
		Thread.sleep(3000);
		SearchProductPage sp = new SearchProductPage(driver);
		sp.searchProduct("HP LP3065");
		sp.clickSearchBtn();
		Thread.sleep(3000);
		try {
			Assert.assertEquals(sp.isProductExist(), true);
		}
		catch(AssertionError e) {
			Assert.fail();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
