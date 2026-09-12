package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ViewCart;

public class TC007_ModifyProductQuantity extends BaseClass{
	
	
	@Test
	public void updateQuantity() throws InterruptedException {
		logger.info("Update Of Product Quantity Started");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		LoginPage lp = new LoginPage(driver);
		lp.setEmailID("vigneshkumar2002@gmail.com");
		lp.setPassword("qwerty");
		lp.clickSubmitButton();
		MyAccountPage myaccount = new MyAccountPage(driver);
		myaccount.clickMyCart();
		ViewCart myCart = new ViewCart(driver);
		try {
			myCart.updateQuantity("MacBook Pro", "5");
			Assert.assertTrue(true);
			logger.info("Update Success");
		}
		catch(Exception e) {
			logger.error("Item not Exist");
			Assert.fail("Product not Found");
		}
		Thread.sleep(3000);
	}
}
