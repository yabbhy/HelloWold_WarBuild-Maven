package toolsQA.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import toolsQA.bo.InteractionsPage;

public class InteractionsPageTests extends InteractionsPage{
	
	@BeforeMethod()
	public void setup(){
		launchBrowser();
	}
	
	@Test(enabled = true)
	void testSelectable() {
		verifySelectable();
	}
	
	@Test
	void testDroppable() {
		verifyDroppable();
	}
	
	@AfterClass
	public void closeBrowser() {
		tearDownBrowser();
	}
}
