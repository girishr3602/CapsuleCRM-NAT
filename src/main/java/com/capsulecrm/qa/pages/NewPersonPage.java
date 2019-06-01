package com.capsulecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.capsulecrm.qa.base.TestBase;

public class NewPersonPage extends TestBase {
	
	public NewPersonPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	/* Object Repository */
	@FindBy (xpath = "//*[contains(text(),'New Person')]")
	WebElement pageHeader;
	
	@FindBy (name = "party:j_id108:j_id116")
	WebElement title;
	
	@FindBy (id = "party:fnDecorate:fn")
	WebElement firstName;
	
	@FindBy (id = "party:lnDecorate:ln")
	WebElement lastName;
	
	@FindBy (id = "party:tagsDecorate:tagComboBox")
	WebElement addTagDropdown;
	
	@FindBy (xpath = "//*[@value = 'Add tag']")
	WebElement addTagButton;
	
	@FindBy (xpath = "//*[@value = 'Save']")
	WebElement save;
	
	@FindBy (xpath = "//*[contains(text(),'Cancel')]")
	WebElement cancel;
	
	
	public void addNewPerson(String usertitle, String firstname, String lastname, String tags, String phonenumber, String emailaddressses) {	
		pageHeader.isDisplayed();
		Select selectTitle = new Select(title);
		selectTitle.selectByValue(usertitle);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		
		
		
	}
	
	
	

}
