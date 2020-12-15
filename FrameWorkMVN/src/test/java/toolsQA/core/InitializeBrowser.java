package toolsQA.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



public class InitializeBrowser {
	public InitializeBrowser() {
		
	}
	
	public static WebDriver driver;
	CommonUtils utils = new CommonUtils();
	public  String url = utils.readProperties("url"); //"https://demoqa.com";
	
	public void launchBrowser()
	{
		String driverPath = "/Users/bhupendranath/eclipse-workspace/SeleniumAutomationFrameWork/Drivers/chromedriver";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		
		
	//	driver = new SafariDriver();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//driver.manage().window().fullscreen();
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--incognito");
		DesiredCapabilities cap = new DesiredCapabilities();
	
		
		
		
	}

	public void tearDownBrowser()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
		
	}
}
