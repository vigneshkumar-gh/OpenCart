package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	WebElement firstname;
	@FindBy(xpath = "//input[@id='input-payment-lastname']")
	WebElement lastname;
	@FindBy(xpath = "//input[@id='input-payment-address-1']")
	WebElement address;
	@FindBy(xpath = "//input[@id='input-payment-city']")
	WebElement city;
	@FindBy(xpath = "//input[@id='input-payment-postcode']")
	WebElement postcode;
	@FindBy(xpath = "//select[@id='input-payment-country']")
	WebElement country;
	@FindBy(xpath = "//select[@id='input-payment-zone']")
	WebElement state;
	@FindBy(xpath = "//input[@id='button-payment-address']")
	WebElement continuePay;
	@FindBy(xpath = "//label[normalize-space()='I want to use an existing address']//input[@name='payment_address']")
	WebElement existingAddress;
	@FindBy(xpath = "//label[normalize-space()='I want to use an existing address']//input[@name='shipping_address']")
	WebElement shipAddress;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement termsAndCond;
	@FindBy(xpath = "//input[@id='button-confirm']")
	WebElement confirmOrder;
	@FindBy(xpath = "//h1[normalize-space()='Your order has been placed!']")
	WebElement successMsg;
	@FindBy(xpath = "//input[@id='button-shipping-address']")
	WebElement continueShip;
	@FindBy(xpath = "//input[@id='button-shipping-method']")
	WebElement continueShipMeth;
	@FindBy(xpath = "//input[@id='button-payment-method']")
	WebElement continuePayMeth;
	
	public boolean isAlreadyExist() {
		return firstname.isDisplayed();
	}
	
	public void fillFirstName(String name) {
		firstname.sendKeys(name);
	}
	public void fillLastName(String name) {
		lastname.sendKeys(name);
	}
	public void setAddress(String code) {
		address.sendKeys(code);
	}
	public void setCity(String name) {
		city.sendKeys(name);
	}
	public void setPostCode(String name) {
		postcode.sendKeys(name);
	}
	public void setCountry(String name) {
		Select select = new Select(country);
		select.selectByVisibleText(name);
	}
	public void setState(String name) {
		Select select = new Select(state);
		select.selectByVisibleText(name);
	}
	public void clickContinuePay() {
		continuePay.click();
	}
	public void clickContinueShip() {
		continueShip.click();
	}
	public void clickContinueShipMeth() {
		continueShipMeth.click();
	}
	public void clickContinuePayMeth() {
		continuePayMeth.click();
	}

	public void clickExistAddress() {
		existingAddress.click();
	}
	public void clickShipAddress() {
		shipAddress.click();
	}
	public void clickAgreeTermsCond() {
		termsAndCond.click();
	}
	public void clickConfirmOrder() {
		confirmOrder.click();
	}
	public boolean isOrderPlaced() {
		return successMsg.isDisplayed();
	}
	
	
}