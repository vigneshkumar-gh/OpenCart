package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPage extends BasePage{
	
	public SearchProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchBox;
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement searchBtn;
	@FindBy(xpath = "//div[@class='caption']//a[contains(text(),'HP LP3065')]")
	WebElement hp;
	@FindBy(xpath = "//a[normalize-space()='iPhone']")
	WebElement iPhone;
	@FindBy(xpath = "//a[normalize-space()='MacBook']")
	WebElement macbook;
	@FindBy(xpath = "//a[normalize-space()='Apple Cinema 30']")
	WebElement apple_monitor;
	@FindBy(xpath = "//a[normalize-space()='Canon EOS 5D']")
	WebElement canon_camera;
	
	
	public void searchProduct(String item){
		searchBox.sendKeys(item);
		searchBtn.click();
	}
	public void clickSearchBtn() {
		searchBtn.click();
	}
	public boolean isProductExist() {
		return hp.isDisplayed();
	}
}