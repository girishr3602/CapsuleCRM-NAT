package com.capsulecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.qa.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	/* Page Factory -- Object Repository */
	@FindBy (xpath = "//*[@id='ember15']")
	WebElement dashboard;
	
	@FindBy (id = "ember17")
	WebElement peopleAndOrganisations;
	
	@FindBy (id = "ember19")
	WebElement calendarAndTasks;
	
	@FindBy (id = "ember21")
	WebElement salesPipeline;
	
	@FindBy (id = "ember23")
	WebElement cases;
	
	@FindBy (id = "ember25")
	WebElement reports;
	
	@FindBy (id = "ember30")
	WebElement userName;
	
	@FindBy (xpath = "//*[@class='nav-bar-username']") //(xpath = "//[contains(text(),'Girish R')]")
	WebElement accountName; 
	
	
	/* Methods -- Test cases */
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public String validateUserName () {
		String accName = accountName.getText();
		return accName;
	}
	
	
	public void selectDashboard() {
		dashboard.click();
	}
	
	public PeopleAndOrganisationsPage clickOnPeopleAndOrganisations() {
		peopleAndOrganisations.click();
		return new PeopleAndOrganisationsPage();
	}
	
}
