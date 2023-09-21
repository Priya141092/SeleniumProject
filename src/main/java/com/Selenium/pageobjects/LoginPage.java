package com.Selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Selenium.base.Basecl;

public class LoginPage extends Basecl {
	
	@FindBy(xpath="//*[@id='email']")
	public static WebElement email;
	

	@FindBy(xpath="//*[@id='passwd']")
	public static WebElement password;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement signinbutton;
	
	
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String geturl()
	{
		String loginurl = driver.getCurrentUrl();
		return loginurl;
		
	}
	
	public void enterLoginDetails(String username, String passwrd)
	{
		email.sendKeys(username);
		password.sendKeys(passwrd);
		
	}
	
	public void clickonSubmit()
	{
		signinbutton.click();
	}
	
	
}
