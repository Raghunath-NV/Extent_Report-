package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		intialization();
		 testUtil= new TestUtil();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		AssertJUnit.assertEquals(title, "CRMPRO","Home Page Title is not matched");  //3rd paramter useful for printing msg in report when testcase is failed
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();   //username is present in different frame
		Boolean flag = homePage.verifyUserNameVisibility();
		Assert.assertTrue(flag);

	}
	
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();   //Contacts is present in different frame
		contactsPage=homePage.clickOnContactsLink();

	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
