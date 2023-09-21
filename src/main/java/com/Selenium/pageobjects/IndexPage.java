package com.Selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Selenium.actiondrivers.ActionsAll;
import com.Selenium.base.Basecl;
import com.Selenium.base.Basecl1;

public class IndexPage  extends Basecl{
	
	@FindBy(xpath="//a[@class='login']")
	WebElement Signin;
	
	
	public IndexPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage ClickonSignin()
	{
		ActionsAll.click(driver, Signin);
		return new LoginPage();
	}

}
