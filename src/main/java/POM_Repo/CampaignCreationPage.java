package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreationPage {
	

	public CampaignCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    //Declaration
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement campaignCreateImage;
	
	@FindBy(name="campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getCampaignCreateImage() {
		return campaignCreateImage;
	}

	public WebElement getCampaignNameTextfield() {
		return campaignNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This Method is used for ClickOn +img
	 */
	public void clickcampaignCreateImage()
	{
		campaignCreateImage.click();
	}

	/**
	 * This Method is used to Pass Value to Organization TextField
	 */
	public void campaignNamesTextField(String campName)
	{
		campaignNameTextField.sendKeys(campName);
	}
	/**
	 * This Method is used to Save campignName
	 */

	public void saveButton()
	{
		saveButton.click();	
	}

	
	
	

}
