package com.capsulecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.qa.base.TestBase;

public class PeopleAndOrganisationsPage extends TestBase {
	
	public PeopleAndOrganisationsPage() {
		PageFactory.initElements(driver, this);
	}

	/* Object Repository */
	@FindBy (xpath ="//*[@class='page-header-title']")
	WebElement peoplePageTitle;
	
	@FindBy (id = "ember71")
	WebElement addPerson;
	
	@FindBy (id = "ember72")
	WebElement addOrganisation;
	
	@FindBy (id = "ember73")
	WebElement importButton;
	
	/*Methods -- Actions*/
	public String verifyPeopleAndOrganisationsURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean verifyPOTitleVisibility() {
		return peoplePageTitle.isDisplayed();
	}
	
}
