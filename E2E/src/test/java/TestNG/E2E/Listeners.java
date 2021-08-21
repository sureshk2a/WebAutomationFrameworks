package TestNG.E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.EntendReporterNG;

public class Listeners extends Base implements ITestListener{

	//The listener will watch your tests and will do specific jobs based on test method results
	//Define you listener in your testng.xml file
	//You can have more than one listener if you are using more than one testng.xml
	
	ExtentTest test;
	ExtentReports extent=EntendReporterNG.getReporter();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>(); //Makes the extentTest object thread safe for parellel execution
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		//This method will be executed if the test method passed
		
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//This method will be executed if any of your test method fails
		
		extentTest.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
		try {
			String screenshotPath = getScreenshot(result.getMethod().getMethodName(), driver);
			extentTest.get().addScreenCaptureFromPath(screenshotPath,result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
