package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ViewCart;

public class TC006_DeleteCartItemsTest extends BaseClass{
	
	@Test
	public void removeAddedItem() throws InterruptedException {
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
			myCart.deleteItem("Samsung Galaxy Tab 10.1");
			Assert.assertTrue(true);
		}
		catch(Exception e) {
			Assert.fail("Product Not Found");
		}
		
	}
}
