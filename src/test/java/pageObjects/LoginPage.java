package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	//public WebDriver driver;
	public LoginPage(WebDriver driver){
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailId;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement submitButton;
	
	
	public void setEmailID(String id) {
		emailId.sendKeys(id);
	}
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	public void clickSubmitButton() {
		submitButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
