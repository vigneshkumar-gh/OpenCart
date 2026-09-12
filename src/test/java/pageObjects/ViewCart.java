package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCart extends BasePage{
	
	public ViewCart(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//span[text()='Shopping Cart']")
	WebElement viewCartBtn;
	@FindBy(css = "input[value='1']")
	WebElement fillQty;
	@FindBy(css = "button[type='submit']")
	WebElement updateBtn;
	@FindBy(xpath = "(//button[@type='button'])[11]")
	WebElement deleteItem;
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement checkoutBtn;
	
	public void clickFullViewCart() {
		viewCartBtn.click();
	}
	public void deleteItem(String item) {
		By locator = By.xpath("//tr[.//a[normalize-space()='" + item + "']]//button[@data-original-title='Remove']");
		driver.findElement(locator).click();
	}
	public void updateQuantity(String item, String no) {
		By locator = By.xpath("//tr[.//a[normalize-space()='" + item + "']]//input[@type='text']");
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(no);
		driver.findElement(By.xpath("//tr[.//a[normalize-space()='" + item + "']]//button[@data-original-title='Update']")).click();
	}
	public void clickCheckOut() {
		checkoutBtn.click();
	}
}
