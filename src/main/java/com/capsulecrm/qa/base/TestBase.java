package com.capsulecrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.capsulecrm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/capsulecrm/qa/config/config.properties");
			
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		
		String OS_NAME = System.getProperty("os.name").toLowerCase();
		System.out.println(OS_NAME);
		
		if(OS_NAME.contains("windows")) {
			switch(prop.getProperty("browser")){
			case "chrome":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/com/capsulecrm/qa/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
				
			case "firefox":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/com/capsulecrm/qa/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
				
			case "opera":
				System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")+"/src/main/java/com/capsulecrm/qa/drivers/operadriver.exe");
				driver = new OperaDriver();
				break;
				
			}
			
		}else if(OS_NAME.contains("mac")) {
			switch(prop.getProperty("browser")){
			case "chrome":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/com/capsulecrm/qa/drivers/chromedriver");
				driver = new ChromeDriver();
				break;
				
			case "firefox":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/com/capsulecrm/qa/drivers/geckodriver");
				driver = new FirefoxDriver();
				break;
				
			case "opera":
				System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")+"/src/main/java/com/capsulecrm/qa/drivers/operadriver");
				driver = new OperaDriver();
				break;
				
			}
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("loginurl"));
	}

}
