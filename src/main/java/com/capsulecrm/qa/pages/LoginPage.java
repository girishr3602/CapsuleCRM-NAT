package com.capsulecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.qa.base.TestBase;

public class LoginPage extends TestBase{

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	/* Page Factory -- Object Repository */
	@FindBy (xpath = "//*[@class='logo']")
	WebElement capsuleLogo;
	
	@FindBy (id = "login:usernameDecorate:username")
	WebElement username;
	
	@FindBy (xpath = "//*[@id='login:passwordDecorate:password']")
	WebElement password;
	
	@FindBy (id = "login:login")
	WebElement submitButton;
	
	@FindBy (id = "login:rememberMeDecorate:rememberMe")
	WebElement rememberMe;
	
	/* Methods -- Test cases */
	/*
	 * public void verifyHomePageTitle() { String pageTitle = driver.getTitle(); }
	 */
		
	public HomePage login() {
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		submitButton.click();
		return new HomePage();
		
	}
}
