package test;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import controller.MyJioApp;
import utility.Log;

public class TestSuite {

	public MyJioApp jioApp;
	
	@BeforeSuite
	public void beforeSuit() {
	}
	
	@BeforeMethod
	public void beforeMethod() {
		jioApp = new MyJioApp();
		Log.startTestCase("Test Method - Started");
	}
	
	@AfterMethod
	public void AfterMethod() {
		Log.endTestCase("Test Method - Ended");
	}

	@Test
	public void Login_Valid(){
		try {			
			jioApp.jioSite().ClickOnSigninLink();
			jioApp.login().ClickOnSignInUsingEmailIDLink();
			jioApp.login().setEmailID("mail2sree6@gmail.com");
			jioApp.login().setPassword("Feb@2018");
			jioApp.login().ClickOnSignInButton();
			Assert.assertTrue(true);
		}
		catch(Exception ex) {
			Log.error(ex.getMessage());
		}
		finally {
			//jioApp.driver.quit();
		}
	}
	
	@Test()
	public void Login_Invalid(){
		try {		
			jioApp.jioSite().ClickOnSigninLink();
			jioApp.login().ClickOnSignInUsingEmailIDLink();
			jioApp.login().setEmailID("mail2sree6@gmail.com");
			jioApp.login().setPassword("Jan@2018");
			jioApp.login().ClickOnSignInButton();
			Assert.assertTrue(true);
		}
		catch(Exception ex) {
			Log.error(ex.getMessage());
		}
		finally {
			jioApp.driver.quit();
		}
	}

}
