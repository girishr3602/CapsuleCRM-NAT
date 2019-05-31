package com.capsulecrm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capsulecrm.qa.base.TestBase;
import com.capsulecrm.qa.pages.HomePage;
import com.capsulecrm.qa.pages.LoginPage;
import com.capsulecrm.qa.pages.PeopleAndOrganisationsPage;
import com.capsulecrm.qa.util.TestUtil;

public class AddPerson_Test extends TestBase{

	LoginPage lp;
	HomePage hp;
	PeopleAndOrganisationsPage pop;
	
	public AddPerson_Test() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		lp.login();
		hp = new HomePage();
		
	}
	
	@Test
	public void addNewPerson() {
		hp.clickOnPeopleAndOrganisations();
		pop = new PeopleAndOrganisationsPage();
		TestUtil.explicitWait(driver.findElement(By.id("ember72")));
		String currentURl = pop.verifyPeopleAndOrganisationsURL();
		Assert.assertTrue(currentURl.contains("parties"));
		pop.verifyPOTitleVisibility();
		 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
