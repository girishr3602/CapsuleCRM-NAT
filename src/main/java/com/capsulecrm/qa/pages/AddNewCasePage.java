package com.capsulecrm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.capsulecrm.qa.base.TestBase;

public class AddNewCasePage extends TestBase {
	
	public AddNewCasePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "partySearch")
	WebElement CaseRelatesTo;
	
	@FindBy(name = "caseNameDecorate:name")
	WebElement Name;
	
	@FindBy (id = "caseDescriptionDecorate:description")
	WebElement Description;

	@FindBy (id = "tagsDecorate:tagComboBox")
	WebElement Tags;

	@FindBy (xpath = "//*[@value = 'Add tag']")
	WebElement AddTag;

	@FindBy (name = "caseTypeDecorate:j_id197:j_id205")
	WebElement Track;
	
	@FindBy (name = "save")
	WebElement Save;
	
	@FindBy (id = "cancel")
	WebElement Cancel;
	
	
	public void addNewCase(String caserelatesto, String name, String description, String tags, String track) {
		CaseRelatesTo.sendKeys(caserelatesto);
		
		CaseRelatesTo.sendKeys(Keys.DOWN);
		CaseRelatesTo.sendKeys(Keys.DOWN);
		CaseRelatesTo.click(); 
		System.out.println(CaseRelatesTo.getText());
		Name.sendKeys(name); 
		Description.sendKeys(description); 
		Tags.sendKeys(tags);
		 
		//Track.sendKeys(track);
		
	}
	
	
}
