package toolsQA.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsDemo {

	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReport;
	public static ExtentTest extentLogger;
	public static ExtentAventReporter extentReporter;
	
	WebDriver driver;
	String testCaseName;
	
	@BeforeMethod
	public void prepareForReporting(Method method) {
		testCaseName = method.getName();
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
		driver = new ChromeDriver();
		extentLogger = extentReport.createTest(testCaseName);
	}
	
	public void startReport() {
		String filePath = System.getProperty("user.dir")+"/resources/output/SampleExentReport.html";
		htmlReporter = new ExtentHtmlReporter(filePath);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		
		extentReport.setSystemInfo("Host Name", "Software Test Automation Framework");
		extentReport.setSystemInfo("User Name", "B.N");
		
		htmlReporter.config().setDocumentTitle("Automated Test Execution Report");
		htmlReporter.config().setReportName("Demo Extent Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
}
