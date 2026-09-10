package TestCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class TC001_AccRegisterTest extends BaseClass{
	
	
	@Test(groups = {"Sanity", "Master"})
	public void AccRegTestMethod() throws InterruptedException{
		// Creating HomePage Object and passing driver
		
		logger.info("--------- Home Page is Opened -----------");
		HomePage homepage = new HomePage(driver);
		homepage.clickMyAccount();
		homepage.clickRegister();
		try {
		logger.info("--------- Account Register ---------------");
		// Creating RegistrationPage Object and passing driver
		RegistrationPage registerpage = new RegistrationPage(driver);
		registerpage.firstName(p.getProperty("first_name"));
		registerpage.lastName(p.getProperty("last_name"));
		registerpage.email(randomString()+"@gmail.com");
		registerpage.telephoneNo("9345861292");
		registerpage.password("qwerty123");
		registerpage.confirmPassword("qwerty123");
		registerpage.newsletBut();
		registerpage.policyButton();
		registerpage.clickButton();
		String msgReceived = registerpage.accCreConfirmMsg();
		registerpage.clickContinue();
		registerpage.clickLogOut();
		String logoutMsg = registerpage.accountLogOutConfMsg();
		registerpage.continueLogout();
		
		Assert.assertEquals(logoutMsg, "Account Logout");  // Atlast Checking all steps results to expected outcome
		logger.info("------Account Logout is Successful----------");
		}
		catch(AssertionError e)
		{
			logger.error("Test failed");	
			logger.debug("Debug logs");
			Assert.fail();
		}
		// To see result as expected 
		// Thread.sleep(5000);
		logger.info("-----------> FinishedTest Case : Account Registration ");
	}
}
