package toolsQA.tests;



	import java.io.File;
	import java.io.IOException;
	import java.lang.reflect.Method;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	
	import java.util.concurrent.TimeUnit;


	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Wait;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeGroups;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.MediaEntityBuilder;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;
	import com.google.common.io.Files;

	public class DemoExtentReport {
		WebDriver driver;
	
		String testCaseName;
		
		SoftAssert sa= new SoftAssert();
		WebDriverWait wait;
		//String testCaseName;
		public ExtentHtmlReporter htmlReporter;
		public ExtentReports extent;
		public static ExtentTest extentRep;
		public static ExtentAventReporter extrpt  ;

		@Test(enabled = true )
		public void Testcase01() throws IOException
		//public void Testcase01()
		{
			driver.get("https://www.amazon.com");		

			//Maximize the browser  
			driver.manage().window().maximize();  

			//Implicit Wait 	       
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

			//Locators
			String inputField ="//input[@id='twotabsearchtextbox']";
			String searchBtn = "//input[@type='submit'][@value='Go']";        
			String searchResults = "//div[@*='sg-col-inner']//span[contains(text(),'$$$$')]";   
			String searchKey = "chairs"; 

			//Actions
			//Search for Mobile	       
			driver.findElement(By.xpath(inputField)).sendKeys(searchKey);
			driver.findElement(By.xpath(searchBtn)).click();

			//Validations
			String srchresult =  driver.findElement(By.xpath(searchResults.replace("$$$$", searchKey))).getText();
			if(srchresult =="Results") {
				System.out.println("PASS");
				extentRep.log(Status.PASS, "Expected Results are displayed");    


			} else {
				System.out.println("FAIL");
				String screenshotPath = getScreenShot(driver, "Validation Name 0001");
				extentRep.log(Status.FAIL, "Expected Results are not displayed");

				extentRep.fail("FAIL",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

				Assert.fail();

			}

		}


		@Test
		public void TestCase002() {

			extentRep.log(Status.INFO, "THIS STEP IS INFO EXECUTED");
			extentRep.log(Status.DEBUG, "THIS STEP IS DEBUG  EXECUTED");

		}

		@Test
		public void TestCase003() {
			extentRep.log(Status.PASS, "THIS STEP IS PASS EXECUTED");
			extentRep.log(Status.FAIL, "THIS STEP IS FAIL EXECUTED");
		}

		@Test
		public void TestCase004() {
			extentRep.log(Status.WARNING, "THIS STEP IS Warning EXECUTED");

		}

		@SuppressWarnings("deprecation")
		public void startReport() {
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/resources/output/AutomationReport.html");
			htmlReporter.config().setDocumentTitle("Automated Execution report"); 
			// Name of the report
			htmlReporter.config().setReportName("Amazon Regression report "); 
			// Dark Theme
			htmlReporter.config().setTheme(Theme.STANDARD); 


			// Create an object of Extent Reports
			extent = new ExtentReports();  
			extent.attachReporter(htmlReporter);		 
			extent.setSystemInfo("Host Name", "Software Test Automation Framework");
			extent.setSystemInfo("Environment", "Production");
			extent.setSystemInfo("User Name", "B.N");

		}


		//This method is to capture the screenshot and return the path of the screenshot.
		public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {

			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			// after execution, you could see a folder "FailedTestsScreenshots" under src folder
			String destination ="./resources/output"+dateName + ".png";

			//Selenium
			TakesScreenshot ts = (TakesScreenshot) driver;

			//Saving the screenshot taken into a file instance
			//Cache
			File source = ts.getScreenshotAs(OutputType.FILE);

			//This file instance is what i want my screenshot to be generated
			File finalDestination = new File(destination);

			//Copying from the cache to the created file destination
			Files.copy(source, finalDestination);

			return destination;
		}

		@BeforeClass
		public void beforeClass() {	

			// System Property for Chrome Driver   
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver");        



			//extrpt = new ExtentReporter();
			startReport();
		}

		@BeforeMethod
		public void beforeMethod(Method method) {
			testCaseName = method.getName();
			driver = new ChromeDriver();
			extentRep = extent.createTest(testCaseName);   
		}

		@AfterMethod
		public void afterMethod(ITestResult result) throws IOException {
			if(result.getStatus() == ITestResult.FAILURE){
				//MarkupHelper is used to display the output in different colors
				extentRep.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));			
			}
			else if(result.getStatus() == ITestResult.SKIP){
				extentRep.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
			} 
			else if(result.getStatus() == ITestResult.SUCCESS)
			{
				extentRep.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
			}
			driver.quit();
		}



		@AfterClass
		public void endReport() {
			extent.flush();

	}

}
