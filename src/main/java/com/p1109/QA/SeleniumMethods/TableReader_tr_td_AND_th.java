package com.p1109.QA.SeleniumMethods;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableReader_tr_td_AND_th {

	static WebElement ele;
	static WebDriver driver;
	public TableReader_tr_td_AND_th(){
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//	driver.get("file:///D:/Assingment/Day1/WebPage/Table-%20double.html");
		driver.get("file:///D:/Assingment/Day1/WebPage/table.html");
		//driver.get("file:///D:/Assingment/Day1/WebPage/Table_Calendar.html");
	}
	 public static void main (String[] args) throws ParseException  { 
		 
		 
		 
		 TableReader_tr_td_AND_th obj = new TableReader_tr_td_AND_th();	      
		 
			List<WebElement> rows=driver.findElements(By.xpath("//tr"));

			int rowCount=rows.size();
			for (int i = 1; i<=rowCount; i++) {
				List<WebElement> cols=
						driver.findElements(By.xpath("//tr["+i+"]/td"));
				//System.out.println(i+" row contains... "+ cols.size()+" columns");
				/*			for (int j = 1; j<=cols.size(); j++) {
						WebElement e=driver.findElement(By.xpath("//tr["+i+"]/td["+ j+"]"));
						System.out.println(e.getText());
					}
				 */
				for (WebElement e : cols) {
					System.out.println(e.getText());
				}

			}
	 }
}
