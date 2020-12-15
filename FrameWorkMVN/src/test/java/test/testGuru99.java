package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testGuru99 {

	WebDriver driver;
	static XSSFWorkbook fileName;
	static XSSFSheet sheet;
	static XSSFCell data;
	
	public static void main(String[] args) {
	String t1 =	readExcel("Sheet1", "UN", "TD1");
	System.out.println(t1);
	}
	
	@BeforeMethod
	void setup() {
		String driverPath = "/Users/bhupendranath/eclipse-workspace/SeleniumAutomationFrameWork/Drivers/chromedriver"; //System.getProperty("user.dir")+"/SeleniumAutomationFrameWork/Drivers/chromedriver";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		String url = "http://demo.guru99.com/V1/index.php";
		driver.get(url);
		
	}
	@Test(dataProvider = "guru99Login")
	void testLogin(String username, String pass) {
		
		String userN = "//input[@name ='uid']"; String pwd = "//input[@name ='password']";
		String loginBtn = "//input[@name ='btnLogin']";
//		String un = "mngr285843";
//		String pass = "AbEnAzu";
		
		driver.findElement(By.xpath(userN)).sendKeys(username);
		driver.findElement(By.xpath(pwd)).sendKeys(pass);
		driver.findElement(By.xpath(loginBtn)).click();
		System.out.println(driver.switchTo().alert().getText());;
		driver.switchTo().alert().dismiss();
		System.out.println(driver.getTitle());
		driver.quit();
	}
	/*
	 * @DataProvider(name = "guru99Login")
	public String [][] passData()
	{
		String [][] data = new String[3][2];
		data[0][0] = "admin1";
		data[0][1] = "demo1";
		
		data[1][0] = "admin2";
		data[1][1] = "demo2";
		
		data[2][0] = "mngr285843";
		data[2][1] = "AbEnAzu";
		
		return data;
		
	}
	 */
	
	
	@DataProvider(name = "guru99Login")
	public static String readExcel(String sheetName, String colWanted, String rowWanted)
	{
		String testData = "";
		
		try {
			File fileToRead = new File("./src/test/resources/input/testData/Guru99.xlsx");
			FileInputStream fis = new FileInputStream(fileToRead);
			
			Integer colNo = null; Integer rowNo = null;
			Row firstRow;
			
			fileName = new XSSFWorkbook(fis);
			sheet = fileName.getSheet("Sheet1");
			
			firstRow = sheet.getRow(0);
			for (Cell cell : firstRow) {
				if(cell.getStringCellValue().trim().equals(colWanted)) {
					colNo = cell.getColumnIndex();
					break;
				}
			}
			
			if(colNo == null) {
				System.out.println("Test data not found in "+ colWanted);
			}
			
			int rowCount = sheet.getLastRowNum();
			
			for(int i = 1; i<= rowCount; i++) {
				if(rowWanted.equals(sheet.getRow(i).getCell(0).toString().trim())) {
					rowNo = i;
					break;
				}
			}
			
			if(rowWanted == null) {
				System.out.println("test data not present in "+rowWanted);
			}
			
			data = sheet.getRow(rowNo).getCell(colNo);
			testData = data.getStringCellValue().trim();
			
		}catch(FileNotFoundException e){
			e.getMessage();
		}catch(IOException e) {
			e.getMessage();
		}catch(NullPointerException e) {
			e.getMessage();
		}
		
		return testData;
	}
}
