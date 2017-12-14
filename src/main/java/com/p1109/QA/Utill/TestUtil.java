package com.p1109.QA.Utill;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.p1109.QA.BaseClass.Base_Or_Parent;

public class TestUtil extends Base_Or_Parent
{
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_WAIT =20;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\QA\\workspace\\p1109\\src\\main\\java\\"
			+ "com\\p1109\\QA\\TestData\\TestData.xlsx";	

	static Workbook book;
	static  Sheet sheet;


	//Use with  help of data provider in TestNG..!!

	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		try {
			file= new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet=book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//System.out.println(sheet.getLastRowNum());
		//System.out.println(sheet.getRow(0).getLastCellNum());

		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k= 0; k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
				//System.out.println(data[i][k]);				
			}
		}
		return data ;
	}


	// Jump to Frame 
	public static void switchToFrame()
	{
		driver.switchTo().frame("");
	}
	
	// To Capture screenShot
	public void captureScreenShort()
	{

		try {
			TakesScreenshot tc = (TakesScreenshot)driver;
			File source =tc.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./ScreenShots/p1109.png"));

			System.out.println("Screenshort taken");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshort "+e.getMessage());
		}
	}



}
