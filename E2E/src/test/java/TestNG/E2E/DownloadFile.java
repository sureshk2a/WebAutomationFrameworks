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

import pageObjects.FileDownloadPageObjects;
import pageObjects.LandingPageObjects;

public class DownloadFile extends Base {
	
	WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	@Parameters("browser")
	public void DriverInit(@Optional("Chrome") String borwser) throws IOException {
		driver = initializeDriver(borwser);
		log.info("Driver initialized");
	}
	
	@BeforeMethod
	public void DownloadfilePageNavigation() {
		driver.get(prop.getProperty("url"));	
		LandingPageObjects lpObj = new LandingPageObjects(driver);
		lpObj.getFileDownloadNavButton().click();
		log.info("Navigated to file download Page");
	}
	
	@Test
	public void DownloadTheFile() throws InterruptedException {
		FileDownloadPageObjects dowloadPage = new FileDownloadPageObjects(driver);
		dowloadPage.downloadAllFiles();	
		Thread.sleep(4000);
	}
	
	
	@AfterTest
	public void TearDown() {
		driver.close();
	}
}
