package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatecampwithProduct {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//FileInputStream fis=new FileInputStream("./src/test/resources/TestData.properties");
		FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFile.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

		Random ran=new Random();
		int RanNum = ran.nextInt(1000);

		FileInputStream fes=new FileInputStream("./src/test/resources/VTExcel.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("product");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		String productName = cel.getStringCellValue()+RanNum;
		
		driver.findElement(By.name("productname")).sendKeys(productName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		
		FileInputStream fes1=new FileInputStream("./src/test/resources/VTExcel.xlsx");
		Workbook book1 = WorkbookFactory.create(fes1);
		Sheet sheet1 = book.getSheet("Campaign");
		Row row1 = sheet.getRow(1);
		Cell cel1 = row.getCell(1);
		String excelData = cel.getStringCellValue()+RanNum;
	    driver.findElement(By.name("campaignname")).sendKeys(excelData);
	    
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	    Thread.sleep(1200);
	    Set<String> allWin=driver.getWindowHandles();
	    Iterator<String> id=allWin.iterator();
	    while(id.hasNext())
	    {
	    	String wid=id.next();
	    	driver.switchTo().window(wid);
	    	String title=driver.getTitle();
	    	if(title.contains("Product&action"))
	    	{
	    		break;
	    	}
	    }
	    driver.findElement(By.name("search_text")).sendKeys(productName);
	    driver.findElement(By.name("search")).click();
	    
	    driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
	 
	    Set<String> allWin1=driver.getWindowHandles();
	    Iterator<String> id1=allWin1.iterator();
	    while(id1.hasNext())
	    {
	    	String wid1=id1.next();
	    	driver.switchTo().window(wid1);
	    	String title1=driver.getTitle();
	    	if(title1.contains("Campaigns&action"))
	    	{
	    		break;
	    	}
	    }
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	}

}
