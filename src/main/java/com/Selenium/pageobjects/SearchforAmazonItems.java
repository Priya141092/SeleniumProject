package com.Selenium.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Selenium.base.Basecl;
import com.Selenium.utility.TestUtil;

public class SearchforAmazonItems  extends Basecl{
	
	
	@FindBy(xpath="//*[@id='twotabsearchtextbox']")
	WebElement searchbox;
	
	@FindBy(xpath="//*[@id='glow-ingress-line1']")
	WebElement helloline;
	
	@FindBy(xpath="//*[@id='nav-search-submit-button']")
	WebElement serachglass;
	
	
	
	@FindBy(xpath="//*[@class='a-color-state a-text-bold']")
	public WebElement Perfumepresent;
	
	
	
	public SearchforAmazonItems()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Searchuritem(String item)
	{
		
		driver.navigate().to(prop.getProperty("url"));
	    TestUtil.waitcondition(helloline);
		searchbox.sendKeys(item);
		
		
	}
	
	

}
