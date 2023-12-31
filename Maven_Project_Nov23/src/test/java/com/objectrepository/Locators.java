package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {

	//public  final By ELEMENTNAME_ELEMENTTYPE = By.id("attribute");
	
	//locators for fb
	public final By USERNAME_EDITBOX = By.id("email");
	public final By PASSWORD_EDITBOX = By.name("pass");
	public final By LOGIN_BUTTON = By.name("login");
	
	//locator for google
	public final By SEARCH_EDITBOX = By.name("q");
	public final By SEARCH_BUTTON = By.name("btnK");
	
	//locators for oneok
	public final By MODAL_BUTTON = By.xpath( "//span[contains(text(),'×')]");
	public final By SUSTAINABILITY_BUTTON = By.xpath("//a[contains(text(),'Sustainability')]");
	public final By READ_BUTTON =By.xpath("//button[starts-with(@id,'kt-accordion-header')]");
	
	//locators for mis
	//a[@name='P-24Alist']
	public final By Zonal_Link = By.xpath("//a[@name='P-2Alist']");
	
	//toyota
	public final By VEHICLE_CHECKBOX = By.xpath("//input[@id='input-AX1']");
}
