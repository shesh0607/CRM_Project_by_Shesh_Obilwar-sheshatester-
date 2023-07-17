package Generic_Utility;

import java.io.IOException;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM_Repo.Home_Page;
import POM_Repo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	@BeforeSuite(groups= {"smokeTest","RegressionTest"})
	public void BS() 
	{
	  System.out.println("Database connection");	
	}
	
	@BeforeTest
	public void BT()
	{
		System.out.println("Parallel execution");
	}
	//@Parameters("BROWSER")
	@BeforeClass
	public void BC() throws IOException
	//public void BC(String BROWSER) throws IOException 
	{
		Property_Utility plib=new Property_Utility();
		 
		String BROWSER=plib.getStringkeyAndValue("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
	    {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase(BROWSER))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		sdriver=driver;
		System.out.println("Launching the browser");
		
   }
	@BeforeMethod
	public void BM() throws IOException

	{
		
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.getWindowMax(driver);
		wlib.getImplicitWait(driver);
		LoginPage login=new LoginPage(driver);
		Property_Utility plib=new Property_Utility();
		 String URL=plib.getStringkeyAndValue("url");
		 String UERNAME=plib.getStringkeyAndValue("username");
		 String PASSWORD=plib.getStringkeyAndValue("password");
		 driver.get(URL);
		login.loginToApp(UERNAME, PASSWORD);
		
		System.out.println("Login to Application");
	}
	
	@AfterMethod
	public void AM()
	{
		Home_Page home=new Home_Page(driver);
		home.signoutLink(driver);
	     
		System.out.println("logout from application");
	}
	
	@AfterClass
	public void AC()
	{
		System.out.println("close the browser");
	}

	@AfterTest
	public void AT()
	{
		System.out.println("Parallel Execution done");
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("close DataBase connection");
	}
}
