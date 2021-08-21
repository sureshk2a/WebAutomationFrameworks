package TestNG.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dataProviders.DPClass;
import pageObjects.AuthenticationFormPageObjects;
import pageObjects.LandingPageObjects;

public class LoginForm extends Base {

	WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	@Parameters("browser") //You can send parameters to test from your xml file
	public void DriverInit(String borwser) throws IOException {
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
	
	//You can have a common data provider which can read from seperate class file
	@Test(dataProvider = "LoginData",dataProviderClass = DPClass.class)
	public void LoginToForm(String username, String Password) {
		AuthenticationFormPageObjects authPage = new AuthenticationFormPageObjects(driver);
		authPage.LoginWithCredentials(username, Password);
		Assert.assertTrue(authPage.successFlag().getText().contains("logged into"));
	}
	
	@AfterTest
	public void TearDown() {
		driver.close();
	}
	
}
