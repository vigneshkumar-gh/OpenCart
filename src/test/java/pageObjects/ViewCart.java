package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCart extends BasePage{
	
	public ViewCart(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement cartBtn;
	@FindBy(xpath = "//strong[normalize-space()='View Cart']")
	WebElement viewCartBtn;
	@FindBy(xpath = "//input[@name='quantity[391750]']")
	WebElement fillQty;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement update;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement deleteItem;
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement checkoutBtn;
	
	public void clickCart() {
		cartBtn.click();
	}
	public void clickFullViewCart() {
		viewCartBtn.click();
	}
	public void updateQuantity(String no) {
		fillQty.sendKeys(no);
	}
	public void clickUpdate() {
		update.click();
	}
	public void deleteItem() {
		deleteItem.click();
	}
	public void clickCheckOut() {
		checkoutBtn.click();
	}
	
	
	
	
	
}
