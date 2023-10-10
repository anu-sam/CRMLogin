package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page factory or Object Repository
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement btnLogin;
	
	//Constructing and initializing login page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions relevant to login page
	
	
	public CompanyPage login(String username, String pwd){
		
		email.sendKeys(username);
		password.sendKeys(pwd);
		btnLogin.click();
		
		
		return new CompanyPage();
	}

}
