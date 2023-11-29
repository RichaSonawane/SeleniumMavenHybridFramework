package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonFunctions extends StaticVariables{
	
	// Element is displayed
	// element is enabled?
	// clear
	// sendkeys
	// driver.findElement(locator).sendkeys(input data);

	public void sendKeysByAnyLocator(By locator, String inputData) {
		WebElement element = driver.findElement(locator);
		// element is displayed?
		if (element.isDisplayed()) {
			// element is enabled?
			if (element.isEnabled()) {
				element.clear();
				element.sendKeys(inputData);
			} else {
				System.out.println("element is in disabled state, please check locator");
			}
		} else {
			System.out.println("element is in disabled state, please check locator");
		}

	}
	
	//for click functionality
	public void clickByAnyLocator(By locator) {
		WebElement element = driver.findElement(locator);
		// element is displayed?
		if (element.isDisplayed()) {
			// element is enabled?
			if (element.isEnabled()) {
				
				element.click();
			} else {
				System.out.println("element is in disabled state, please check locator");
			}
		} else {
			System.out.println("element is in disabled state, please check locator");
		}

	}
	
}
