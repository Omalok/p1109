package com.p1109.QA.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.p1109.QA.BaseClass.Base_Or_Parent;
import com.p1109.QA.Pages.HomePage;
import com.p1109.QA.Pages.LandingPage;
import com.p1109.QA.Pages.LoginPage;
public class landingPageTest extends Base_Or_Parent{	
	public static LandingPage landingPage;
	public static LoginPage loginPage;
	public static HomePage homePage;
	public landingPageTest()	
	{
		super();
	}	
	@BeforeClass
	public void setup()
	{
		intialization();
		loginPage = new LoginPage();	
		landingPage = new LandingPage();		
	} 
	@Test(priority=1)
	public void validateLandingPageTitle()
	{
		String LandingPageTitle = landingPage.getLandingPageTitle();
		Assert.assertEquals(LandingPageTitle, "Logged In User Page");		
	}
	
	@Test(priority=2)
	public void goToLogin()
	{
		loginPage =landingPage.linkLoginPage();
	}
	@Test(priority=3)
	public void validLogin()
	{
		homePage=loginPage.login(prop.getProperty("useremail"), prop.getProperty("password"));
	}
	@AfterClass
	public void tearDown() throws Exception
	{		Thread.sleep(3000);
		driver.quit();
	}	
}
