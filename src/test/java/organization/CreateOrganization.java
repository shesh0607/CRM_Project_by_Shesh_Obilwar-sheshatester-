package organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM_Repo.Home_Page;
import POM_Repo.LoginPage;
import POM_Repo.OrnanizationCreationPage;
import POM_Repo.ValidationAndVarificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(Generic_Utility.ListenersImpl.class)//to take the screen shots
public class CreateOrganization extends BaseClass {
@Test(retryAnalyzer=Generic_Utility.RetryAnalyzerImple.class)
//(groups={"smokeTest"})
	public void createOrganization() throws IOException {
//		
//		WebDriver driver;
//		
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
		
//		Property_Utility plib=new Property_Utility();
//		 String URL=plib.getStringkeyAndValue("url");
//		 String UERNAME=plib.getStringkeyAndValue("username");
//		 String PASSWORD=plib.getStringkeyAndValue("password");
		
//		driver.get(URL);
//		Webdriver_Utility wlib=new Webdriver_Utility();
//		wlib.getWindowMax(driver);
//		wlib.getImplicitWait(driver);
//		
//		LoginPage login=new LoginPage(driver);
//		login.loginToApp(UERNAME, PASSWORD);
		
		 Home_Page home=new Home_Page(driver);
	        home.clickOnganizationsLinkText();
		
		//Reusable Method Stored in generic_Utility.
				Java_Utility jlib=new Java_Utility();
				int ranNum=jlib.getRandomNum();
				
				
				Excel_Utility elib=new Excel_Utility();
				String exceldata=elib.getExcelData("organizations", 0, 0)+ranNum;
				
	    OrnanizationCreationPage org=new OrnanizationCreationPage(driver);
         org.clickOrganizationCreateImage();
         org.organizationNamesTextField(exceldata);
	     org.saveButton();
				
	    
	     ValidationAndVarificationPage validate=new ValidationAndVarificationPage(driver);
	     validate.organizationValidation(driver, exceldata);
		

	}

}
