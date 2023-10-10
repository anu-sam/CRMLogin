package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//div[@class='header item']")
	WebElement headerLogo;
	
	/*@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;*/
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public String validateUserNameLabel() {
		return userNameLabel.getText();
	}
	
	public boolean validateHeaderLogo() {
		return headerLogo.isDisplayed();
	}
	
}
