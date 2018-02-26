package controller;

import webApp.WebApp;
import pageObjects.*;

public class MyJioApp extends WebApp {

	
	
	public MyJioApp() {
		
			
	}
	
	public JioSite jioSite() {
		if (!isApplicationLaunched)
			new WebApp();

		return new JioSite(driver);
	}

	private LoginPage _login;

	public LoginPage login() {
		if (_login == null)
			_login = new LoginPage(driver);

		return _login; 
	}

	private HomePage _homePage;

	public HomePage home() {
		if (_homePage == null)
			_homePage = new HomePage(driver);

		return _homePage;
	}

}
