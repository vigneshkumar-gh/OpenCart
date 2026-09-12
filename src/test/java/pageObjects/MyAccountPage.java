package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myAccount;
	@FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
	WebElement cart;
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement accountMsg;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logOutButton;
	
	public boolean isMyAccountPageDisplayed() {
		try {
			return accountMsg.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	public void clickMyAccount() {
		myAccount.click();
	}
	public void clickMyCart() {
		cart.click();
	}
	public void clickLogOutButton() {
		logOutButton.click();
	}
	
	
	
	
	
	
}
