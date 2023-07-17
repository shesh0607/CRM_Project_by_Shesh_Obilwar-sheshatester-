package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreationPage {
	
	public ProductCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement produtCreationImg;
	
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getProdutCreationImg() {
		return produtCreationImg;
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSavebtn() {
		return saveButton;
	}
	
	public void clickProductCreationImg() {
		produtCreationImg.click();
	}
	
	public void productNameTextField(String productname) {
		
		 productNameTextField.sendKeys(productname);
	}
	
	public void saveButton()
	{
		saveButton.click();	
	}
	

}
