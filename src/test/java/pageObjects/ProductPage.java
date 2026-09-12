package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement addToCartBtn;
	@FindBy(xpath = "//input[@id='input-quantity']")
	WebElement qty;
	@FindBy(xpath = "//div[contains(text(),'Success')]")
	WebElement successMsg;
	
	
	
	public void clickProductDetails(String item) {
	System.out.print("Clicked");
		By locator = By.xpath("//a[normalize-space()='" + item + "']");
		driver.findElement(locator).click();
		System.out.print("Clicked");
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
