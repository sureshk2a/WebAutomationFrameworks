package TestNG.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dataProviders.DPClass;

import TestNG.E2E.RetryListeners;
import pageObjects.AuthenticationFormPageObjects;
import pageObjects.LandingPageObjects;

public class LogoutForm extends Base {
	
	WebDriver driver;

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	@Parameters("browser")
	public void DriverInit(@Optional("Chrome") String borwser) throws IOException { //The @Optional is like a default parameter for a method, if you 
																					//didn't pass any parameters from cml it'll take the default parameter
		driver = initializeDriver(borwser);
		log.info("Driver initialized");
	}
	
	@BeforeMethod
	public void AuthPageNavigation() {
		driver.get(prop.getProperty("url"));	
		LandingPageObjects lpObj = new LandingPageObjects(driver);
		lpObj.getFormAuthButton().click();
		log.info("Navigated to form authentication");
	}
	
	@Test(dataProvider = "LoginData",dataProviderClass = DPClass.class,retryAnalyzer = RetryListeners.class) //retryAnalyzer is a common class you can craete to tell your
																											//test methods to retry the tests after a failure
	public void LogoutOfForm(String username, String Password) {
		AuthenticationFormPageObjects authPage = new AuthenticationFormPageObjects(driver);
		authPage.LoginWithCredentials(username, Password);
		Assert.assertTrue(authPage.successFlag().getText().contains("logged into"));
	}
	
	@AfterTest
	public void TearDown() {
		driver.close();
	}
	
}
