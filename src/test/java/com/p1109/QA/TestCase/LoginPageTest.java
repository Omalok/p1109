package com.p1109.QA.TestCase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.p1109.QA.BaseClass.Base_Or_Parent;
import com.p1109.QA.Pages.HomePage;
import com.p1109.QA.Pages.LandingPage;
import com.p1109.QA.Pages.LoginPage;
import com.p1109.QA.Utill.TestUtil;

public class LoginPageTest extends Base_Or_Parent{
	LoginPage loginPage;
	LandingPage landingPage;	
	HomePage homePage;
	TestUtil testUtil;

	String sheetName = "UserCredential";
	public LoginPageTest() 
	{
		super();		
	}	
	@BeforeClass
	public void setup()
	{
		intialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		landingPage = new LandingPage();
	} 	 
	@Test(priority=1)
	public void linkLoginPage()
	{
		landingPage.linkLoginPage();
		testUtil.captureScreenShort();
	} 

	@Test(priority=2)		//(priority=1)
	public void loginPageTitleTest()
	{		String title=loginPage.ValidateLoginPageTitle();
	Assert.assertEquals(title, "User Login");   // Assert.assertEquals(arg0, arg1);
	}	

	@DataProvider
	public Object[][] getP1109TestData()
	{
		Object data[][] =TestUtil.getTestData(sheetName);		
		return data;
	}	
	//@Test(priority=3, dataProvider="getP1109TestData")
	
	@Test(priority=3)
	public void validLoginTest() throws Exception
	{
		homePage = loginPage.login(prop.getProperty("useremail"), prop.getProperty("password"));
		Thread.sleep(3000);
		
	}		
	@AfterClass
	public void tearDown() throws Exception
	{		Thread.sleep(3000);
	driver.quit();
	}	
}
