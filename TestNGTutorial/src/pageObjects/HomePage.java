package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webPage.WebPage;

public class HomePage extends WebPage {

	public HomePage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}

	By user = By.cssSelector("a[id='pt1:goLink38'].quickPayText.userFirstName.af_goLink.p_AFDisabled");

	public String getLoggedInUser() {
		return driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(user))).getText();
	}
}
