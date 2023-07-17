package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM_Repo.Home_Page;
import POM_Repo.LoginPage;
import POM_Repo.ProductCreationPage;
import POM_Repo.ValidationAndVarificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct extends BaseClass {
	@Test(groups= {"smokeTest","RegressionTest"})
	public void createProduct() throws EncryptedDocumentException, IOException{
		
//		WebDriver driver;
//		
//		WebDriverManager.chromedriver().setup();
//		
//		 driver=new ChromeDriver();
		 
		 /*FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFile.properties");
		 Properties pro=new Properties();
		 pro.load(fis);
		String URL= pro.getProperty("url");
		String Username=pro.getProperty("username");
		String Password=pro.getProperty("password");*/
//		 
//		 Property_Utility plib=new Property_Utility();
//		 String URL=plib.getStringkeyAndValue("url");
//		 String UERNAME=plib.getStringkeyAndValue("username");
//		 String PASSWORD=plib.getStringkeyAndValue("password");
//		
//		driver.get(URL);
//		//driver.manage().window().maximize();
//		Webdriver_Utility wlib=new Webdriver_Utility();
//		wlib.getWindowMax(driver);
//		wlib.getImplicitWait(driver);
		
		/*driver.findElement(By.name("user_name")).sendKeys(UERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
//		LoginPage login=new LoginPage(driver);
//		login.loginToApp(UERNAME, PASSWORD);
		//driver.findElement(By.linkText("Products")).click();
		 Home_Page home=new Home_Page(driver);
		 home.clickProductLink();
		 
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Reusable Method Stored in generic_Utility.
		Java_Utility jlib=new Java_Utility();
		int ranNum=jlib.getRandomNum();
		
		/*FileInputStream fs=new FileInputStream("./src/test/resources/VTExcel.xlsx");
		Workbook book= WorkbookFactory.create(fs);
		Sheet sheet=book.getSheet("product");
		Row row=sheet.getRow(0);
		Cell cel=row.getCell(0);
		String exceldata=cel.getStringCellValue()+ranNum;*/
		
		Excel_Utility elib=new Excel_Utility();
		String Exceldata=elib.getExcelData("Product", 0, 0)+ranNum;
		
//		driver.findElement(By.name("productname")).sendKeys(Exceldata);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Thread.sleep(1200);
		
		ProductCreationPage product=new ProductCreationPage(driver);
		product.clickProductCreationImg();
		product.productNameTextField(Exceldata);
		product.saveButton();
		
		//String actdata=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		//System.out.println(actdata);
		
		/*if(actdata.contains(Exceldata)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}*/
		
		ValidationAndVarificationPage validate=new ValidationAndVarificationPage(driver);
	     validate.productValidation(driver, Exceldata);
		
		
		/*Thread.sleep(1200);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();*/
	     
	   //  home.signoutLink(driver);
		
		
	}

}
