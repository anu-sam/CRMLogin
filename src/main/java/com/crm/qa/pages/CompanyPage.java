package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CompanyPage extends TestBase{
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//div[@class='header item']")
	WebElement headerLogo;
//	
//	@FindBy(xpath="//p[text()='Invalid login']")
//	WebElement lblInvalidLogin;
//	
	List <WebElement> lblInvalidLogin = driver.findElements(By.xpath("//p[text()='Invalid login']"));
	
	
	/*@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;*/
	
	
	
	public CompanyPage() {
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
	
	public Integer validateInvalidLogin() {
		return lblInvalidLogin.size();
	}
	
}
