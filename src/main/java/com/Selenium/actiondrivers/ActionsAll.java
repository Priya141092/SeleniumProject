package com.Selenium.actiondrivers;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Selenium.base.Basecl1;

public class ActionsAll extends Basecl1{
	public static long PAGE_LOAD_TIME = 10;
	public static long IMPLICIT_WAIT= 10;
	
	public static boolean FindElement(WebDriver driver, WebElement ele)
	{
		return false;
		
	}
	
	public static boolean type(WebElement ele, String text)
	{   boolean flag = false;
	   try
	   {
		   flag = ele.isDisplayed();
		   ele.sendKeys(text);
		   flag =true;
	   }
	   catch(Exception e)
	   {
		   System.out.print("Not found");
		   flag = false;
	   }
	   finally
	   {
		   if(flag)
		   {
			   System.out.println("Successfully Enetered");
		   }
		   else
		   {
			   System.out.println("Not found");
		   }
	   }
	
	return flag;
		
	}
	
	
	public static void click(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	

	}
	
	public static void clickonElement(WebDriver driver, WebElement ele) {

		ele.click();
	

	}
	
	static public void selectiondropdown(WebElement t, String s)
	{
		Select st = new Select(t);
		st.selectByValue(s);
	}
	
	
	
	
		 public static void scrollpage(WebElement Element)
		 {
			 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView();", Element);

		 }
		 
		 public static void scrollpagetoclick(WebElement Element)
		 {
			 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			 jsExecutor.executeScript("arguments[0].click();", Element);
		 }
		 
		 public static void Mousehover(WebDriver driver,WebElement ele)
		 {
			 Actions action = new Actions(driver);
			action.moveToElement(ele).click().perform();
			
		 }

	 public static void waitcondition(WebDriver driver,WebElement t2)
	 {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(t2)).click();

	 }
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
	

		
	}


