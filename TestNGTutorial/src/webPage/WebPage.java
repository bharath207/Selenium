package webPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class WebPage extends Log  {

	public WebDriver driver;
	public WebDriverWait driverWait;
	
	protected String windowHandle; 
	public WebPage(WebDriver webdriver) {
		if(webdriver == null)
		{
			Log.error("WebDriver Not Initialized");
			throw new WebDriverException("WebDriver Not Initialized");
		}
		driver = webdriver;
		windowHandle = driver.getWindowHandle();
		PageFactory.initElements(driver, this);
		
		driverWait = new WebDriverWait(driver, 60);
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
	}
	
	public String GetUrl() { 
		return driver.getCurrentUrl();
	}
}
