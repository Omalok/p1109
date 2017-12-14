package com.p1109.QA.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.p1109.QA.BaseClass.Base_Or_Parent;

public class DistributerPage extends Base_Or_Parent{

	@FindBy(xpath="html/body/section/div/div/div/div/div[1]/h1")
	WebElement distributerPageLabel;
	
	@FindBy(name="first_name")
	WebElement first_name;
	
	@FindBy(name="last_name")
	WebElement last_name;
	
	@FindBy(xpath=".//*[@id='gender']")
	WebElement gender;
	
	@FindBy(name="company_name")
	WebElement company_name;
	
	@FindBy(xpath="//select[@id='country']")
	WebElement country;
	
	@FindBy(name="contact_number")
	WebElement contact_number;
	
	@FindBy(xpath=".//*[@id='address1']")
	WebElement address;
	
	@FindBy(name="facebook_link")
	WebElement facebook_link;
	
	@FindBy(xpath=".//*[@id='main_user_profile']/div[12]/div/div/div/select")
	WebElement payment_method;
	
	@FindBy(name="about_me")
	WebElement about_me;
	
	@FindBy(xpath="//button[contains(text(), 'Save Changes')]")
	WebElement savechange;
	
	@FindBy(xpath="//a[contains(text(), 'Cancel')]")
	WebElement cancelbtn;
	public DistributerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Action
	
	public boolean verifyDistributerPageLabel()
	{
		return distributerPageLabel.isDisplayed();
	}
	
	public void type_first_name(String firstname)  // firstname
	{
		first_name.sendKeys(firstname);
	}
	
	public void type_last_name(String lastname)   //lastname
	{
		last_name.sendKeys(lastname);
	}
	
	public void Select_gender()                  //gender
	{
		Select dropDown = new Select(gender);
		dropDown.selectByIndex(1);
	}
	
	public void type_company_name(String compname)   //compname
	{
		company_name.sendKeys(compname);
	}
	
	public void Select_country()        //country
	{
		Select dropDown = new Select(country);
		dropDown.selectByValue("195");
	}
	
	public void type_contact_number(String contactnum)   //contactnum
	{
		contact_number.sendKeys(contactnum);
	}
	
	public void typeFacebookLink(String FBlink)  // FbLink
	{
		facebook_link.sendKeys(FBlink);
	}
	
	public void select_payment_method()      // payMethod 
	{
		Select dropDown = new Select(payment_method);
		dropDown.selectByIndex(1);
	}
	
	public void type_about_me(String aboutme)     //aboutme
	{
		about_me.sendKeys(aboutme);
	}
	
	public void clickOnSaveChangesBtn()     // SaveBtn
	{
		savechange.click();
	}
	public void clickOnCancelBtn()     //CancelBtn
	{
		cancelbtn.click();
	}
	
	public LoginPage validDistributionInformation() throws Exception
	{		
		DistributerPage distributerPage = new DistributerPage();
		Thread.sleep(3000);
		distributerPage.Select_gender();
		distributerPage.type_company_name("Panacea");
		jse.executeScript("window.scrollBy(0,200)", ""); //Scroll
		distributerPage.Select_country();
		distributerPage.type_contact_number("8449611733");
		distributerPage.typeFacebookLink("http:// www.facebook.com");
		distributerPage.select_payment_method();
		distributerPage.type_about_me("Hello this is alok experienced in panacea");
		distributerPage.clickOnSaveChangesBtn();
	
		return new LoginPage();
	}
}
