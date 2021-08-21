package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationFormPageObjects {
	
	public WebDriver driver;
	
	public AuthenticationFormPageObjects(WebDriver _driver) {
		// TODO Auto-generated constructor stub
		this.driver = _driver;
	}
	
	By userNameTxtBox = By.cssSelector("#username");
	By passwordTxtBox = By.cssSelector("#password");
	By loginBtn = By.cssSelector("button[type='submit']");
	By successLoginFlag = By.cssSelector("div[class='flash success']");
	By logoutBtn = By.xpath("//i[contains(text(),'Logout')]");
	
	public void LoginWithCredentials(String username,String password) {
		driver.findElement(userNameTxtBox).sendKeys(username);
		driver.findElement(passwordTxtBox).sendKeys(password);
		driver.findElement(loginBtn).click();
	}
	
	public WebElement successFlag() {
		return driver.findElement(successLoginFlag);
	}
	
	public WebElement logoutBtn() {
		return driver.findElement(logoutBtn);
	}
	
	
}
