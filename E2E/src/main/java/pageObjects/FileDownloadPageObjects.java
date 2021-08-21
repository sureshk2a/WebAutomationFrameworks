package pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileDownloadPageObjects {
	
	public WebDriver driver;
	
	public FileDownloadPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	private By allFileLinks = By.xpath("//div[@class='example']/a");
	
	public void downloadAllFiles() {
		
		//Store all links in a list
		List<WebElement> links = driver.findElements(allFileLinks);
		
		System.out.println(links.size());
		
		//Loop through the list of webElement and click all the elements (In site it will apparently download all the files)
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText());;
			links.get(i).click();
			
		}
	}
	
	public void downloadSpecificFile(String fileName) {
		
		//Store all links in a list
		List<WebElement> links = driver.findElements(allFileLinks);
		
		//Loop through the list of webElement to check if that's the file that you've been looking for 
		for(int i=0;i<links.size();i++) {
			if(fileName == links.get(i).getText()) {
				links.get(i).click();
			}
		}
	}
	
	
}
