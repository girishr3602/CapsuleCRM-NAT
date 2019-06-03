package com.capsulecrm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.capsulecrm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static int PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICIT_WAIT = 30;
	public static int EXPLICIT_WAIT = 10;
	
	//public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + "/src/main/java/com/capsulecrm/qa/testData/CapsuleCRM-NAT_addPerson_testData.xlsx";
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + "/src/main/java/com/capsulecrm/qa/testData/addPerson_testData.xlsx";
	
	FileInputStream fis;
	static XSSFWorkbook workbook;
	static XSSFSheet xssfsheet;
	
	static Workbook book;
	static Sheet sheet;
	
	static WebDriverWait wait;
	
	public static void verifyPageTitle(String pagetitle) {
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains(pagetitle));
		
	}
	
	public static void verifyThroughURL() {
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("login"));
		
	}
	
	
	public static void explicitWait(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void clickWebElement(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, EXPLICIT_WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		/*
		 *Group to comment 
		 * System.out.println(sheet.getLastRowNum() + "--------" +
		 * sheet.getRow(0).getLastCellNum()); System.out.println(sheet.getLastRowNum());
		 * System.out.println(sheet.getRow(0).getLastCellNum());
		 * System.out.println(sheet.getPhysicalNumberOfRows());
		 */
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				//System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
		
}
