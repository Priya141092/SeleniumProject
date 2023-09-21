package com.Selenium.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.IllegalFormatException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Selenium.base.Basecl;
import com.github.javafaker.Faker;
import com.google.common.io.Files;
import java.nio.file.*;



public class TestUtil extends Basecl {
	
	static Faker faker = new Faker();
	 
//       public static void changenewReportDirectory() throws IOException
//       {
//    	   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
//    	   Date date = new Date();
//    	   String dateTime = dateFormat.format(date);
//    	   
//    	   //File currentFolder = new File("Current test results/" + dateTime);
//    	   File currentFolder = new File("Current test results/" +dateTime);
//    	   currentFolder.mkdirs();
//
//
//    	   File reports = new File("index.html");
//    	   FileUtils.moveFileToDirectory(reports, currentFolder, true);
//
// 	  
//       }
	
	public static void getScreenshot(String filename) throws IOException
    {

 	   TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);

			try {
				//FileUtils.copyFile(srcFile, new File("./Screenshots/" ));
				FileUtils.copyFile(srcFile, new File("./Screenshots/" + filename));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
       public static void movefromreportstocurrentresultsfolder() throws IOException
       {
    	   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    	   Date date = new Date();
    	   String dateTime = dateFormat.format(date);
    	   
    	   //File currentFolder = new File("Current test results/" + dateTime);
    	   File currentFolder = new File("Current test results/" +dateTime);
    	   currentFolder.mkdirs();
    	   

    	  File path = new File("./ExtentReports/index.html");
    	 // Files.move(path, currentFolder);
    	  FileUtils.moveFileToDirectory(path, currentFolder, true);

 	  
       }
       
       public static void waitcondition(WebElement t2)
  	 {
  		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
  		wait.until(ExpectedConditions.visibilityOf(t2)).click();
  		// wait.until(ExpectedConditions.elementToBeClickable(t2)).click();

  	 }
       
       
       
  public static void changetoarchiveddiretory() throws IOException
  {
	  
	  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	  Date date = new Date();
	  String dateTime = dateFormat.format(date);
	  File archivedFolder = new File("Archived test results/" +dateTime);
	
	  archivedFolder.mkdirs();
	 // String sourcepath = "./Current test results";
	 //File path = new File("./Current test results");
	 // FileUtils.moveFileToDirectory(path, archivedFolder,true);

	  File[] files = new File("Current test results/" ).listFiles();
	  for (File file : files) {
	      if (file.isFile()) {
	          FileUtils.moveFileToDirectory(file, archivedFolder, true);
	    	 
	      }
	  }

	  FileUtils.cleanDirectory(new File("Current test results/"));
  }
  
  public static void generatefullname()
  {
	  String firstName = faker.name().firstName();
	 
  }
  

  
		 	 

}

