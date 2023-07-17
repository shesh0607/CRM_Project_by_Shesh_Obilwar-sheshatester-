package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidationAndVarificationPage {
	
	public ValidationAndVarificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span.dvHeaderText")
	private WebElement actualcampaignData ;

	public WebElement getActualcampaignData() {
		return actualcampaignData;
	}
	//bussiness logics for campaign
		public void campaignValidation(WebDriver driver,String exceldata)
		{
		String actData = actualcampaignData.getText();
		
		if(actData.contains(exceldata))
		   {
		  	 System.out.println("pass");
		   }
		   else
		   {

		  	 System.out.println("fail");
		   }
		}
	
		@FindBy(xpath="//span[@id='dtlview_Organization Name']")
		private WebElement actualorganizationData;

		public WebElement getActualorganizationData() {
			return actualorganizationData;
		}
		
		//bussiness logics for organization
				public void organizationValidation(WebDriver driver,String exceldata)
				{
				String actData = actualorganizationData.getText();
				
			
				Assert.assertEquals(actData, exceldata);
//				if(actData.contains(exceldata))
//				   {
//				  	 System.out.println("pass");
//				   }
//				   else
//				   {
//
//				  	 System.out.println("fail");
//				   }
				}
				
				@FindBy(xpath="//span[@class='lvtHeaderText']")
				private WebElement actualProductData;

				public WebElement getActualProductData() {
					return actualProductData;
				}
				
				//bussiness logics for product
				public void productValidation(WebDriver driver,String exceldata)
				{
				String actData = actualProductData.getText();
				
				if(actData.contains(exceldata))
				   {
				  	 System.out.println("pass");
				   }
				   else
				   {

				  	 System.out.println("fail");
				   }
				}
				
		
	

}
