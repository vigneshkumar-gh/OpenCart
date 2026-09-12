package TestCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.SearchProductPage;

public class TC003_SearchProductTest extends BaseClass{
	
	@Test(groups = "sanity")
	public void searchForProduct() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmailID("nila99@gmail.com");
		lp.setPassword("nila2005");
		lp.clickSubmitButton();
		SearchProductPage sp = new SearchProductPage(driver);
		sp.searchProduct("Samsung SyncMaster 941BW");
		sp.clickSearchBtn();
		try {
			Assert.assertEquals(sp.isProductsExist("Samsung SyncMaster 941BW"), true);
		}
		catch(AssertionError e) {
			Assert.fail();
		}
		
		ProductPage product = new ProductPage(driver);
		product.clickProductDetails("Samsung SyncMaster 941BW");
		Thread.sleep(3000);
	}
	
	
	
	
	
	
	
	
	
	
	
}
