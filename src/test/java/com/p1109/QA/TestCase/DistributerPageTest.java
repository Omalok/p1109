package com.p1109.QA.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.p1109.QA.BaseClass.Base_Or_Parent;
import com.p1109.QA.Pages.DistributerPage;
import com.p1109.QA.Pages.LandingPage;
import com.p1109.QA.Pages.LoginPage;
import com.p1109.QA.Pages.RegisterPage;


public class DistributerPageTest extends Base_Or_Parent{

	DistributerPage distributerPage;
	RegisterPage RegisterPage;
	LandingPage landingPage;
	LoginPage loginPage;
	
	public DistributerPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		intialization();		
		loginPage = new LoginPage();
		distributerPage = new DistributerPage();
		RegisterPage = new RegisterPage();
		landingPage = new LandingPage();
		landingPage.linkRegisterPage();
		distributerPage=RegisterPage.validRegistration("dabbu", "rawat", "dabbu12345678901141255@gmail.com", "123456", "123456");
	}

	@Test
	public void validDistributerInformationTest() throws Exception
	{
		Thread.sleep(3000);
		Assert.assertTrue(distributerPage.verifyDistributerPageLabel());
		distributerPage.Select_gender();
		distributerPage.type_company_name("Panacea");
		jse.executeScript("window.scrollBy(0,200)", ""); //Scroll
		distributerPage.Select_country();
		distributerPage.type_contact_number("8449611733");
		distributerPage.typeFacebookLink("http:// www.facebook.com");
		distributerPage.select_payment_method();
		distributerPage.type_about_me("Hi, this is alok, currently working in panacea");
		distributerPage.clickOnSaveChangesBtn();
		
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}

//Test Cases should be separated -- independent to each other.
// before each test case -- launch the browser & login 
//@Test -- execute test cases
//after each test case close the browser.

/**	@Test(priority=1)
public void validDistributerPageTitleTest()
{			
	TestUtil.switchToFrame();  // use when text is available inside the frame. !!
	Assert.assertTrue(distributerPage.verifyDistributerPageLabel());		
}*/

//Note:- Here we are using one method only because same email will not work second time.