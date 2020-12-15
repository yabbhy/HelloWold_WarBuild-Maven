package toolsQA.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import toolsQA.bo.WidgetsPage;

public class WidgetsPageTests extends WidgetsPage {
	
	
	@BeforeMethod()
	public void setup(){
		launchBrowser();
	}
	
	@Test(enabled = false)
	void testTabs() {
	verifyTabs();
	}
	
	@Test(enabled = true)
	void testSelectMenu() {
		verifySelectMenu();
	}
	
	@AfterClass
	public void closeBrowser() {
		//tearDownBrowser();
	}

}
