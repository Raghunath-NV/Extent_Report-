package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public static String TESTDATA_SHEET_PATH = "/Users/Raghu/Documents/Git_Jenkins/JenkinsPractice/FreeCRMTest/src/main/java/com/crm/qa/testdata/free_crm_testdata.xlsx";

//	static Workbook book;
//	static Sheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	

//	public static Object[][] getTestData(String sheetName) {
//		FileInputStream file = null;
//		try {
//			file = new FileInputStream(TESTDATA_SHEET_PATH);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			book = WorkbookFactory.create(file);
//		} catch (InvalidFormatException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		sheet = book.getSheet(sheetName);
//		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		for (int i = 0; i < sheet.getLastRowNum(); i++) {
//			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
//				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
//			}
//		}
//		return data;
//	}

//	public static Object[][] getTestDataFromPropertiesFile(String sheetName) {
//
//		XSSFWorkbook workbook2;
//		XSSFSheet sheet2;
//		File src = new File(TESTDATA_SHEET_PATH);
//		FileInputStream fileInputStream;
//		Object[][] data = null;
//		try {
//			fileInputStream = new FileInputStream(src);
//
//			workbook2 = new XSSFWorkbook(fileInputStream);
//			sheet2 = workbook2.getSheet(sheetName);
//
//			int rowCount = sheet2.getLastRowNum() + 1; // number of rows
//			int columnCount = sheet2.getRow(0).getLastCellNum(); // columns
//
//			data = new Object[sheet2.getLastRowNum()][sheet2.getRow(0).getLastCellNum()];
//			for (int i = 0; i < sheet2.getLastRowNum(); i++) {
//				for (int k = 0; k < sheet2.getRow(0).getLastCellNum(); k++) {
//					data[i][k] = sheet2.getRow(i + 1).getCell(k).toString();
//				}
//
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return data;
//	}
}
