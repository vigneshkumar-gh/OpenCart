package TestCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass{
	

	@Test(groups = { "Regression", "Master"})
	public void LoginTestMethod() {
		logger.info("------------ Begin of Login Test");
		try {
			logger.info("Home Page is Displayed");
			HomePage homepage = new HomePage(driver);
			homepage.clickMyAccount();
			homepage.clickLogin();
		
			logger.info("Navigated to Login Page");
			LoginPage loginpage = new LoginPage(driver);
			loginpage.setEmailID(p.getProperty("emailId"));
			loginpage.setPassword(p.getProperty("password"));
			loginpage.clickSubmitButton();
			
			logger.info("After Login Success, Navigates to Account Page");
			MyAccountPage accountpage = new MyAccountPage(driver);
			//Assert.assertEquals(accountpage.isMyAccountPageDisplayed(), true, "Account Login");
			Assert.assertTrue(accountpage.isMyAccountPageDisplayed());
			
			logger.info("----------- Account Login is Successful and My Account is Displayed");
		}
		catch(AssertionError e) {
			logger.error("Test Failed!");
			logger.debug("Debug Login Test for Error Detection");
			Assert.fail();
		}
		logger.info("----------- Test Execution is Completed");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
