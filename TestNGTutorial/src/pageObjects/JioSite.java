package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import webPage.WebPage;

public class JioSite extends WebPage {

	
	public JioSite(WebDriver driver)  {
		
		super(driver);

		
		
	}

	public void ClickOnSigninLink()
	{
	
		try {
		WebElement signinLink = driver.findElement(By.cssSelector("li[id=SignIn] > a"));
		Log.info("Signin link found");
		signinLink.click();
		Log.info("Signin link - clicked");
		}
		catch(Exception ex) {
			Log.error(ex.getMessage());
			throw ex;
		}
	}
}
