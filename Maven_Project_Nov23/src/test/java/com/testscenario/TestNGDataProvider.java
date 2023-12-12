package com.testscenario;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestNGDataProvider extends StaticVariables  {

	CommonFunctions cfn = new CommonFunctions();
	Locators obj = new Locators();

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("Chrome") String browserName) throws Exception {

		if (browserName.equalsIgnoreCase("chrome")) {
			cfn.chromeBrowserDriver();
			driver.get("https://www.facebook.com");
		
		} else if (browserName.equalsIgnoreCase("edge")) {

			cfn.edgeBrowserDriver();
			driver.get("https://www.facebook.com/");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			cfn.edgeBrowserDriver();
			driver.get("https://www.facebook.com/");
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

	@Test(dataProvider = "dp")
	public void f(String userName, String password) throws Exception {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
	
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(6000);
		driver.get("https://www.facebook.com/");
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] 
				{ 
			new Object[] { "test1", "pass1" } ,
			new Object[] { "test2", "pass2" }, 
			};
	}
}
