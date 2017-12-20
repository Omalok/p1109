package com.p1109.QA.SeleniumMethods;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class TableOperations {

	public static void main(String[] args) {

		System.setProperty("driver.chrome.webdriver","E:\\Softwares\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///E:/Contents/Website%20Collections/WebPages/table.html");

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


