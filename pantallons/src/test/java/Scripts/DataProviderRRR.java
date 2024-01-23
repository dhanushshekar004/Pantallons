package Scripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.*;
public class DataProviderRRR {
	
	
	/*
	 * @DataProvider(name="data") public static String [][] data() throws
	 * EncryptedDocumentException, IOException{ FileInputStream ips= new
	 * FileInputStream("C:\\Users\\Dhanush S\\Downloads\\productname.xlsx");
	 * Workbook work = WorkbookFactory.create(ips); Sheet sheet =
	 * work.getSheet("Sheet1"); System.out.println(sheet); int rownum =
	 * sheet.getLastRowNum(); short columnum = sheet.getRow(1).getLastCellNum();
	 * String getdata[][]=new String[rownum][columnum]; for (int i = 1; i < rownum;
	 * i++) { for (int j = 0; j < columnum; j++) {
	 * getdata[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
	 * 
	 * } } return getdata;
	 * 
	 * 
	 * }
	 */
	
	
	
	//@Test(dataProvider ="data" )
	//public static void datawef(String productname, String emailName) throws InterruptedException  {
	@Test
public static void datawef() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.getjop.com/scheduleademo");
		Thread.sleep(1000);
		/*
		 * driver.findElement(By.
		 * xpath("//input[@placeholder=\"Please enter your full name\"]")).click();
		 * driver.findElement(By.
		 * xpath("//input[@placeholder=\"Please enter your full name\"]")).sendKeys(
		 * "productname"); driver.findElement(By.
		 * xpath("//input[@placeholder=\"Please enter your Business Email\"]")).click();
		 * driver.findElement(By.
		 * xpath("//input[@placeholder=\"Please enter your Business Email\"]")).sendKeys
		 * ("emailName");
		 */
		List<WebElement> list = driver.findElements(By.tagName("input"));
	int size = list.size();
	for (WebElement name : list) {
	String data = RandomStringUtils.randomAlphabetic(1, 10);
		
		name.sendKeys(data);
		System.out.println(data);
	}
	
		}
		
	}
	
	
	
	
	


