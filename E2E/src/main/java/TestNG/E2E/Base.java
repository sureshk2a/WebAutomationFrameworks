package TestNG.E2E;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver(String browserName) throws IOException {	
		
		prop = new Properties();
		String proRootPath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(proRootPath+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//String browserName = prop.getProperty("browser");
		
		
		if(browserName.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", proRootPath+"\\Drivers\\chromedriver.exe");
			
			//Set prefs
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory",  proRootPath+"\\downloads");
			prefs.put("profile.default_content_setting_values.notifications", 1);
			
			//Set args
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--no-sandbox","--disable-gpu","--disable-extensions","start-maximized","--window-size=1440, 900");
			
			driver = new ChromeDriver(options);
			
		}else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", proRootPath+"\\Drivers\\geckodriver.exe");
			
			//Set args
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("permissions.default.desktop-notification", 1);
			options.addPreference("browser.download.folderList", 2);
			options.addPreference("browser.download.dir", proRootPath+"\\downloads");
			options.addPreference("browser.download.manager.showWhenStarting", false);
			options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-gzip");
			options.addArguments("--safe-mode","--width=1920","--height=1080");
			
			driver = new FirefoxDriver(options);
		}else if(browserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", proRootPath+"\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenshot(String methodName,WebDriver driver) throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String rootPath = System.getProperty("user.dir")+"\\screenshots\\"+methodName+".jpg";
		FileUtils.copyFile(screenshotFile, new File(rootPath));
		return rootPath;
	}
}
