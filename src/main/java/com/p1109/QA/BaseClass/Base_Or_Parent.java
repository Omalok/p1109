package com.p1109.QA.BaseClass;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.p1109.QA.Utill.TestUtil;
import com.p1109.QA.Utill.WebElementListener;
public class Base_Or_Parent {
	public static Properties prop;
	public static WebDriver driver;
	public static JavascriptExecutor jse;
	static EventFiringWebDriver e_driver;
	static WebElementListener eventListener;
	
	
	public Base_Or_Parent()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\QA\\workspace\\p1109\\src\\main\\java\\com\\p1109\\QA\\Config_Enviroment_Variable\\config.properties");
			prop.load(ip);//Input Stream.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public static void intialization()
	{			
		String browserName = prop.getProperty("browser");
		String expected ="chrome";
		if(browserName.equals(expected))
			
		{	System.out.println("I am in !!");
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver_win32\\chromedriver.exe");				
		}else{System.out.println("else");}	
		
		driver = new ChromeDriver();
	// After launching Driver		
		e_driver=new EventFiringWebDriver(driver);
		// Now create object of EventlisterHandler to register it with EventFiringWebDriver. 		
		eventListener =new WebElementListener();
		e_driver.register(eventListener);
		jse = (JavascriptExecutor)driver;
		driver =e_driver;
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);// replace hardCoded value with class variable.
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//driver.get("http://someurl");
		driver.get(prop.getProperty("url"));
	}
}

/*String browserName = prop.getProperty("browser");		
if(browserName.equals("chrome"))
{
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();		
}
else if(browserName.equals("ff"))
{
	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.16.1-win32\\geckodriver.exe");
	driver = new FirefoxDriver();		
}*/


/*try {
	prop = new Properties();
	FileInputStream ip = new FileInputStream("C:\\Users\\QA\\workspace\\p1109\\src\\main\\java\\com\\p1109\\QA\\Config_Enviroment_Variable\\config.properties");
	prop.load(ip);//Input Stream.
} catch (FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}*/
