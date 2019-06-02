package com.capsulecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsulecrm.qa.base.TestBase;

public class CasesPage extends TestBase {
	
	public CasesPage() {
		PageFactory.initElements(driver, this);
	}
	
	/* Object Repository */
	@FindBy(className = "page-header-title")		//(xpath = "//*[@class='page-header-title']")
	WebElement pageHeader;

	@FindBy (xpath = "//*[contains(text(),'Add Case')]")		//(xpath = "//*[text()='Add Case']")		 //(xpath = "//*[contains(text(),'Add Case')]")
	WebElement addCaseButton;
	
	
	
	/* Methods -- Actions */
	public AddNewCasePage clickAddCaseButton() {
		addCaseButton.click();
		return new AddNewCasePage();
	}
	
}
