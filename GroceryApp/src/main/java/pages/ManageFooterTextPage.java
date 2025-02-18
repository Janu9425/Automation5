package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;
import utility.WaitUtility;

public class ManageFooterTextPage {
public WebDriver driver;
	
	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=2']") WebElement footerTextEditButton ;
	@FindBy (xpath = "//input[@id='phone']") WebElement phoneField ;
	@FindBy (xpath = "//input[@id='email']") WebElement emailField ;
	@FindBy (xpath = "//div[@class='form-group']//following-sibling::textarea[@id='content']") WebElement addressField;
	@FindBy (xpath = "//button[@type='submit']") WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement successAlertDisplay;
	
	public ManageFooterTextPage manageFooterTextPageLoad(String Url)
	{
		PageUtility pageutility = new PageUtility();
		pageutility.navigation(driver, Url);
		return this;
	}
	
	public ManageFooterTextPage contactEditingButtonSelection()
	{
		footerTextEditButton.click();
		return this;
	}

	public ManageFooterTextPage addressFieldEditing(String address)
	{
		addressField.clear();
		addressField.sendKeys(address);
		return this;
	}
	
	public ManageFooterTextPage emailFieldEditing(String email)
	{
		emailField.clear();
		emailField.sendKeys(email);
		return this;
	}
	
	public ManageFooterTextPage phoneNumberEditing(String number)
	{
		phoneField.clear();
		phoneField.sendKeys("" +number);
		return this;
	}
	
	public ManageFooterTextPage pagescrollingdown()
	{
		PageUtility pageutility = new PageUtility();
		pageutility.completeScrollDown(driver);
		return this;
	}
	
	public ManageFooterTextPage footerTextUpdate()
	{
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElement(driver, updateButton);
		updateButton.click();
		return this;
	}
	
	public String alertdisplay()
	{
		String alertDisplayfromScreen = successAlertDisplay.getText();
		return alertDisplayfromScreen;
	}
	
	
}
