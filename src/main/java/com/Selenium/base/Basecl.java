package com.Selenium.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basecl {
	
	public static WebDriver driver;
	public static Properties prop;
	
	private final String filepath ="Configuration//Config.properties";
	
	
	public Basecl()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream(filepath);
			prop.load(ip);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{    
//		ChromeOptions options = new ChromeOptions();
//	    options.addArguments("--remote-allow-origins=*");
//	    //WebDriver driver = new ChromeDriver(options);
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			//driver= new ChromeDriver(options);
		
		}
			
		if(browsername.equals("FF"))
		{
			
			driver= new FirefoxDriver();
		}
		
		if(browsername.equals("IE"))
		{
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}

}
