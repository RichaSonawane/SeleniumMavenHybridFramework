package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions extends StaticVariables {

	// constructor
	public CommonFunctions() {
		File screenshotPath = new File(".\\Screenshots");
		if (screenshotPath.exists()) {
			System.out.println("Screenshot folder already exists");
		} else {
			screenshotPath.mkdir();
			System.out.println("Screenshot folder is not available, syatem has created a folder");
		}
	}

	// Element is displayed
	// element is enabled?
	// clear
	// sendkeys
	// driver.findElement(locator).sendkeys(input data);
//************************For sendkeys
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

	// ***************************for click functionality
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
			System.out.println("element is not displayed, please check locator");
		}

	}

	// *************************for timestamp
	public String timestamp() {
		// date and time in customised format
		Date sd = new Date();
		SimpleDateFormat cdf = new SimpleDateFormat("MMddyyyy_HHmmss");
		String timestamp = cdf.format(sd);
		return timestamp;

	}

	// ******************for taking screenshots
	// take screenshot of page
	public void takeScreenshotWithTimestamp(String name) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File(".\\Screenshots\\ " + name + timestamp() + ".PNG"));
		System.out.println("Screenshot taken successfully");

	}

	// *********************browser drivers
	public void chromeBrowserDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public void edgeBrowserDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	public void firefoxBrowserDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	public void operaBrowserDriver() {
		WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
	}

	//*************Implicit wait
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	//****************Explicit wait
	/*
	 * public void explicitWait(By locator) { WebDriverWait exwait = new
	 * WebDriverWait(driver, 20); exwait.until(ExpectedConditions.visibilityOf(
	 * locator)); }
	 */
	//********************* Scroll down/up *******************/
	public void scrollToElement(WebElement element) {
		System.out.println("***ScrollToElement: ***");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6px groove green'", element);
	}

	public void scrollToElementBottom(WebElement element) {
		System.out.println("***ScrollToElementBottom:  ***");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
		System.out.println("***ScrollToElementBottom executed; going to hilight el  ***");
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6px groove green'", element);
		System.out.println("***ScrollToElementBottom executed; hilight el  executed***");
	}
	//*************frames handling
	//*************iframe count
	public int IframeCount() {
		driver.switchTo().defaultContent();
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		int numberOfFrames=0;
		numberOfFrames=Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on page is : "+ numberOfFrames);
		return numberOfFrames;
	}
	//*********************switching to particular frame
	public void switchToFrameByInt(int i) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(i);
	}
	//******************returns framenumber where element is present
	public int loopAllFramesAndReturnCountOfElement(By locator) {
		System.out.println("Inside method for getting frame number where element is present");
		
		int elementPresenceFrameCount = 0;
		int loop = 0;
		int maxFrameCount = IframeCount();
		//if given locator is present on webpage then element size would be 1, else 0
		elementPresenceFrameCount = driver.findElements(locator).size();
		
		while(elementPresenceFrameCount == 0 && loop < maxFrameCount) {
			try {
				switchToFrameByInt(loop);
				elementPresenceFrameCount =driver.findElements(locator).size();
				System.out.println("try loopAllFramesAndReturnWebEL : "+loop+"; elementPresenceFrameCount : "+elementPresenceFrameCount);
				if(elementPresenceFrameCount >0 ||loop >maxFrameCount) {
					break;
				}
			}catch(Exception ex) {
				System.out.println("Catch loopAllFramesAndReturnWebEL old: "+loop +"; "+ ex);
			}
			loop++;
			}
		return elementPresenceFrameCount;
		}
	
}
