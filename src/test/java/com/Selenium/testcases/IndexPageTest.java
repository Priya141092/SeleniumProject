//package com.Selenium.testcases;
//
//import java.io.IOException;
//
//import org.openqa.selenium.support.Color;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.Selenium.base.Basecl;
//import com.Selenium.pageobjects.IndexPage;
//import com.Selenium.pageobjects.LoginPage;
//import com.Selenium.utility.DBConnectivity;
//import com.Selenium.utility.ExcelData_Provider;
//import com.Selenium.utility.MoveFiles;
//
//
//
//
//
//
//public class IndexPageTest extends Basecl{
//	
//	IndexPage ip;
//	LoginPage loginpage;
//	MoveFiles mv;
//	DBConnectivity db;
//	//private final static
//	static String excelpath  = ".//TestData//UserDataFile.xlsx";
//	static String sheetname="UserDataFile";
//	
//	
//	public IndexPageTest()
//	{
//		super();
//	}
//	
////	@BeforeTest
////	public void MovingFiles()
////	{
////		mv.movefilesmethod();
////	}
//	
//	@BeforeClass()
//	public void setup() {
//		initialization();
//		ip = new IndexPage();
//		loginpage = new LoginPage();
//		mv = new MoveFiles();
//		db = new DBConnectivity();
//		mv.movefilesmethod();
//
//	}
//	@DataProvider(name= "createloginusers")
//	public static Object[][]  createuser() throws IOException
//	{
//
//		Object data [][] =ExcelData_Provider.exceldata(excelpath, sheetname);
//		return data;
//	}
//
//	@Test(priority =1)
//	public void ClickonSignTest()
//	{
//		
//		ip.ClickonSignin();
//		Assert.assertEquals(loginpage.geturl(),prop.getProperty("loginurl"));
//		
//	}
//	
//	@Test(dataProvider= "createloginusers", priority =2)
//	public void enterLoginDetailsTest(String username, String passwrd) throws Exception
//	{
//		loginpage.enterLoginDetails(username, passwrd);
//		String passwordcolor = loginpage.email.getCssValue("background-color");
//		String hexcolor = Color.fromString(passwordcolor).asHex();
//		System.out.println(passwordcolor);
//		Assert.assertEquals(hexcolor,prop.getProperty("colorcss"));	
//	}
//	
//	
//	@AfterTest
//	public void tearDown()
//	{
//		driver.quit();
//	}
//
//	}
//
