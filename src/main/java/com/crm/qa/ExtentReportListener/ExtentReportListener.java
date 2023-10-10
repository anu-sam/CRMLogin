package com.crm.qa.ExtentReportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public abstract class ExtentReportListener{
	
	
	public void extentTest() {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Login Function | Automation Report");
		spark.config().setReportName("Login Function Demo");
		extent.attachReporter(spark);
	}
	
}