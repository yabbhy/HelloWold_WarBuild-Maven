package toolsQA.bo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import toolsQA.core.CommonUtils;
import toolsQA.core.InitializeBrowser;

public class WidgetsPage extends InitializeBrowser {
	//public static WebDriver driver; extends InitializeBrowser
	
	public WidgetsPage() {
		super();
	}
	
	//InitializeBrowser i =  new WidgetsPage();
	CommonUtils util = new CommonUtils();
	JavascriptExecutor js;
	
	public void verifyTabs()
	{
		driver.findElement(By.xpath(util.readProperties("widgetsLink"))).click();
		WebElement tab = driver.findElement(By.xpath(util.readProperties("t.TabsLink")));
		js = (JavascriptExecutor)driver;
		//scrolling to the particular element on the page
		js.executeScript("arguments[0].scrollIntoView(true);", tab);
		driver.findElement(By.xpath(util.readProperties("t.TabsLink"))).click();
	
		List<WebElement> tabs = driver.findElements(By.xpath(util.readProperties("t.NavTabs")));
//		System.out.println(tabs.size());
		
		for (WebElement currentTab : tabs) {
			String text = currentTab.getText();
			System.out.println("Tabs in this section are: "+text);
			for(int i= 0; i<tabs.size();i++) {
				//to click on the particular tab
				if(tabs.get(i).getText().contains("Use")) {
					tabs.get(i).click();
					break;
				}
			}
		}
		//other way to achieve the same as above
//		for(int i= 0; i<tabs.size(); i++) {
//			String text = tabs.get(i).getText();
//			System.out.println(text);
//			if(tabs.get(i).getText().contains("Use")) {
//				tabs.get(i).click();
//				//System.out.println(tabs.get(i).getText());
//				break;
//				
//			}
//		}
		
	}
	
	public void verifySelectMenu()
	{
		driver.findElement(By.xpath(util.readProperties("widgetsLink"))).click();
		WebElement tab = driver.findElement(By.xpath(util.readProperties("t.TabsLink")));
		WebElement selectMenu = driver.findElement(By.xpath(util.readProperties("t.SelectMenu")));
		js = (JavascriptExecutor)driver;
		
		//scrolling to the particular element on the page
	//	js.executeScript("arguments[0].scrollIntoView(true);", menus);
		js.executeScript("arguments[0].scrollIntoView(true);", tab);	
		selectMenu.click();
		
		WebElement selectValue = driver.findElement(By.xpath(util.readProperties("t.SelectValue")));
		selectValue.click();
		js.executeScript("arguments[0].value='Group 2, Option 2'",selectValue);

		String value = selectValue.getText();
		System.out.println(value);

//		WebElement selectOption = driver.findElement(By.xpath("//div[@*=' css-1uccc91-singleValue']"));
//		selectOption.click();
//		List <WebElement> selectOptions = driver.findElements(By.xpath("//div[@*=' css-1uccc91-singleValue']"));
//		
//		System.out.println("options size = "+selectOptions.size());
//		for(int i= 0; i<= selectOptions.size(); i++) {
//			System.out.println("select options = "+selectOptions.get(i).getText());
//		}
//		
//		if(selectOptions.contains("Group 2, Option 2")) {
//		
//			//selectValue.click();
//		}
		
	}
	
}
