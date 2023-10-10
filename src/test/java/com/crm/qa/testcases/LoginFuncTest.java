package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompanyPage;
import com.crm.qa.pages.LoginPage;



public class LoginFuncTest extends TestBase {
	
	LoginPage loginPage;
	CompanyPage companyPage;
	
	
	
	public LoginFuncTest() {
		super();		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestBase.getDataFromExcel();
		return testData.iterator();
	}
	
	@BeforeMethod
	public void setUp(){
		Initialization();
		loginPage = new LoginPage();
	}
	
	
	
	@Test(priority=1, dataProvider="getTestData")
	public void verifyLogin(String userName, String passWord){		
		//Log-in with valid credentials
		companyPage=loginPage.login(userName, passWord);
				
		System.out.println("Logged in to CRM company page");
		
		//Log-in with invalid credentials
		if(companyPage.validateInvalidLogin()==1){
			System.out.println("Validated Invalid login");
			
		}else{
			//Validate company page
			String usernameLabel = companyPage.validateUserNameLabel();
			Assert.assertEquals(usernameLabel, "Anuradha Sampath");
			System.out.println("Validated Logged in user as "+usernameLabel);
		}
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
