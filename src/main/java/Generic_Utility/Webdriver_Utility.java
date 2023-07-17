package Generic_Utility;

import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_Utility {
	
	public void getWindowMax(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void getImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void getPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

	public void switchingWindow(WebDriver driver,String partialText)
	{
		Set<String> allwin1=driver.getWindowHandles();
		Iterator<String> id1=allwin1.iterator();
		while(id1.hasNext()) {
			String wid1=id1.next();
			driver.switchTo().window(wid1);
			
			String title=driver.getTitle();
			if(title.contains("Campaigns&action")) 
			{
				break;
			}
				
		}
	}
	
	public void alertAccept(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	
	public void alertDismiss(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	
	/**
	 * used to switch to frame window based on Index
	 * @param driver
	 * @param index
	 * @author Shesh
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
		}
	/**
	 * 
	 * used to switch to frame window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 * @author Shesh
	 */
	public void switchToFrame(WebDriver driver,String id_name_Attribute)
	{
	driver.switchTo().frame(id_name_Attribute);	
	}
	
	/**
	 * used to select the value from the dropDown based on index
	 * @param element
	 * @param index
	 * @author shesh
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the dropDown based on text
	* @param element
	 * @param text
	 * @author shesh
	 */
	public void select(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 * @author shesh
	 * 
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/**
	 * used to right click on specific element
	 * @param driver
	 * @param element
	 * @author shesh
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void moveByOffest(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
	public  String takeScreenshot(WebDriver sDriver, String methodName) {
		
		Date date=new Date();
		date.toString().replace(" "," ").replace(":","-");
		//TakesScreenshot ts=(TakesScreenshot)driver;
		return null;
	}
}
