package TestNG.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.FileUploadPageObjects;
import pageObjects.LandingPageObjects;

public class UploadFile extends Base{
	
	WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	@Parameters("browser")
	public void DriverInit(@Optional("Chrome") String borwser) throws IOException {
		driver = initializeDriver(borwser);
		log.info("Driver initialized");
	}
	
	@BeforeMethod
	public void UploadfilePageNavigation() {
		driver.get(prop.getProperty("url"));	
		LandingPageObjects lpObj = new LandingPageObjects(driver);
		lpObj.getFileUploadNavButton().click();
		log.info("Navigated to form File upload Page");
	}
	
	@Test
	public void UploadTheFile() throws InterruptedException, IOException {
		FileUploadPageObjects uploadPage = new FileUploadPageObjects(driver);
		uploadPage.getFileUploadLinkBtn().click();	
		Thread.sleep(4000);
		//You need to install AUtoit and create a script as fileupload to run to execute the below code
		//This is not the only way to handle the upload window, you can also use the robot class of java to simulate the keystrokes
		
		Runtime.getRuntime().exec("C:\\Users\\suresha\\eclipse-workspace\\E2E\\src\\main\\java\\resources\\fileupload.exe");
		Thread.sleep(10000);
	}
	
	
	@AfterTest
	public void TearDown() {
		driver.close();
	}

}
