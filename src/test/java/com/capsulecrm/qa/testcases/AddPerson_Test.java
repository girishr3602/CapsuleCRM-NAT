package com.capsulecrm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.capsulecrm.qa.base.TestBase;
import com.capsulecrm.qa.pages.AddNewCasePage;
import com.capsulecrm.qa.pages.CasesPage;
import com.capsulecrm.qa.pages.HomePage;
import com.capsulecrm.qa.pages.LoginPage;
import com.capsulecrm.qa.pages.NewPersonPage;
import com.capsulecrm.qa.pages.PeopleAndOrganisationsPage;
import com.capsulecrm.qa.util.TestUtil;

import junit.framework.Assert;

public class AddPerson_Test extends TestBase{

	LoginPage lp;
	HomePage hp;
	PeopleAndOrganisationsPage pop;
	NewPersonPage npp;
	AddNewCasePage ancp;
	CasesPage cp;
	
	Logger log = Logger.getLogger("AddPerson_Test");
	
	public AddPerson_Test() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("Initialized Driver");
		lp = new LoginPage();
		log.info("Initialized Login Page");
		lp.login();
		log.info("Logged In successfully");
		hp = new HomePage();
		log.info("Initialized Home page");
		
	}
	
	@DataProvider
	public Object[][] getNewUserData() {
		Object data[][] = TestUtil.getTestData(prop.getProperty("addPersonsheet"));
		log.info("Person Data read Successfully");
		return data;
	}
	
	@DataProvider
	public Object[][] getNewCaseData(){
		Object data[][] = TestUtil.getTestData(prop.getProperty("addNewCasesheet"));
		log.info("Test Case Data read successfully");
		return data;
		
	}
	
	@Test (priority = 1, dataProvider = "getNewUserData")
	public void addNewPerson(String title, String firstname, String lastname, String tags, String phonenumber, String emailaddresses) {
		hp.clickOnPeopleAndOrganisations();
		log.info("Click on People Icons");
		pop = new PeopleAndOrganisationsPage();
		pop.verifyPOTitleVisibility();
		log.info("Validate People and Organisations page");
		
		
		
		/*
		 * pop.clickAddPerson(); npp = new NewPersonPage(); npp.addNewPerson(title,
		 * firstname, lastname, tags, phonenumber, emailaddresses);
		 */
		//pop.verifyPersonAdded(firstname, lastname);
		 Assert.assertTrue(pop.verifyPersonAdded("QA", "Test"));
		 
	}
	
	@Test (priority = 2, dataProvider = "getNewCaseData")
	public void addNewCase(String CaseRelatesTo, String Name, String Description, String Tags, String Track) {
		hp.clickCases();
		cp = new CasesPage();
		cp.clickAddCaseButton();
		
		ancp = new AddNewCasePage();
		ancp.addNewCase(CaseRelatesTo, Name, Description, Tags, Track);
	}
	
	
	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
