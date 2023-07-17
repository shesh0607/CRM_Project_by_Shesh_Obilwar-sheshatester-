package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM_Repo.CampaignCreationPage;
import POM_Repo.Home_Page;
import POM_Repo.LoginPage;
import POM_Repo.ValidationAndVarificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaign extends BaseClass {
    @Test(groups={"smokeTest","RegressionTest"})
	public void createCampaign() throws EncryptedDocumentException, IOException {
//		WebDriver driver;
//		
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
		
//		FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFile.properties");
//		Properties pro=new Properties();
//		pro.load(fis);
//		String URL=pro.getProperty("url");
//		String Username=pro.getProperty("username");
//		String Password=pro.getProperty("password");
		
//		Property_Utility plib=new Property_Utility();
//		 String URL=plib.getStringkeyAndValue("url");
//		 String UERNAME=plib.getStringkeyAndValue("username");
//		 String PASSWORD=plib.getStringkeyAndValue("password");
//		
//		 driver.get(URL);
//		LoginPage login=new LoginPage(driver);
//		login.loginToApp(UERNAME, PASSWORD);
//		
//		Webdriver_Utility wlib=new Webdriver_Utility();
//		wlib.getWindowMax(driver);
//		wlib.getImplicitWait(driver);
		
	
//		driver.manage().window().maximize();
//		driver.findElement(By.name("user_name")).sendKeys(UERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		
		
		Home_Page hp=new Home_Page(driver);
		hp.moreLink(driver);
		hp.campaignLinkText();
		
		
//		driver.findElement(By.linkText("More")).click();
//		driver.findElement(By.linkText("Campaigns")).click();
		
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		

		//Reusable Method Stored in generic_Utility.
		Java_Utility jlib=new Java_Utility();
		int ranNum=jlib.getRandomNum();
		
//		FileInputStream fs=new FileInputStream("./src/test/resources/VTExcel.xlsx");
//		Workbook book=WorkbookFactory.create(fs);
//		Sheet sheet=book.getSheet("campaign") ;
//		Row row=sheet.getRow(0);
//		Cell cell=row.getCell(0);
//		String Exceldata= cell.getStringCellValue()+ranNum;

		Excel_Utility elib=new Excel_Utility();
		String Exceldata=elib.getExcelData("campaign", 0, 0)+ranNum;
		
		CampaignCreationPage camp=new CampaignCreationPage(driver);
		camp.clickcampaignCreateImage();
		camp.campaignNamesTextField(Exceldata);
		camp.saveButton();
		
		//driver.findElement(By.name("campaignname")).sendKeys(Exceldata);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/* String actdata=driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		 System.out.println(actdata);
		 
		 if(actdata.contains(Exceldata))
		 {
			 System.out.println("Pass");
		 }
		 else
		 {
			 System.out.println("Fail");
			
		 }*/
		
		ValidationAndVarificationPage val=new ValidationAndVarificationPage(driver);
		 val.campaignValidation(driver, Exceldata);
		 Assert.assertEquals(driver, Exceldata);
		// hp.signoutLink(driver);
		
		 
//		Actions act=new Actions(driver);
//		 act.moveToElement(data).perform();
//		  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		  Thread.sleep(1000);
//		 driver.findElement(By.linkText("Sign Out")).click();
	}

}
