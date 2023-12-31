package com.Selenium.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager implements ITestListener {
	
	//extends TestngListener
	
	public ExtentSparkReporter  htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	 
	 String repname;
	 
	  
	 public void onStart(ITestContext testContext)
	 {
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		 repname= "Test Report"+timeStamp+".html";
		 htmlReporter=new ExtentSparkReporter(".\\Extentreports\\"+repname);

	  
	  extent=new ExtentReports();
	  
	  extent.attachReporter(htmlReporter);

	  
	  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
	  htmlReporter.config().setReportName("Functional Testing"); // name of the report
	 // htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
	  htmlReporter.config().setTheme(Theme.STANDARD);
	 }
	 
	 public void onTestSuccess(ITestResult tr)
	 {
	  logger=extent.createTest(tr.getName()); // create new entry in th report
	  logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	 }
	 
	 public void onTestFailure(ITestResult tr)
	 {
	  logger=extent.createTest(tr.getName()); // create new entry in th report
	  logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
	  
	  String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	  logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath)); 
	 }
	 
	 public void onTestSkipped(ITestResult tr)
	 {
	  logger=extent.createTest(tr.getName()); // create new entry in th report
	  logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	 }
	 
	 public void onFinish(ITestContext testContext)
	 {
	  extent.flush();
	 }
	 
	 }


