package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.qa.util.Xls_Reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;





//import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	static Xls_Reader reader;
	
		//TestBase constructor
		public TestBase() {
			
			prop = new Properties();
			try {
				FileInputStream propFile = new FileInputStream("src/main/java/com/crm/qa/config/config.properties");
				prop.load(propFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		public static void Initialization(){
			
			String browserName = prop.getProperty("browser");
			
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if (browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));		
			
			//move to the TC level
			WebElement mainLoginBtn = driver.findElement(By.cssSelector("a.btn.btn-primary"));
			mainLoginBtn.click();		
		}
		
		
		//Read test data sheet
		public static ArrayList<Object[]> getDataFromExcel() {
			
			ArrayList<Object[]> loginData = new ArrayList<Object[]>();
			
			try {
				reader = new Xls_Reader("src/main/java/com/crm/qa/testdata/TestData.xlsx");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			for(int rowNum = 2; rowNum <= reader.getRowCount("login"); rowNum++) {
				
				String userName = reader.getCellData("login", "username", rowNum);
				String passWord = reader.getCellData("login", "password", rowNum);
				
				Object ob[] = {userName, passWord};
				loginData.add(ob);
			}
			return loginData;
		}
		
		public void extentTest() {
			ExtentReports extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Login Function | Automation Report");
			spark.config().setReportName("Login Function Demo");
			extent.attachReporter(spark);
			
		}

}
