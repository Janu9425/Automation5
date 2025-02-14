package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;
import utility.WaitUtility;

public class ManageContactPage {
	public WebDriver driver;
	
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[@role='button']") WebElement contactEditButton ;
	@FindBy (xpath = "//input[@id='phone']") WebElement phoneField ;
	@FindBy (xpath = "//input[@id='email']") WebElement emailField ;
	@FindBy (xpath = "//label[@for='address']//following-sibling::textarea[@placeholder='Enter the Address']") WebElement addressField;
	@FindBy (xpath = "//label[@for='address']//following-sibling::textarea[@placeholder='Enter Delivery Time']") WebElement delivaryTimeField ;
	@FindBy (xpath = "//input[@id='del_limit']") WebElement deliveryChargeTimeField;
	@FindBy (xpath = "//button[@type='submit']") WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement successAlertDisplay;
	
	public void manageContactPageLoad(String Url)
	{
		PageUtility pageutility = new PageUtility();
		pageutility.navigation(driver, Url);
	}
	
	public void contactEditingButtonSelection()
	{
		contactEditButton.click();
	}
	
	public void phoneNumberEditing(String number)
	{
		phoneField.clear();
		phoneField.sendKeys("" +number);
	}
	
	public void emailFieldEditing(String email)
	{
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	public void addressFieldEditing(String address)
	{
		addressField.clear();
		addressField.sendKeys(address);
	}
	
	public void deliveryTimeEditing(String deliveryTime)
	{
		delivaryTimeField.clear();
		delivaryTimeField.sendKeys("" +deliveryTime);
	}
	
	public void pagescrollingdown()
	{
		PageUtility pageutility = new PageUtility();
		pageutility.completeScrollDown(driver);
	}
	
	public void deliveryChargeEditing(String deliverychargeTime)
	{
		deliveryChargeTimeField.clear();
		deliveryChargeTimeField.sendKeys("" +deliverychargeTime);
	}
	
	public void contactUpdate()
	{
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElement(driver, updateButton);
		updateButton.click();
	}
	
	public String alertdisplay()
	{
		String alertDisplayfromScreen = successAlertDisplay.getText();
		System.out.println(alertDisplayfromScreen);
		return alertDisplayfromScreen;
	}
	
	
}
