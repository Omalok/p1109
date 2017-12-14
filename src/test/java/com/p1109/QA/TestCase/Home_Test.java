package com.p1109.QA.TestCase;


import javax.swing.plaf.FileChooserUI;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.p1109.QA.BaseClass.Base_Or_Parent;
import com.p1109.QA.Pages.HomePage;
import com.p1109.QA.Pages.LandingPage;
import com.p1109.QA.Pages.LoginPage;
import com.p1109.QA.Utill.TestUtil;

public class Home_Test extends Base_Or_Parent{

	HomePage homePage;
	TestUtil testUtil;
	LoginPage loginPage;
	LandingPage landingPage;

	public Home_Test(){
		super();
	}


	@BeforeClass
	public void setup()
	{
		intialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		landingPage = new LandingPage();
		homePage = new HomePage();
		

	} 	 
	@Test(priority=1)
	public void linkLoginPage()
	{
		landingPage.linkLoginPage();
	}

	@Test(priority=2)
	public void goToLMEditProfile() throws InterruptedException
	{
		homePage = loginPage.login(prop.getProperty("useremail"), prop.getProperty("password"));
		Thread.sleep(3000);
		homePage.goToMyProfileFromLM(); 


	}

	@AfterClass
	public void tearDown() throws Exception
	{		Thread.sleep(3000);
	driver.quit();
	}	











}
