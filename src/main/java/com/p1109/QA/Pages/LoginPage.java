package com.p1109.QA.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.p1109.QA.BaseClass.Base_Or_Parent;

public class LoginPage extends Base_Or_Parent{

	//Page Factory 
	
	@FindBy(name="email")	// @CacheLookup	
	WebElement useremail;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@name='remember']")
	WebElement remeberme;
		
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[contains(text(),' Forgot Password')]")
	WebElement forgotpassword;
	
	/**When you want to check SiteLOGO
	 * 
	 * @FindBy(xpath="//a[contains(text(),' Forgot Password')]")
	WebElement p1109Logo;*/
	
	
	public LoginPage() // use to initializing the current page objects.
	{
		PageFactory.initElements(driver, this);   //Select:- driver, pageClassToProxy
	}
	 
	//Actions 
	
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String typeeml,String typepwd )
	{
		useremail.sendKeys(typeeml);
		password.sendKeys(typepwd);
		remeberme.click();
		loginbutton.submit();	
		return new HomePage();
	}
	
	
	
	/**
	 * public boolean ValidateLoginPageLogo()
	{
		return p1109Logo.isDisplayed();
	}*/
}
