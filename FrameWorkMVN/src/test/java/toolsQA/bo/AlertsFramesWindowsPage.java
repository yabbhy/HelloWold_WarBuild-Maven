package toolsQA.bo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import toolsQA.core.InitializeBrowser;
import toolsQA.core.CommonUtils;

public class AlertsFramesWindowsPage extends InitializeBrowser {
	CommonUtils util;
	public AlertsFramesWindowsPage() {
		super();
		this.util  = new CommonUtils();
	}
	
	//CommonUtils util = new CommonUtils();
	
	public void testAlertBtn() {
		
		//launchBrowser();
		driver.findElement(By.xpath(util.readProperties("al.AlertFrameLink"))).click();
		driver.findElement(By.xpath(util.readProperties("al.Alerts"))).click();
		driver.findElement(By.xpath(util.readProperties("al.AlertBtn"))).click();
		
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		System.out.println("timer alert message: "+text);
		al.dismiss();
	}
	
	public void testTimerAlert() {
		
		driver.findElement(By.xpath(util.readProperties("al.AlertFrameLink"))).click();
		driver.findElement(By.xpath(util.readProperties("al.Alerts"))).click();
		driver.findElement(By.xpath(util.readProperties("al.TimerAlertBtn"))).click();
	try {
		Thread.sleep(7000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		System.out.println("timer alert message: "+text);
		al.dismiss();
		
	}
	
	public void testFrame() {
		driver.findElement(By.xpath(util.readProperties("al.AlertFrameLink"))).click();
		driver.findElement(By.xpath(util.readProperties("fr.Frames"))).click();
		System.out.println("current page title "+driver.getTitle());
		
		driver.switchTo().frame(util.readProperties("fr.frame1"));
		String frame1Text = driver.findElement(By.xpath(util.readProperties("fr.FrameContent"))).getText();
		System.out.println("First frame content "+frame1Text);
		
		driver.switchTo().defaultContent().switchTo().frame(util.readProperties("fr.frame2"));
		String frame2Text = driver.findElement(By.xpath(util.readProperties("fr.FrameContent"))).getText();
		System.out.println("Second frame content "+frame2Text);
				
		System.out.println("current page title "+driver.switchTo().defaultContent().getTitle());
	}

}
