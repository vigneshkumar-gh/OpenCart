package pageObjects;

import org.openqa.selenium.*;

import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	WebDriver driver;
	public RegistrationPage(WebDriver driver){
		super(driver);
	}
	
	// Here are the Elements in Registration Page
	@FindBy(id = "input-firstname")
	WebElement firstName;
	@FindBy(id = "input-lastname")
	WebElement lastName;
	@FindBy(id = "input-email")
	WebElement emailId;
	@FindBy(id = "input-telephone")
	WebElement telephone;
	@FindBy(id = "input-password")
	WebElement password;
	@FindBy(id = "input-confirm")
	WebElement confirmPassword;
	@FindBy(xpath = "//input[@value='0']")
	WebElement newsLetBut;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement polButton;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement button;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgDisplayed;
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement cnteButton;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout;
	@FindBy(xpath = "//h1[normalize-space()='Account Logout']")
	WebElement accLogOutMsg;
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement contButton;
	
	
	
	
	
	// Here Actions on Elements 
	public void firstName(String name) {
		firstName.sendKeys(name);
	}
	public void lastName(String name) {
		lastName.sendKeys(name);
	}
	public void email(String id) {
		emailId.sendKeys(id);
	}
	public void password(String code) {
		password.sendKeys(code);
	}
	public void confirmPassword(String code) {
		confirmPassword.sendKeys(code);
	}
	public void telephoneNo(String no) {
		telephone.sendKeys(no);
	}
	public void newsletBut() {
		newsLetBut.click();
	}
	public void policyButton() {
		polButton.click();
	}
	public void clickButton() {
		button.click();
	}
	public String accCreConfirmMsg() {
		try {
			return msgDisplayed.getText();
		}
		catch (Exception e) {
			return e.getMessage();
		}	
	}
	public void clickContinue() {
		cnteButton.click();
	}
	public void clickLogOut() {
		logout.click();
	}
	public String accountLogOutConfMsg() {
		try {
			return accLogOutMsg.getText();
		}
		catch (Exception e) {
			return e.getMessage();
		}	
	}
	public void continueLogout() {
		contButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
