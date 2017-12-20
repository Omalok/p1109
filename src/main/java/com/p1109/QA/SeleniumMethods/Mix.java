package com.p1109.QA.SeleniumMethods;
import org.openqa.selenium.By;

import com.p1109.QA.BaseClass.Base_Or_Parent;

public class Mix extends Base_Or_Parent{

	public Mix(){
		super();
	}
	
	public static void main(String[] args) throws Exception {
		Mix mix = new Mix();
		intialization();
	driver.findElement(By.linkText("YES")).click();
	driver.findElement(By.xpath("//a[@href='http://182.72.79.154/321p1106/login']")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("//input[@id='email']")).sendKeys("alok@gmail.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
	}
	

	public static void login_N_Then_EditProfile()
	{
		driver.findElement(By.xpath("//a[@href='http://182.72.79.154/p1109/login']")).click();		
		driver.findElement(By.name("email")).sendKeys("alok@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-sam']")).click();		
		driver.findElement(By.xpath("//input[@name='company_name']")).clear();		
		driver.findElement(By.xpath("//input[@name='company_name']")).sendKeys("panaceaTEK");
		driver.findElement(By.xpath("//textarea[@name='company_desc']")).sendKeys("Description of description field !!");
		jse.executeScript("window.scrollBy(0,650)", "");		
		driver.findElement(By.xpath("//input[@id='company_logo']")).sendKeys("C:\\Users\\QA\\Desktop\\Test Images\\images.jpg");
		driver.findElement(By.xpath("//textarea[@name='about_me']")).sendKeys("I am a sotware tester in panacea infotek.. !!");
		driver.findElement(By.xpath("//button[@class='btn btn-main']")).submit();
	}
}
