package com.p1109.QA.SeleniumMethods;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkExample{
	static WebDriver driver;
	String browser = "chrome";
	public static void main(String[] args) throws Exception, IOException {	
		setUpBrowser("chrome");
		getUrl("https://makemysushi.com/");

		//count of all the available links in a display page.
		List<WebElement> linkList = driver.findElements(By.tagName("a"));		
		linkList.addAll(driver.findElements(By.tagName("img")));

		System.out.println("All available links : "+linkList.size());// get size of all the links


		//to store only active links need an array.
		List<WebElement> activeLinks = new ArrayList<WebElement>();

		//iteration of links to exclude , a/img with no href.
		for (int i = 0; i < linkList.size(); i++) {
			//System.out.println(linkList.get(i).getAttribute("href"));
			if(linkList.get(i).getAttribute("href") !=null )
				//&& (! linkList.get(i).getAttribute("href").contains("javascript"))
			{
				activeLinks.add(linkList.get(i));
			}		
		}		
		System.out.println("All active links : "+activeLinks.size());//Get the size of the active links.

		//To check the href url with HttpConnection url
		//404=page not found error
		//400 =bad connection
		//500 = internal error
		//200 = ok, ok URL

		for (int j=0;j<activeLinks.size();j++)
		{
			HttpURLConnection connections	=(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();		
			connections.connect();
			String response=connections.getResponseMessage();// ok(for correct URL) 
			connections.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+"== ==>>"+response);

		}
		tearDown();// to quit the browser !!
	}

	public static void setUpBrowser(String browser)
	{
		if (browser.equalsIgnoreCase("chrome")){

			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	
		}
		else{
			System.out.println("Incorrect Browser Name");
		}
	}
	public static void getUrl(String url)

	{
		driver.get(url);
	}
	public static void tearDown()
	{
		driver.quit();
	}
}


//RunTime Error :- 
//Exception in thread "main" java.net.MalformedURLException: unknown protocol: javascript
