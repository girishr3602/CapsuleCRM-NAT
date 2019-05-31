package com.capsulecrm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capsulecrm.qa.base.TestBase;
import com.capsulecrm.qa.pages.LoginPage;
import com.capsulecrm.qa.util.TestUtil;

public class LoginPage_Test extends TestBase {
	
	LoginPage lp;
	
	public LoginPage_Test() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		
	}
	
	@Test
	public void loginTest() {
		lp.login();
		TestUtil.verifyPageTitle("LearnAutomation CRM");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
