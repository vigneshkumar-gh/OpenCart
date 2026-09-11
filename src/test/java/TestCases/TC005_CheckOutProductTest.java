package TestCases;


import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.RegistrationPage;
import pageObjects.SearchProductPage;
import pageObjects.ViewCart;

public class TC005_CheckOutProductTest extends BaseClass{

	@Test(groups = "Master")
	public void OrderProduct() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		RegistrationPage rp = new RegistrationPage(driver);
		rp.firstName("Vignesh");
		rp.lastName("Kumar");
		rp.email("vigneshkumar02@gmail.com");
		rp.password("qwerty");
		rp.confirmPassword("qwerty");
		rp.newsletBut();
		rp.policyButton();
		rp.telephoneNo("9557483289");
		rp.clickButton();
		logger.info("------------- Account Registration Successful");
		rp.clickLogOut();
		
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
		sp.searchProduct("HP LP3065");
		sp.clickSearchBtn();
		
		logger.info("------ Product Found");

		ProductPage product = new ProductPage(driver);
		product.clickProduct();
		product.clickAddtoCart();
		logger.info("------ Product is added to cart Successfully");

		ViewCart mycart = new ViewCart(driver); 
		mycart.clickCart();
		mycart.clickFullViewCart();
		mycart.clickCheckOut();
		logger.info("------ View Full Cart ---------");

		CheckoutPage order = new CheckoutPage(driver);

		if(!order.isAlreadyExist()) {
			logger.info("------ Checkout is in Progress");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			order.clickContinuePay();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			order.clickContinueShip();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			order.clickContinueShipMeth();
			order.clickAgreeTermsCond();
			order.clickContinuePayMeth();
			order.clickConfirmOrder();
			Thread.sleep(3000);

			try {
				Assert.assertEquals(true, order.isOrderPlaced());
				logger.info("------ Order is Placed Successfully");

			}
			catch(AssertionError e) {
				logger.error("------ Order is not placed");
				Assert.fail();
			}
		}
		else {
			logger.info("------ Checkout is in Progress");

			order.fillFirstName("Raj");
			order.fillLastName("Kumar");
			order.setAddress("No52, Ponnammal thennammal, Nadunedu, Thiru 24");
			order.setCity("Thiru");
			order.setCountry("India");
			order.setState("Tamil Nadu");
			order.setPostCode("2024");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

			order.clickContinuePay();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			order.clickContinueShip();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			order.clickContinueShipMeth();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			order.clickAgreeTermsCond();
			order.clickContinuePayMeth();
			order.clickConfirmOrder();
			Thread.sleep(3000);

			try {
				Assert.assertEquals(true, order.isOrderPlaced());
				logger.info("------ Order is Placed Successfully");

			}
			catch(AssertionError e) {
				logger.error("------ Order is not placed");
				Assert.fail();
			}
		}
	}
	
}
