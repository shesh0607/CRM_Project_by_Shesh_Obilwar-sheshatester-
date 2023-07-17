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

import Generic_Utility.Java_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws IOException, InterruptedException {
     WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver(); 
		

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
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
		
		//Reusable Method Stored in generic_Utility.
		Java_Utility jlib=new Java_Utility();
		int ranNum=jlib.getRandomNum();
		
		FileInputStream fs =new FileInputStream("./src/test/resources/VTExcel.xlsx");
		
        Workbook book=WorkbookFactory.create(fs);
        Sheet sheet=book.getSheet("contact");
        Row row=sheet.getRow(0);
        Cell cel=row.getCell(0);
        String Exceldata=cel.getStringCellValue()+ranNum;
        
        driver.findElement(By.name("lastname")).sendKeys(Exceldata);

        driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
	    
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
        driver.findElement(By.linkText("Sign Out")).click();		

	}

}
