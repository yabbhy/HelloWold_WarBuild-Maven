package toolsQA.bo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import toolsQA.core.CommonUtils;
import toolsQA.core.InitializeBrowser;

public class InteractionsPage extends InitializeBrowser {

	CommonUtils util = new CommonUtils();
	JavascriptExecutor js;
	public void verifySelectable() {
		driver.findElement(By.xpath(util.readProperties("i.InteractionsLink"))).click();
		driver.findElement(By.xpath(util.readProperties("i.Selectable"))).click();
		driver.findElement(By.xpath(util.readProperties("i.Grid"))).click();
	
		List<WebElement> grids = driver.findElements(By.xpath(util.readProperties("i.GridOptions")));
	
		for (WebElement grid : grids) {
			String option = grid.getText();
			System.out.println(option);	
		//to click on all grid options
			if(option.contains(option)) {
				grid.click();
			}
		}
	}
	
	public void verifyDroppable() {
		driver.findElement(By.xpath(util.readProperties("i.InteractionsLink"))).click();
	WebElement droppable =	driver.findElement(By.xpath(util.readProperties("i.Droppable")));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", droppable);
		droppable.click();
		
		//pausing for synchronizing with actions performed using Actions class below
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement src = driver.findElement(By.xpath(util.readProperties("i.DragMeBox")));
		WebElement dest = driver.findElement(By.xpath(util.readProperties("i.DropHere")));
	
		Actions act = new Actions(driver);
		act.clickAndHold(src)
		.pause(Duration.ofSeconds(2)) //pausing before releasing to make sure the actions are  completed
		.moveToElement(dest)
		.release()
		.build()
		.perform();
	}
}
