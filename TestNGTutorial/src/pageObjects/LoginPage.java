package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webPage.WebPage;

public class LoginPage extends WebPage {

public LoginPage(WebDriver driver)  {
		super(driver); 
	}

	public void ClickOnSignInUsingEmailIDLink() {
		WebElement SignInUsingEmailIDLink = driver
				.findElement(By.cssSelector(".loginFlowSecondaryLink.loginFlowSecondaryLinkOTP.af_commandLink"));
		Log.info("Sign in using email id link - found");
		SignInUsingEmailIDLink.click();
		Log.info("Sign in using email id link - clicked");
	}

//	private WebDriverWait wait = new WebDriverWait(driver, 30);

	public void setEmailID(String eMailId) {
		try {
			WebElement EmailIDTxt = driverWait.until(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name=\"pt1:r1:1:sb11:it1\"]")));
			Log.info("email id textbox - found");
			EmailIDTxt.sendKeys(eMailId);
			Log.info("Entered email id as '" + eMailId + "'");
		}
		catch(Exception ex) {
			Log.error(ex.getMessage());
			throw ex;
		}
	}

	public void setPassword(String pwd) {
		try {
			WebElement pwdTxt = driver.findElement(By.cssSelector("input[name=\"pt1:r1:1:sb11:it2\"]"));
			Log.info("password textbox - found");
			pwdTxt.sendKeys(pwd);
			Log.info("Entered password as '" + pwd + "'");
		}
		catch(Exception ex) {
			Log.error(ex.getMessage());
			throw ex;
		}
	}

	public void ClickOnSignInButton() {
		try {
		WebElement SignInbtn = driver.findElement(By.cssSelector("button[id=\"pt1:r1:1:sb11:cb1\"]"));
		Log.info("password textbox - found");
		SignInbtn.click();
		Log.info("Signin button - clicked");
		}
		catch(Exception ex) {
			Log.error(ex.getMessage());
			throw ex;
		}
	}
}
