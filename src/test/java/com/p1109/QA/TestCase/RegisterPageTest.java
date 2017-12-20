package com.p1109.QA.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.p1109.QA.BaseClass.Base_Or_Parent;
import com.p1109.QA.Pages.DistributerRegPage;
import com.p1109.QA.Pages.LandingPage;
import com.p1109.QA.Pages.RegisterPage;

public class RegisterPageTest extends Base_Or_Parent
{
	LandingPage landingPage;
	RegisterPage registerPage;
	DistributerRegPage distributerPage;
	
	public RegisterPageTest()
	{
		super();
	}

	@BeforeClass
	public void setUp()
	{
		intialization();
		landingPage = new LandingPage();
		registerPage = new RegisterPage();
	}

	@Test(priority=1)
	public void goToRegisterPage()
	{		
		landingPage.linkRegisterPage();
	}
	
	@Test(priority=2)
	public void ValidateRegisterPageTitle()
	{
		String regPageTitle = registerPage.getRegisterPageTitle();
		Assert.assertEquals(regPageTitle, "Distributor Signup");
		jse.executeScript("window.scrollBy(0,250)", "");
	}
	@Test(priority=3)
	public void clickRegistaerButton() throws Exception
	{
		Thread.sleep(3000);
		registerPage.clickOnRegisterBtn();
	}

	@Test(priority=4)
	
	public void validRegistrationTest()
	{		
		distributerPage = registerPage.validRegistration("alok", "rawat", "alok1234@gmail.com", "123456", "123456");
	}

	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}











}
