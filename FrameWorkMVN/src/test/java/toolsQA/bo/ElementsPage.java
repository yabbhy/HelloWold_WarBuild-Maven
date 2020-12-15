package toolsQA.bo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import toolsQA.core.CommonUtils;
import toolsQA.core.InitializeBrowser;

public class ElementsPage extends InitializeBrowser{
	
	InitializeBrowser br = new InitializeBrowser();
	CommonUtils util = new CommonUtils();
	
	public void verifyPageTitle()
	{
		br.launchBrowser();
		driver.findElement(By.xpath(util.readProperties("elements"))).click();
		String pageTitle = driver.getTitle();
		System.out.println("current page title is "+pageTitle);
		Assert.assertEquals(pageTitle, "ToolsQA");
	
	}
	
	public void verifySubContents()
	{
		boolean flag = driver.findElement(By.xpath(util.readProperties("tbContent"))).isDisplayed();
		Assert.assertEquals(flag, true);
	}
	
	public void testTextBox()
	{
		String name = "Bhupi";
		String email = "bhupi@eg.com";
		String addr = "sampleAddr"; String permAddr = "sample permAddr";
		String tb = util.readProperties("textBoxLink");
		//System.out.println(tb);
		
		driver.findElement(By.xpath(util.readProperties("textBoxLink"))).click();
		driver.findElement(By.xpath(util.readProperties("fullName"))).sendKeys(name);
		driver.findElement(By.xpath(util.readProperties("userEmail"))).sendKeys(email);
		driver.findElement(By.xpath(util.readProperties("address"))).sendKeys(addr);
		driver.findElement(By.xpath(util.readProperties("permanentAddr"))).sendKeys(permAddr);
		driver.findElement(By.xpath(util.readProperties("submitBtn"))).click();
	//	driver.get(driver.getCurrentUrl());
	String result = driver.findElement(By.xpath(util.readProperties("submitResult"))).getText();
	System.out.println(result+"\n");
	//Assert.assertEquals(result, "");
	}
	
	public void testRadioBtn() {
		driver.findElement(By.xpath(util.readProperties("radioBtn"))).click();
		driver.findElement(By.xpath(util.readProperties("yes"))).click();
		String result = driver.findElement(By.xpath(util.readProperties("clickResult"))).getText();
		System.out.println("testRadioBtn result "+result);
	}
	
	public void testTable() {
		
		String firstName = "Bhupi";
		String lastName = "yogi";
		String email = "byogi@eg.com";
		String age = "27";
		String salary = "250000";
		String dept = "Testing Automation";

		driver.findElement(By.xpath(util.readProperties("table"))).click();
		WebDriverWait exWait = new WebDriverWait(driver,10);
//		exWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(util.readProperties("data")))).isEnabled();
//		boolean st = driver.findElement(By.xpath("data")).isEnabled();
//		System.out.println(st);
//		driver.findElement(By.xpath("data")).click();
		
		//exWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(util.readProperties("data"))).
		boolean st = driver.findElement(By.cssSelector(util.readProperties("data"))).isEnabled();
		System.out.println(st);
		driver.findElement(By.cssSelector(util.readProperties("data"))).click();
		
		driver.findElement(By.xpath(util.readProperties("firstName"))).sendKeys(firstName);
		driver.findElement(By.xpath(util.readProperties("lastName"))).sendKeys(lastName);
		driver.findElement(By.xpath(util.readProperties("email"))).sendKeys(email);
		driver.findElement(By.xpath(util.readProperties("age"))).sendKeys(age);
		driver.findElement(By.xpath(util.readProperties("salary"))).sendKeys(salary);
		driver.findElement(By.xpath(util.readProperties("dept"))).sendKeys(dept);
	//	driver.findElement(By.xpath(util.readProperties("submitBtn"))).click();
	driver.findElement(By.xpath(util.readProperties("WT.submitBtn"))).click();
	exWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(util.readProperties("tableResult"))));
		String result = driver.findElement(By.xpath(util.readProperties("tableResult"))).getText();
	
		System.out.println(result);
	}
	
	public void testDoubleClickButton(){
		//driver.findElement(By.xpath(util.readProperties("btn.ButtonsLink"))).click();
		driver.findElement(By.xpath(util.readProperties("btn.ButtonsLink"))).click();
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(util.readProperties("btn.DoubleClickBtn")));
		actions.doubleClick(elementLocator).perform();
		//driver.findElement(By.xpath(util.readProperties("btn.DoubleClickBtn"))).click();
		String result = driver.findElement(By.xpath(util.readProperties("btn.DoubleClickResult"))).getText();
		System.out.println(result);
		Assert.assertEquals(result, "You have done a double click");
	}
	
	public void testRightClickButton(){
		driver.findElement(By.xpath(util.readProperties("btn.ButtonsLink"))).click();
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(util.readProperties("btn.RightClickBtn")));
		
		actions.contextClick(elementLocator).perform();
		//driver.findElement(By.xpath(util.readProperties("btn.DoubleClickBtn"))).click();
		String result = driver.findElement(By.xpath(util.readProperties("btn.RightClickResult"))).getText();
		System.out.println(result);
		Assert.assertEquals(result, "You have done a right click");
		
	}
	
	public void testClickMeButton(){
		driver.findElement(By.xpath(util.readProperties("btn.ButtonsLink"))).click();
//		Actions actions = new Actions(driver);
//		WebElement elementLocator = driver.findElement(By.xpath(util.readProperties("btn.ClickMeBtn")));	
//		actions.contextClick(elementLocator).perform();
		driver.findElement(By.xpath(util.readProperties("btn.ClickMeBtn"))).click();
		String result = driver.findElement(By.xpath(util.readProperties("btn.ClickMeBtnClickResult"))).getText();
		System.out.println(result);
		Assert.assertEquals(result, "You have done a dynamic click");
		
	}
	
	public void testForms() {
		
		String firstName = "Bhupi"; String lastName = "yogi";
		String email = "bhupi@eg.com";
		String currentAddr = "sampleAddr";
		String mobileNo = "1234567890"; String dob = "10/12/2050";
		String subjects = "Chem,Bio,CSC,Computaion";
		
		driver.navigate().back();
		driver.findElement(By.xpath(util.readProperties("fm.FormsLink"))).click();
		//driver.findElement(By.cssSelector(util.readProperties("fm.FormsLink"))).click();
		driver.findElement(By.xpath(util.readProperties("fm.PracticeForms"))).click();
		
		driver.findElement(By.xpath(util.readProperties("fm.FirstName"))).sendKeys(firstName);
		driver.findElement(By.xpath(util.readProperties("fm.LastName"))).sendKeys(lastName);
		driver.findElement(By.xpath(util.readProperties("fm.Email"))).sendKeys(email);
		driver.findElement(By.xpath(util.readProperties("fm.Gender.Male"))).click();
		driver.findElement(By.xpath(util.readProperties("fm.MobileNum"))).sendKeys(mobileNo);
		
		//driver.findElement(By.xpath(util.readProperties("fm.DoB"))).sendKeys(dob);
		
		driver.findElement(By.xpath(util.readProperties("fm.Subjects"))).sendKeys(subjects);
		driver.findElement(By.xpath(util.readProperties("fm.Hobbies.Music"))).click();
		driver.findElement(By.xpath(util.readProperties("fm.CurrentAddr"))).sendKeys(currentAddr);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		driver.findElement(By.xpath(util.readProperties("fm.SubmitBtn"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath(util.readProperties("fm.Results"))).getText();
		driver.findElement(By.xpath(util.readProperties("fm.Results.CloseBtn"))).click();
		
	}
}
