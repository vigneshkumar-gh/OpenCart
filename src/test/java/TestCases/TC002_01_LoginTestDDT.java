package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_01_LoginTestDDT extends BaseClass{
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void dataDrivenLoginTest(String email, String password, String result) throws InterruptedException {
		
		logger.info("------------ Data Driven Login Test is Started ");
		try {
			HomePage homepage = new HomePage(driver);
			homepage.clickMyAccount();
			homepage.clickLogin();
		
			LoginPage loginpage = new LoginPage(driver);
			loginpage.setEmailID(email);
			loginpage.setPassword(password);
			loginpage.clickSubmitButton();
		
			MyAccountPage myaccount = new MyAccountPage(driver);
			boolean accountPage = myaccount.isMyAccountPageDisplayed();

			if(result.equalsIgnoreCase("valid")) {
				if(accountPage == true) {
					Assert.assertTrue(true);
					myaccount.clickLogOutButton();
				}
				else {
					Assert.assertTrue(false);
				}
			}

			if(result.equalsIgnoreCase("invalid")) {
					if(accountPage == true ) {
						myaccount.clickLogOutButton();
						Assert.assertTrue(false);
					}
					else {
						Assert.assertTrue(true);
					}
			}
		}
		catch(AssertionError e) {
			Assert.fail();
		}
		logger.info("----------------- Test Execution Completed");
		
		
	}
}
