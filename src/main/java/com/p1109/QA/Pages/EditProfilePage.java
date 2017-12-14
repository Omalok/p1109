package com.p1109.QA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.p1109.QA.BaseClass.Base_Or_Parent;

public class EditProfilePage extends Base_Or_Parent{
	
	@FindBy(xpath="//input[@name='company_name']")
	WebElement companyName;
	
	@FindBy(xpath="//textarea[@class='form-control']")
	WebElement descriptionOfCompany; 
	
	@FindBy(xpath="//input[@name='supplier_designation']")
	WebElement supplierDesignation;
	
	@FindBy(xpath="//input[@id='company_logo']")
	WebElement companyLogo;
	
	@FindBy(xpath="//textarea[@name='about_me' and @class='form-control']")	
	WebElement aboutMe;
	
	
	public EditProfilePage()
	{
		PageFactory.initElements(driver, this);		
	}
	
	public static void selectCategory()
	{
		Select select = new Select(driver.findElement(By.xpath("//select[@name='prod_category[]']")));
		select.selectByValue("11");
		select.selectByValue("15");
		select.selectByValue("21");
		select.selectByValue("23");
		select.selectByValue("47");
		
	}
	
	public void EditProfileTest(){		
		companyName.sendKeys("panaceatek infoteck .com ");
		descriptionOfCompany.clear();
		descriptionOfCompany.sendKeys("this is description.");
		supplierDesignation.sendKeys("Software Test Engineer !!");
		//selectCategory();
		
	} 
	
	/*public 
	public void addCompanyLogo()
	{
		companyLogo.sendKeys("C:\\Users\\QA\\Desktop\\Test Images\\images.jpg");
	}*/
	
	
}
