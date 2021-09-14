package com.weatherInformation.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.weatherInformation.utilities.ExtentManager;
import configuration.SetUp;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class Test_Listener extends SetUp implements ITestListener {

	static int count_passedTCs;
	static int count_skippedTCs;
	static int count_failedTCs;
	static int count_totalTCs;

	static Date d = new Date();
	static String fileName = "Automation_Report_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	private static ExtentReports extent = ExtentManager.createInstance("extent_reports/\\" + fileName);

	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public void onTestStart(ITestResult result) {
		System.out.println("Thread.currentThread().getId(): " + Thread.currentThread().getId());
		String testCaseName = result.getMethod().getMethodName();

		count_totalTCs = count_totalTCs + 1;

		ExtentTest test = extent.createTest(testCaseName);
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		count_passedTCs = count_passedTCs + 1;
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " is Passed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);
	}

	public void onTestFailure(ITestResult result) {
		count_failedTCs = count_failedTCs + 1;
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get()
				.fail("<details><summary><b><font color=red> Exception occured, click to see details: </font></b>"
						+ "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
		try {
			extentTest.get().fail("<b><font color=red>" + "Screenshot of Failure" + "</font></b>",
					// MediaEntityBuilder.createScreenCaptureFromPath(path).build());
					MediaEntityBuilder.createScreenCaptureFromBase64String(
							((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64)).build());
		} catch (IOException e) {
			extentTest.get().fail("Test failed, can not attach Screenshot");
		}

		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " is Failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);

	}

	public void onTestSkipped(ITestResult result) {
		count_skippedTCs = count_skippedTCs + 1;
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " is Skipped</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		// extentTest.get() - Becasue, we are accessing it from ThreadLocal
		extentTest.get().log(Status.SKIP, m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext result) {

	}

	public void onFinish(ITestContext result) {

		if (extent != null) {
			extent.flush();
		}
	}

	public void onStart(ISuite suite) {

	}

}