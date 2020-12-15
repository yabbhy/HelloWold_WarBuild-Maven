package toolsQA.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import toolsQA.bo.ElementsPage;

public class ElementsPageTests {
	public Logger log = Logger.getLogger("automationLogger");

	ElementsPage ep = new ElementsPage();
	
	@AfterTest
	void tearDownBrowser(){
		ep.tearDownBrowser();
	}
	
	@Test(priority = 0)
	public void validateTitle() {
		ep.verifyPageTitle();
		log.debug("running page validation test");
		log.info("page validdation test passed");
		log.fatal("page validdation test failed");
		log.error("unable to run page validation test");
	}
	
	@Test(priority = 1, enabled = true)
	public void validateContents() {
		ep.verifySubContents();
	}
	
	@Test(priority = 12,  enabled = true)
	public void validateTextBox() {
		ep.testTextBox();
		//ep.tearDownBrowser();
	}
	
	@Test(priority = 13, enabled = true)
	public void validateRadioBtn() {
		ep.testRadioBtn();
	//	ep.tearDownBrowser();
	}
	
	@Test(priority = 2, enabled = true)
	public void testTable() {
		ep.testTable();
		log.debug("Exceuting table test");
		log.info("Table test passed");
		log.fatal("Table test failed");
	}
	
	@Test(priority = 3, enabled = true)
	public void testButtons() {
		ep.testDoubleClickButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ep.testRightClickButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		ep.testClickMeButton();
		//ep.tearDownBrowser();
	}

	@Test(priority = 3, enabled = false)
	public void testForms() {
		ep.testForms();
	}
	
}
