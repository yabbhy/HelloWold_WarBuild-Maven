package toolsQA.tests;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import toolsQA.bo.FormsPage;
import toolsQA.core.CommonUtils;

public class FormsPageTests extends FormsPage {
	
	private String testCaseName;

	FormsPageTests(){
		super();
	}
	
	CommonUtils util = new CommonUtils();
	
	//InitializeBrowser i = new InitializeBrowser();
	
	@BeforeMethod
	public void Initialize(Method method) {
		launchBrowser();
//		testCaseName = method.getName();
//		util.extentLogger = util.extentReport.createTest(testCaseName);
		 
	}
	
	/*
	@AfterMethod
	public void afterMethod(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE) {
			//setting the markup to display the output in diff colors
			CommonUtils.extentLogger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test Case Failed" , ExtentColor.RED));
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			CommonUtils.extentLogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case Skipped", ExtentColor.ORANGE));
			
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			CommonUtils.extentLogger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case Passed", ExtentColor.GREEN));
		}
		
	} */
	
	@Test(enabled = true)
	public void testForm(){
		//util.startReport();
		testForms();
	}
	
	@AfterTest
	void tearDown() {
		//tearDownBrowser();
	}

}
