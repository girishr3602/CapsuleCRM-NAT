package com.capsulecrm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capsulecrm.qa.base.TestBase;

public class TestRun extends TestBase {

	public TestRun() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
	}
	
	@Test
	public void testRun() {
		String OS_NAME = System.getProperty("os.name");
		
		System.out.println(OS_NAME);
		if(OS_NAME.contains("Windows")) {
			System.out.println("Opearating System is : " + OS_NAME);
		}else if(OS_NAME.contains("Linux")) {
			System.out.println("Opearating System is : " + OS_NAME);
		}

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
