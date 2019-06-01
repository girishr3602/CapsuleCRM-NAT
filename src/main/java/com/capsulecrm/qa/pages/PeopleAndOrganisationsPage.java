package com.capsulecrm.qa.pages;

import java.util.Iterator;
import java.util.List;

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
	
	@FindBy (xpath = "//*[@class='tooltipper list-results-row ember-view']/td[3]")
	List <WebElement> personnameList;
	
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
	
	public void verifyPersonAdded(String firstname, String lastname) {
		//System.out.println(personnameList.size());
		String personName = firstname + " " + lastname;
		
		Iterator <WebElement> nameIterator = personnameList.iterator();
		
		if(nameIterator.hasNext()) {
			for(int i=0; i<personnameList.size(); i++) {
				nameIterator.next();
				//System.out.println(personnameList.get(i).getText().contains(personName));
				
				if(personnameList.get(i).getText().contains(personName)) {
					//System.out.println("Person Name Present");
					break;
				}
				
			}
		}
		
	}
	
}
