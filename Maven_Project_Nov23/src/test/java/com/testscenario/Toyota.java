package com.testscenario;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Toyota extends StaticVariables {
	Locators obj = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@Test
	public void toyota_brochure() throws Exception {
		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);
		
		driver.get("https://www.toyota.co.uk/order-a-brochure");
		
		WebDriverWait exwait = new WebDriverWait(driver, 20);
		 exwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
		 
		 //cfn.clickUsingJavascript(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
		 //driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		 cfn.implicitWait(5);
		 cfn.loopAllFramesAndReturnCountOfElement(By.xpath("//input[@id='input-AX1']")
		  ); cfn.clickByAnyLocator(obj.VEHICLE_CHECKBOX);
		
		
		
	}

	@AfterMethod
	public void takeScreenshot() throws IOException {
	//cfn.takeScreenshotWithTimestamp("Toyota_Login");

		
	}

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			cfn.chromeBrowserDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			cfn.edgeBrowserDriver();
		} else {
			System.out.println("Select browser either chrome or edge");
		}
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
