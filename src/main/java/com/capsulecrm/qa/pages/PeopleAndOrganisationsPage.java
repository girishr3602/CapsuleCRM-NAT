package com.capsulecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.qa.base.TestBase;
import com.capsulecrm.qa.util.TestUtil;

public class PeopleAndOrganisationsPage extends TestBase {
	
	public PeopleAndOrganisationsPage() {
		PageFactory.initElements(driver, this);
	}

	/* Object Repository */
	@FindBy (xpath ="//*[@class='page-header-title']")
	WebElement peoplePageTitle;
	
	@FindBy (xpath = "//*[contains(text(),'Add Person')]")
	WebElement addPerson;
	
	@FindBy (xpath = "//*[contains(text(),'Add Organisation')]")
	WebElement addOrganisation;
	
	@FindBy (xpath = "//*[contains(text(),'Import')]")
	WebElement importButton;
	
	@FindBy (id = "ember88")
	WebElement personname;
	
	/*Methods -- Actions*/
	public String verifyPeopleAndOrganisationsURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean verifyPOTitleVisibility() {
		TestUtil.explicitWait(driver, peoplePageTitle);
		return peoplePageTitle.isDisplayed();
	}
	
	public NewPersonPage clickAddPerson() {
		addPerson.click();
		return new NewPersonPage();
	}
	
	public String verifyPersonAdded(String personName) {
		return personname.getText();
		
	}
	
}
