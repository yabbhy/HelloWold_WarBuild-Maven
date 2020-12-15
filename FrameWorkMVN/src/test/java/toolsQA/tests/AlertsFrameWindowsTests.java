package toolsQA.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import toolsQA.bo.AlertsFramesWindowsPage;
import toolsQA.core.InitializeBrowser;

public class AlertsFrameWindowsTests extends AlertsFramesWindowsPage {
	
	public AlertsFrameWindowsTests() {
		super();
	}

	//InitializeBrowser i = new InitializeBrowser();
	
	@BeforeMethod //why do i have to have this method as public.?
	public void initialize() {
		launchBrowser();
	}
	
	@Test(priority = 0, enabled = true)
	private void testAlert() {
		testAlertBtn();
	}
	
	@Test(priority = 1,enabled = true)
	private void testTimerAlerts() {
		testTimerAlert();
	}
	
	@Test
	void testFrames() {
		testFrame();
	}
	
	@AfterTest
	void tearDown() {
		tearDownBrowser();
	}

}
