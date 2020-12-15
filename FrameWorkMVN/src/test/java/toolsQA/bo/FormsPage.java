package toolsQA.bo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import toolsQA.core.CommonUtils;
import toolsQA.core.InitializeBrowser;

public class FormsPage extends InitializeBrowser{
	
	public FormsPage() {
		super();
		//this.launchBrowser(); 
	}
	
	public CommonUtils util = new CommonUtils();
	
	public void testForms() {
		//launchBrowser();
		String firstName = "Bhupi"; String lastName = "yogi";
		String email = "bhupi@eg.com";
		String currentAddr = "sampleAddr";
		String mobileNo = "1234567890"; String dob = "10 Aug 2040";
		String subjects ="Science" ; //"Chem,Bio,CSC,Computaion";
		
		//driver.navigate().back();
		driver.findElement(By.xpath(util.readProperties("fm.FormsLink"))).click();
		//driver.findElement(By.cssSelector(util.readProperties("fm.FormsLink"))).click();
		driver.findElement(By.xpath(util.readProperties("fm.PracticeForms"))).click();
		
		driver.findElement(By.xpath(util.readProperties("fm.FirstName"))).sendKeys(firstName);
		driver.findElement(By.xpath(util.readProperties("fm.LastName"))).sendKeys(lastName);
		driver.findElement(By.xpath(util.readProperties("fm.Email"))).sendKeys(email);
		driver.findElement(By.xpath(util.readProperties("fm.Gender.Male"))).click();
		driver.findElement(By.xpath(util.readProperties("fm.MobileNum"))).sendKeys(mobileNo);
		
		WebElement Dob = driver.findElement(By.xpath(util.readProperties("fm.DoB")));
//		Dob.clear();
//		Dob.sendKeys(dob);
//		Dob.sendKeys(Keys.ARROW_DOWN);
//		Dob.sendKeys(Keys.ENTER);
		Dob.click();
		WebElement month = driver.findElement(By.xpath("//select[@*='react-datepicker__month-select']"));
		
		Select mnth = new Select(month);
		month.click();
		mnth.selectByVisibleText("May");
		
		List<WebElement> years = driver.findElements(By.xpath("//select[@*='react-datepicker__year-select']"));
		
		for(WebElement year : years ) {
			String tempYear = year.getText();
			for(int i = 0; i<=years.size(); i++) {
				if(years.get(i).getText().contains("2020")) {
				years.get(i).click();
				break;
				}
			}
		}
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		List<WebElement> days = driver.findElements(By.xpath("//div[@*='react-datepicker__month']"));
		
		for (WebElement day : days) {
			for(int i= 0; i<=days.size();i++) {
				//String d = "12";
				if(days.get(i).getText().contains("12")) {
//				WebElement d =	days.get(i);
//					d.click();
					days.get(i).click();
					break;
				}
			}
		}
		
	//	util.selectDateUsingJs(driver, Dob, dob); //tried using this method did not worked
	
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		js1.executeScript("arguments[0].value='(10-Apr-2004)';", Dob);
		
		// subjects input field has auto complete feature for the input field on the web page 
		//thus could not be inspected and had to use alternative way to sendKeys
		WebElement sub = driver.findElement(By.xpath(util.readProperties("fm.Subjects")));
		sub.sendKeys(subjects);
		sub.sendKeys(Keys.ARROW_DOWN);
		sub.sendKeys(Keys.ENTER);	
		
//		driver.findElement(By.xpath(util.readProperties("fm.Subjects"))).sendKeys(subjects);
//		driver.findElement(By.xpath(util.readProperties("fm.Subjects"))).sendKeys(Keys.ARROW_DOWN);
//		driver.findElement(By.xpath(util.readProperties("fm.Subjects"))).sendKeys(Keys.ENTER);
		

//		Select drpDown = new Select(driver.findElement(By.xpath(util.readProperties("fm.Subjects") )));
//		drpDown.selectByVisibleText("Chemistry");
		
		driver.findElement(By.xpath(util.readProperties("fm.Hobbies.Music"))).click();
		driver.findElement(By.xpath(util.readProperties("fm.CurrentAddr"))).sendKeys(currentAddr);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		
		driver.findElement(By.xpath(util.readProperties("fm.SelectState1"))).click();
		driver.findElement(By.xpath(util.readProperties("fm.SelectState2"))).click();
		driver.findElement(By.xpath(util.readProperties("fm.SelectCity1"))).click();
		driver.findElement(By.xpath(util.readProperties("fm.SelectCity2"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.findElement(By.xpath(util.readProperties("fm.SubmitBtn"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
				
		String result = driver.findElement(By.xpath(util.readProperties("fm.Results"))).getText();
		System.out.println("Form details :\n"+result);
		
		driver.findElement(By.xpath(util.readProperties("fm.ResultsCloseBtn"))).click();
		
	
	}

}
