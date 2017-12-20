package com.p1109.QA.TestCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.p1109.QA.BaseClass.Base_Or_Parent;
import com.p1109.QA.Pages.Sup_EditProfilePage;
import com.p1109.QA.Pages.HomePage;
import com.p1109.QA.Pages.LandingPage;
import com.p1109.QA.Pages.LoginPage;
import com.p1109.QA.Utill.TestUtil;

public class SupEditProfilePageTest extends Base_Or_Parent{
	TestUtil testUtil;
	LoginPage loginPage;
	LandingPage landingPage;
	Sup_EditProfilePage editProfilePage;
	HomePage homePage;
	public SupEditProfilePageTest() 
	{
		super();		
	}	
	@BeforeClass
	public void setup()
	{
		intialization();
		homePage = new HomePage();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		landingPage = new LandingPage();
		editProfilePage = new Sup_EditProfilePage();
	} 	
	
	@Test(priority=1)
	public void linkLoginPage()
	{
		landingPage.linkLoginPage();
	} 
	
	@Test(priority=2)
	public void validLoginTest() throws Exception
	{
		homePage = loginPage.login(prop.getProperty("useremail"), prop.getProperty("password"));
		Thread.sleep(3000);
		homePage.goToMyProfileFromLM(); 
		editProfilePage=homePage.clickOnEditprofile();
	}	
	
	/*@Test(priority=3)
	public void editProfileTest()
	{	
		editProfilePage.EditProfileTest();
	}*/
	@AfterClass
	public void tearDown() throws Exception
	{		Thread.sleep(3000);
			driver.quit();
	}	
}
