package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseTest.BaseClass;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporters;
	public ExtentReports reports;
	public ExtentTest test;
	String reportName;
	public void onStart(ITestContext testContext) {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		reportName = "Test-Report-" + timestamp + ".html";
		sparkReporters = new ExtentSparkReporter(".\\reports\\" + reportName);
		sparkReporters.config().setDocumentTitle("OpenCart Automation Testing Report");
		sparkReporters.config().setReportName("OpenCart Functional Testing");
		sparkReporters.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(sparkReporters);
		reports.setSystemInfo("Application", "OpenCart");
		reports.setSystemInfo("Module", "Admin");
		reports.setSystemInfo("Sub Module", "Customers");
		reports.setSystemInfo("User Name", System.getProperty("user.name"));
		reports.setSystemInfo("Environment", "QA");
		String os = testContext.getCurrentXmlTest().getParameter("os");
		reports.setSystemInfo("OS", os);
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		reports.setSystemInfo("Browser", browser);
		List <String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		reports.setSystemInfo("Groups", includedGroups.toString());
	}
	public void onTestSuccess(ITestResult result) {
		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+" got successfully executed");
	}
	public void onTestFailure(ITestResult result) {
		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+" got Failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		try {
			String imagePath = new BaseClass().captureScreenShot(result.getName());
			test.addScreenCaptureFromPath(imagePath, result.getName() + "_" + result.getName());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+" got Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());	
	}
	
	public void onFinish(ITestContext testContext) {
		reports.flush();
		
		String pathOfExtentReport = ".\\reports\\" + reportName;
		File extentReport = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
