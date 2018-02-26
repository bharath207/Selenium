package webApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ConfigFileReader;
import utility.Log;

public class WebApp extends Log {

	private String url = ConfigFileReader.getPropertyValue("config//Configuration.properties", "url");
	public String browserType = ConfigFileReader.getPropertyValue("config//Configuration.properties", "browser");
	public WebDriver driver;
	public boolean isApplicationLaunched;
	public WebDriverWait driverWait;

	public WebApp() {
    	try{
	        driver = startLocalDriver(browserType);
	        driver.get(url);
	        
	        Log.info("Current URL -" + driver.getCurrentUrl());
	         if(driver.getCurrentUrl().equalsIgnoreCase(url)){
	        	isApplicationLaunched = true;
	        	Log.info("Navigate to URL - " + url);
	        	driver.manage().window().maximize();
	        }
    	}
    	catch(Exception ex)
    	{
    		Log.error("Exception - " + ex.getMessage());
    		driver.quit();
    		throw ex;
    	}
      }

	public WebDriver startLocalDriver(String browserType) {
		switch(browserType.toLowerCase().trim()) {
		case "chrome":
		System.setProperty("webdriver.chrome.driver",
				ConfigFileReader.getPropertyValue("config//Configuration.properties", "chromeDriverPath"));
		driver = new ChromeDriver();
		break;
		case "firefox":
		System.setProperty("webdriver.gecko.driver",
				ConfigFileReader.getPropertyValue("config//Configuration.properties", "fireFoxDriverPath"));
		driver = new FirefoxDriver();
		break;
		}
		return driver;
	}

}
