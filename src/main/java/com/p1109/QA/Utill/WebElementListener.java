package com.p1109.QA.Utill;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.p1109.QA.BaseClass.Base_Or_Parent;

public class WebElementListener extends Base_Or_Parent implements WebDriverEventListener{


	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigated to : "+ url + " ");

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to  :"+url +" ");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forword to next page.");

	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forword to next page.");

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Navigating back to privious page");

	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Navigated back to priviou page");

	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Try to click on :" + element.toString());

	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on :" + element.toString());

	}

	/*public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println();	
	}*/

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("value of the :"+ element.toString()+ "  before any changes made.");

	}
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("value of the :"+ element.toString());

	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Try to find element by : "+ by.toString());

	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found element by : "+ by.toString());

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void onException(Throwable error, WebDriver driver) { //Throwable throwable

		System.out.println("Exception occured : "+ error);
		//Can also write Screeneshot code here to capture errors.
		/*try
		{
			takeScreenshotAtEndOfTest();// Need to create this method then only can capture screenshot.
		}catch(IOException e)
		{
			e.printStackTrace();
		}*/
	}

}
