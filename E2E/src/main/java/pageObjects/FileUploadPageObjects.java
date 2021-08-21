package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadPageObjects {
	
	public WebDriver driver;
	
	public FileUploadPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	private By fileDragAndDropBtn = By.id("drag-drop-upload");
	private By chooseFileBtn = By.id("file-upload");
	
	public WebElement getFileUploadLinkBtn() {
		return driver.findElement(fileDragAndDropBtn);
	}
	
	public WebElement getChooseFileBtn() {
		return driver.findElement(chooseFileBtn);
	}
	
	
}
