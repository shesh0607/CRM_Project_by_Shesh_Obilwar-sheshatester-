package sample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	
	public static void main(String [] arg) throws IOException {
		
		//WebDriver driver;
		
		//driver=WebDriverManager.chromedriver().create();
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver(); 
		
		/*WebDriver driver;
		WebDriverManager.edgedriver().setup();
		
		driver=new EdgeDriver();*/
		
		
		FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFile.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String URL=pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");		
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
		
		Random ram=new Random();
		int ranNum=ram.nextInt(1000);
		FileInputStream fs =new FileInputStream("./src/test/resources/VTExcel.xlsx");
		
         Workbook book=WorkbookFactory.create(fs);
         Sheet sheet=book.getSheet("Organization");
         Row row=sheet.getRow(0);
         Cell cel=row.getCell(0);
         String Exceldata=cel.getStringCellValue()+ranNum;
         
         driver.findElement(By.name("accountname")).sendKeys(Exceldata);

         driver.findElement(By.name("button")).submit();
	
	}
}
