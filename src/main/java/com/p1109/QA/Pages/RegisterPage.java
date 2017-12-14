package com.p1109.QA.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.p1109.QA.BaseClass.Base_Or_Parent;

public class RegisterPage extends Base_Or_Parent{

	@FindBy(name="first_name")
	WebElement  firstname;
	
	@FindBy(name="last_name")
	WebElement  lastname;
	
	@FindBy(name="email")
	WebElement  useremail;
	
	@FindBy(name="password")
	WebElement  password;
	
	@FindBy(name="password_confirmation")
	WebElement  confirmpassword;
	
	/*@FindBy(xpath="//button[@type='submit']")
	WebElement  registerbtn;*/
	
	@FindBy(xpath="//button[contains(text(),'Register')]")
	WebElement Registerbtn;
	
	
	
	public RegisterPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String getRegisterPageTitle()
	{
		return driver.getTitle();
	}
	
	public void typeFirstName(String firstName)
	{
		firstname.sendKeys(firstName);
	}
	
	public void typeLastName(String lastName)
	{
		lastname.sendKeys(lastName);
	}
	public void typeEmail(String email)
	{
		useremail.sendKeys(email);
	}
	public void typePassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void typeConfirmPassword(String cofmPassword)
	{
		confirmpassword.sendKeys(cofmPassword);
	}

	public void clickOnRegisterBtn()
	{
		Registerbtn.click();
	}

	public DistributerPage validRegistration(String fname,String lname,String uemail, String pwd, String cnpwd)
	{
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		useremail.sendKeys(uemail);
		password.sendKeys(pwd);
		confirmpassword.sendKeys(cnpwd);
		jse.executeScript("window.scrollBy(0,250)", "");  //Scroll
		Registerbtn.click();
		return new DistributerPage();
	}
}
