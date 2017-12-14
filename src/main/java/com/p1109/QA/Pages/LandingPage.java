package com.p1109.QA.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.p1109.QA.BaseClass.Base_Or_Parent;

public class LandingPage extends Base_Or_Parent{

	@FindBy(xpath="//a[@href='http://182.72.79.154/p1109/login']")
	WebElement Login;

	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement Register;
	//Object Initialization.
	public LandingPage()
	{
	PageFactory.initElements(driver, this);
	} 	
	//Actions
	public String getLandingPageTitle()
	{
		return driver.getTitle();
	}
	
	public LoginPage linkLoginPage()
	{
		Login.click();
		return new LoginPage();
	}
	
	public RegisterPage linkRegisterPage()
	{
		Register.click();
		return new RegisterPage();
	}
	
}