package com.capsulecrm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.capsulecrm.qa.base.TestBase;
import com.capsulecrm.qa.pages.HomePage;
import com.capsulecrm.qa.pages.LoginPage;
import com.capsulecrm.qa.pages.NewPersonPage;
import com.capsulecrm.qa.pages.PeopleAndOrganisationsPage;
import com.capsulecrm.qa.util.TestUtil;

public class AddPerson_Test extends TestBase{

	LoginPage lp;
	HomePage hp;
	PeopleAndOrganisationsPage pop;
	NewPersonPage npp;
	
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
		Object data[][] = TestUtil.getTestData(prop.getProperty("sheetname"));
		return data;
	}
	
	@Test (dataProvider = "getNewUserData")
	public void addNewPerson(String title, String firstname, String lastname, String tags, String phonenumber, String emailaddresses) {
		
		hp.clickOnPeopleAndOrganisations();
		log.info("Click on People Icons");
		pop = new PeopleAndOrganisationsPage();
		pop.verifyPOTitleVisibility();
		log.info("Validate People and Organisations page");
		
		/*
		 * pop.clickAddPerson();
		 * 
		 * npp = new NewPersonPage(); npp.addNewPerson(title, firstname, lastname, tags,
		 * phonenumber, emailaddresses);
		 */
		
		System.out.println(pop.verifyPersonAdded(firstname));
	}
	
	//@Test
	public void getNewUserData1() {
		Object data[][] = TestUtil.getTestData(prop.getProperty("sheetname"));
		System.out.println(data.length);
		System.out.println(data[0].length);
		for(int i=1; i<data[0].length; i++) {
			System.out.println(data[0][i]);
		}
		//System.out.println(data[2]);
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
