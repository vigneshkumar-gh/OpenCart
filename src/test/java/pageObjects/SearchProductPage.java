package pageObjects;

import org.openqa.selenium.By;
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
	
	
	
	public void searchProduct(String item){
		searchBox.sendKeys(item);
	}
	public void clickSearchBtn() {
		searchBtn.click();
	}
	public boolean isProductsExist(String item) {
		By locator = By.xpath("//a[contains(text(),'" + item + "']");
		return driver.findElement(locator).isDisplayed();
	}
}