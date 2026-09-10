package baseTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups = {"Sanity", "Regression", "Master"})
	@Parameters({"os", "browser"})
	public void setupDriver(String os,String browser) throws IOException {
		
		FileReader file = new FileReader("./src//test//resources//Config.properties");
		p = new Properties();
		p.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		switch(browser.toLowerCase())
		{
			case "chrome":
			{
				driver = new ChromeDriver();
				break;
			}
			case "edge":
			{
				driver = new EdgeDriver();
				break;
			}
			case "firefox":
			{
				driver = new FirefoxDriver();
				break;
			}
			default :
			{
				System.out.print("No Browser Mentioned!!");
				return;
			}
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = {"Sanity", "Regression", "Master"})
	public void exitDriver() {
		driver.quit();
	}
	
	public String randomString() {
		String s = RandomStringUtils.randomAlphabetic(5);
		return s;
	}
	public String randomNumber() {
		String s = RandomStringUtils.randomNumeric(10);
		return s;
	}
	
	public String captureScreenShot(String testname) throws IOException {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\Screenshots\\" + testname + "_" + timestamp + ".png";                        
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
	
	
	
	
	
	
	
	
	
	
}
