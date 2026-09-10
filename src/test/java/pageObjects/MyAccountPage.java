package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement accountMsg;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logOutButton;
	
	public boolean isMyAccountPageDisplayed() {
		try {
			return accountMsg.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	public void clickLogOutButton() {
		logOutButton.click();
	}
	
	
	
	
	
	
}
