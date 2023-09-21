package com.Selenium.pageobjects;

import java.util.UUID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;import org.testng.Assert;
import org.testng.annotations.Test;

import com.Selenium.actiondrivers.ActionsAll;
import com.Selenium.base.Basecl;
import com.Selenium.utility.FakeData;
import com.Selenium.utility.TestUtil;
import com.github.javafaker.Faker;

public class AmazonSigninPage extends Basecl {

	
	
	@FindBy(xpath="//*[@id='continue']")
	public WebElement continue1;
	
	@FindBy(xpath="//*[@id='nav-link-accountList-nav-line-1']")
	WebElement Signin;
	
	@FindBy(xpath="//*[@id='createAccountSubmit']")
	WebElement createaccount;
	
	@FindBy(xpath="//*[@id='ap_customer_name']")
	WebElement usernametext;
	
	@FindBy(xpath="//*[@id='ap_phone_number']")
	WebElement numbertextbox;
	
	@FindBy(xpath="//*[@id='ap_email']")
	WebElement emailtextbox;
	
	@FindBy(xpath="//*[@id='ap_password']")
	WebElement passwordtextbox;
	
	
	
	
	
	public AmazonSigninPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickonSignin()
	{
		Signin.click();
	}
	
	public void createyouraccount(String username, String phone,String email, String password)
	{
		createaccount.click();
		usernametext.sendKeys(username);
		numbertextbox.sendKeys(phone);
		emailtextbox.sendKeys(email);
		passwordtextbox.sendKeys(password);
		
		
		
	}
	
	
	
	
	
	
	

}
