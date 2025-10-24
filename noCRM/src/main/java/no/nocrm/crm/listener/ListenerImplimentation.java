package no.nocrm.crm.listener;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import no.nocrm.crm.base.BaseClass;
import no.nocrm.crm.webDriverUtility.JavaUtility;
import no.nocrm.crm.webDriverUtility.UtilityClassObject;


/**
 * @author Manikandan
 */
public class ListenerImplimentation extends BaseClass implements ISuiteListener, ITestListener {

	JavaUtility ju = new JavaUtility();
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;

	
	@Override
	public void onStart(ISuite suite) {
	
		//Create spark report config
		spark = new ExtentSparkReporter("./html_Report/ExtentReport_"+ju.getCurrentTimeAndDate()+".html");
		spark.config().setDocumentTitle("CRM TestSuite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		// Add Environment Info & Create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WINDOWS-11");
		report.setSystemInfo("BROWSER", "CHROME");
		//ISuiteListener.super.onStart(suite);
		
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		test = report.createTest(result.getName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, testName+" =====> TESTSCRIPT STARTED <===== ");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		test.log(Status.INFO, testName+" =====> TESTSCRIPT COMPLETED <===== ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sDriver;
		
		/* Take ScreenShot .png Format*/
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File desp = new File("./screenshots/"+testName+"_"+ju.getCurrentTimeAndDate()+".png");
		try {
			FileHandler.copy(temp, desp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* Store Screenshot in Html_Report BASE64 Format */
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64),result.getName()+"="+ju.getCurrentTimeAndDate()+".html");
//		test.addScreenCaptureFromBase64String(temp, result.getMethod().getMethodName());
		test.log(Status.FAIL, testName+"=====> FAILED <=====");
		Reporter.log(testName+" ==> FAIL",true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.INFO, "=====> TESTSCRIPT SKIPPED <=====");
	}
	
}

