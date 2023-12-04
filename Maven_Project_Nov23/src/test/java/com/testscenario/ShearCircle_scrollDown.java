package com.testscenario;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class ShearCircle_scrollDown extends StaticVariables {
	// WebDriver driver;
	// create object of locator class
	Locators obj = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@Test
	public void Oneok_login() throws IOException {
		// create property file variable to call test data from property file
		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		// oneok url
		driver.get(prop.getProperty("OneokUrl"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		cfn.clickByAnyLocator(obj.MODAL_BUTTON);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cfn.clickByAnyLocator(obj.SUSTAINABILITY_BUTTON);

		
		 WebElement element = driver.findElement(obj.READ_BUTTON);
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		  cfn.clickByAnyLocator(obj.READ_BUTTON);
		  
		 
	}

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("Chrome") String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			cfn.chromeBrowserDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {

			cfn.edgeBrowserDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			cfn.edgeBrowserDriver();
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
		cfn.takeScreenshotWithTimestamp("Oneok_Login");

	}

}
