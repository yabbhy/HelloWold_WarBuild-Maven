package toolsQA.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CommonUtils {
	
public ExtentHtmlReporter htmlReporter;
public static ExtentReports extentReport;
public static ExtentTest extentLogger;
public static ExtentAventReporter extentReporter;

	public String readProperties(String key)
	{
		String data = "";
		String filePath = "./resources/input/ToolsQaObjectRepo.properties";

		File toolsQaObjectRepo = new File(filePath);

		try {
			FileInputStream fis = new FileInputStream(toolsQaObjectRepo);
			Properties prop = new Properties();
			prop.load(fis);
			//	System.out.println("file loaded ");
			String requiredField = prop.getProperty(key);
			//requiredField = data;
			data = requiredField ;
		}catch(FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {

			e.getMessage();
		}
		return data;
	}
	
	public void selectDateUsingJs(WebDriver driver, WebElement element, String dateValue)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].setAttribute('value','"+dateValue+"');", element);
	}
	
	@SuppressWarnings("deprecation")
	public void startReport() 
	{
		//set the path of the report to be saved
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/resources/output/ToolsQsExtentReport.html");
		
		//create an object of extent reports
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		
		extentReport.setSystemInfo("Host Name", "Software Test Automation Framework");
		extentReport.setSystemInfo("Environment", "Production");
		extentReport.setSystemInfo("User Name", "B N");
		
		//Title of the report
		htmlReporter.config().setDocumentTitle("ToolsQa Automated Execution Report");
		
		// Name of the report
		htmlReporter.config().setReportName("ToolsQa Regression Report");
		
		//setting the theme type as dark
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

}

/*
 * public static void main(String[] args) {
	CommonUtils util = new CommonUtils();

	String str = util.readProperties("submitResult");
	System.out.println(str);
	String str2 = util.readProperties("url");
	System.out.println(str2);
}
 */

/*
public String readProperties(String locatorKey)
{
String data = "";

String filePath = "./resources/input/ToolsQafile.properties";
File toolsQaObjectRepoFile = new File(filePath);
try {
FileInputStream fis = new FileInputStream(toolsQaObjectRepoFile);
Properties prop = new Properties();
prop.load(fis);

String requiredField = prop.getProperty(locatorKey);
//System.out.println("this is a "+requiredField);
 requiredField = data;
//searchKey = (String) prop.get(requiredField);

} catch (FileNotFoundException e) {
e.getMessage();
} catch (IOException e) {
e.getMessage();
}

return data;
}
 */
