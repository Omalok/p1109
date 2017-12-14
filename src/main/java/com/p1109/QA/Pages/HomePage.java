package com.p1109.QA.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.p1109.QA.BaseClass.Base_Or_Parent;

public class HomePage extends Base_Or_Parent{

	// Header features
	@FindBy(xpath="//a[@href='http://182.72.79.154/p1109/logout']")
	WebElement logOut;
		
	@FindBy(xpath="//i[@class='fa fa-bell-o']")
	WebElement notificationIcon;
	
	@FindBy(xpath="//a[@href='http://182.72.79.154/p1109/profile']")
	WebElement myAccounttab;
	
	@FindBy(xpath="//a[@href='http://182.72.79.154/p1109/search-project']")
	WebElement searchProject;
	
	// Middle features 
	@FindBy(xpath="//button[contains(text(), 'Edit Profile')]")
	WebElement editProfile;
	
	@FindBy(xpath="//input[@name='profile_picture']")
	WebElement editProfilePictureIcon;
	
	// Left menu features
	
	@FindBy(xpath="//div[1]/div/div[2]/p")	
	WebElement LMuserVerifyLabel; 
	
	@FindBy(xpath="//a[@class='collapsed' and @href='#collapseAccount']")
	WebElement LMmyAccount;
	
	@FindBy(xpath="//a[@href='http://182.72.79.154/p1109/profile']")
	WebElement LMprofile;
	
	@FindBy(xpath="//a[@href='http://182.72.79.154/p1109/update-profile']")
	WebElement LMEditProfile;
	
	
		
	public HomePage()// initialization.
	{
		PageFactory.initElements(driver, this);
	} 
	
	public boolean userVerification()
	{
		return LMuserVerifyLabel.isDisplayed();
	}
	
	public void goToMyProfileFromLM()
	{
		LMmyAccount.click();		
	}
	
	public EditProfilePage clickOnEditprofile()
	{
		 LMEditProfile.click();	
		 return new EditProfilePage();
		
	}
}
