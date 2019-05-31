package com.capsulecrm.qa.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.capsulecrm.qa.base.TestBase;

public class TestRun extends TestBase {
	
	Logger log = Logger.getLogger(TestRun.class);

	public TestRun() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("Driver initialized");
	}
	
	@Test
	public void testRun() {
		String OS_NAME = System.getProperty("os.name");
		log.info("Get the OS");
		
		System.out.println(OS_NAME);
		if(OS_NAME.contains("Windows")) {
			System.out.println("Opearating System is : " + OS_NAME);
			log.info("OS is Windows");
		}else if(OS_NAME.contains("Linux")) {
			System.out.println("Opearating System is : " + OS_NAME);
			log.info("OS is Linux");
		}

	}
	
	@Test
	public void robotClass() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Close driver");
	}
}
