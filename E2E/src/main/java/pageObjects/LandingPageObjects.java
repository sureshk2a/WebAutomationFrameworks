package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageObjects {

	public WebDriver driver;
	
	//Constructor
	public LandingPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	
	//String the locators as private(is an example of JAVA encapsulation)
	private By formAuthBtn = By.cssSelector("a[href='/login']");
	private By fileUploadLnkBtn = By.cssSelector("a[href='/upload']");
	private By fileDownloadLnkBtn = By.cssSelector("a[href='/download']");
	
	public WebElement getFormAuthButton() {
		return driver.findElement(formAuthBtn);
	}
	
	public WebElement getFileUploadNavButton() {
		return driver.findElement(fileUploadLnkBtn);
	}
	
	public WebElement getFileDownloadNavButton() {
		return driver.findElement(fileDownloadLnkBtn);
	}
}
