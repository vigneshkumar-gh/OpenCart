package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}

//	@FindBy(xpath = "//a[normalize-space()='iPhone']")
//	WebElement iPhone;
//	@FindBy(xpath = "//a[normalize-space()='MacBook']")
//	WebElement macbook;
//	@FindBy(xpath = "//a[normalize-space()='Apple Cinema 30']")
//	WebElement apple_monitor;
//	@FindBy(xpath = "//a[normalize-space()='Canon EOS 5D']")
//	WebElement canon_camera;
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement addToCartBtn;
	@FindBy(xpath = "//input[@id='input-quantity']")
	WebElement qty;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;
	@FindBy(xpath = "//a[normalize-space()='HP LP3065']")
	WebElement product;
	
	public void clickProduct() {
//		switch (name.toLowerCase())
//		{
//		case "iphone":{iPhone.click();break;}
//		case "macbook":{macbook.click();break;}
//		case "canon":{canon_camera.click();break;}
//		case "apple cinema 30":{apple_monitor.click();break;}
//		default: { break;}
		product.click();
		}
	
	public void setQuantity(String no) {
		qty.sendKeys(no);
	}
	
	public void clickAddtoCart() {
		addToCartBtn.click();
	}
	
	public boolean isProductAdded() {
		return successMsg.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
