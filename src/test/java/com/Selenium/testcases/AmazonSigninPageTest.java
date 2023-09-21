package com.Selenium.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Selenium.base.Basecl;
import com.Selenium.pageobjects.AmazonSigninPage;
import com.Selenium.pageobjects.IndexPage;
import com.Selenium.pageobjects.LoginPage;
import com.Selenium.pageobjects.SearchforAmazonItems;
import com.Selenium.utility.DBConnectivity;
import com.Selenium.utility.ExcelData_Provider;
import com.Selenium.utility.FakeData;
import com.Selenium.utility.MoveFiles;
import com.Selenium.utility.TestUtil;
import com.github.javafaker.Faker;





public class AmazonSigninPageTest extends Basecl {
	
	MoveFiles mv;
	AmazonSigninPage ap;
	FakeData faker1 ;
	SearchforAmazonItems search;
	private static final Logger logger = LogManager.getLogger(AmazonSigninPageTest.class);

	
	public AmazonSigninPageTest()
	{
		super();
	}
	
	
	
	@BeforeClass()
	public void setup() {
		initialization();
		mv = new MoveFiles();
		ap= new AmazonSigninPage();
		faker1= new FakeData();
		search = new SearchforAmazonItems();
		

	}

	@Test(priority =1)
	public void ClickonSignTest()
	{
		logger.info("Test case 1");
		logger.warn("This will get executed");
		ap.ClickonSignin();
		String cururl = driver.getCurrentUrl();
		Assert.assertEquals(cururl,prop.getProperty("amazonurl"));
		
	}
	
	@Test(priority =2)
	public void CreateAccountDetailsTest()
	{
		logger.info("Test case 2 will create account detail till otp");
		logger.warn("This will get executed");
		ap.createyouraccount(faker1.username, faker1.phone, faker1.email, faker1.password);
		boolean value = ap.continue1.isDisplayed();
		Assert.assertEquals(value, true);
		
	}
	
	@Test(priority =3)
	public void Searchforamazomitem()
	{
		logger.info("Test case 2 will search item");
		logger.warn("This will get executed");
		search.Searchuritem(prop.getProperty("item"));
		String perfurl = driver.getCurrentUrl();
	    Assert.assertEquals(perfurl,prop.getProperty("urlonperfume"));
	    
	
		
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		
	   driver.quit();
	}
	
	@AfterSuite
	public void movefiles()
	{
		mv.movefilesmethod();
	//move from extent report folder to older reports
		
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			if (ITestResult.FAILURE == result.getStatus()) {
				String fileName = result.getMethod().getMethodName() + ".png";
				TestUtil.getScreenshot(fileName);
				
								
		}
			
		
	}

	

	}
}
