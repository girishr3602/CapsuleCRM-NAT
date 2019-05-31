package com.capsulecrm.qa.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.capsulecrm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static int PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICIT_WAIT = 30;
	public static int EXPLICIT_WAIT = 10;
	
	
	static WebDriverWait wait;
	
	public static void verifyPageTitle(String pagetitle) {
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains(pagetitle));
		
	}
	
	public static void verifyThroughURL() {
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("login"));
		
	}
	
	
	public static void explicitWait(WebElement element) {
		wait = new WebDriverWait(driver, EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
