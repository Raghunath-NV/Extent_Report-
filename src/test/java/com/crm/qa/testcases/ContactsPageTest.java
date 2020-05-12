package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public ContactsPageTest() {
		super();
		

	}

	@BeforeMethod
	public void setup() throws Exception {
		intialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}

//	@Test(priority = 1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is missing on Page");
	}

//	@Test(priority = 2)
	public void verifySelectContactsTest() {
		contactsPage.selectContacts("Aakash Anmash");
	}
	
	
//	@DataProvider
//	public Object[][] getCRMTestData()
//	{
//		Object data[][]= testUtil.getTestDataFromPropertiesFile("Contacts");
//		return data;
//	}
//	
//	@Test(priority = 3,dataProvider="getCRMTestData")
//	public void validateCreateNewContact(String title,String fname,String lname,String company) {
//		homePage.clickOnNewContactsLink();
//		//contactsPage.createNewContact("Mr.", "John", "Smith", "Google");
//		contactsPage.createNewContact(title,fname,lname,company);
//	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
