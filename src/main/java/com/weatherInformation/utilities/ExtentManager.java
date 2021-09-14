package com.weatherInformation.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance(String fileName) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setEncoding("utf-8");

		// This is the Title of the Report in web Page
		htmlReporter.config().setDocumentTitle("Automation Test Suite Reports");

		htmlReporter.config().setReportName("Automation Test Suite Results");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.setSystemInfo("Developed By", "Rohit Pritam");
		extent.setSystemInfo("Skill", "Test Automation");

		extent.attachReporter(htmlReporter);
		return extent;
	}

}