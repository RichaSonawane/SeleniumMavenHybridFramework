package com.testscenario;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FB_Login extends StaticVariables{
	//WebDriver driver;
	// create object of locator class
	Locators obj = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@Test
	public void Fb_login() throws IOException {
		// create property file variable to call test data from property file
		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		driver.get(prop.getProperty("baseURL"));
		//driver.findElement(obj.USERNAME_EDITBOX).sendKeys(prop.getProperty("Username"));
		cfn.sendKeysByAnyLocator(obj.USERNAME_EDITBOX, prop.getProperty("Username"));
		//driver.findElement(obj.PASSWORD_EDITBOX).sendKeys(prop.getProperty("Password"));
		cfn.sendKeysByAnyLocator(obj.PASSWORD_EDITBOX, prop.getProperty("Password"));
		//driver.findElement(obj.LOGIN_BUTTON).click();
		cfn.clickByAnyLocator(obj.LOGIN_BUTTON);

	}

	@Test
	public void google_login() throws IOException {
		// for every test we need to call testdata from properties file
		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		driver.get("https://www.google.com/");
		//driver.findElement(obj.SEARCH_EDITBOX).sendKeys(prop.getProperty("SearchText"));
		cfn.sendKeysByAnyLocator(obj.SEARCH_EDITBOX, prop.getProperty("SearchText"));
		//driver.findElement(obj.SEARCH_BUTTON).click();
		cfn.clickByAnyLocator(obj.SEARCH_BUTTON);

	}
	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("Chrome") String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("select browser correctly");
		}

		// If needed exact version then do
		// WebDriverManager.chromedriver().browserVersion("84").setup();

		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@AfterMethod
	public void takeScreenshot() throws IOException {
		// date time in customised format
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("ddMMyyyy_HHmmss");
		String timeStamp = df.format(d);
		System.out.println(timeStamp);

		// Take screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// FileHandler.copy(srcFile, new File(".\\Screenshots\\FB"+timeStamp+".PNG"));
		FileHandler.copy(srcFile, new File(".\\Screenshots\\FB" + timeStamp + ".PNG"));

	}

}
