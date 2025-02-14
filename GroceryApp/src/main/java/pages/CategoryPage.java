package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utility.FileUpLoadUtility;
import utility.PageUtility;
import utility.RandomUtility;
import utility.WaitUtility;

public class CategoryPage {
	public WebDriver driver;
	
	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newCategoryCreateButton;
	@FindBy(xpath ="//input[@class='form-control']")WebElement categoryLableName;
	@FindBy(xpath = "//li[@id='134-selectable']") WebElement groupSelection;
	@FindBy(xpath = "//input[@name='main_img']") WebElement fileChoose;
	@FindBy(xpath = "//label[text()='Show On Top Menu']//following-sibling::label//child::input[@value='no']") WebElement selctionofTopMenu;
	@FindBy(xpath = "//button[@type='submit']") WebElement categorySave;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement successAlertDisplay;
	
	
	public void categoryTabSelection(String url)
	{
		PageUtility pageutility = new PageUtility();
		pageutility.navigation(driver, url);
	}
	
	public void categoryCreateButtonselection()
	{
		newCategoryCreateButton.click();
	}
	
	public void enterCategoryName()
	{
		RandomUtility randomutility = new RandomUtility();
		String fakerCategoryName = randomutility.createCategoryName();
		categoryLableName.sendKeys(fakerCategoryName);
	}
	
	public void selectingTheGroupsForCategoryDisplay()
	{
		groupSelection.click();
		PageUtility pageutility = new PageUtility();
		pageutility.scrollTODown(driver);
	
	}
	
	public void fileUploadforCategoryCreate()
	{
		FileUpLoadUtility fileuploadutility = new FileUpLoadUtility();
		fileuploadutility.FileUploadUsingSendKeys(fileChoose, Constants.TESTIMAGEFILE1);
		
	}
	
	public void selectionofCategoryDisplayinTopMenu()
	{
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForClick(driver, selctionofTopMenu);
		selctionofTopMenu.click();
	}
	
	public void pagescrollingdown()
	{
		PageUtility pageutility = new PageUtility();
		pageutility.completeScrollDown(driver);
	}
	
	public void createdCategorySavingtoTheList()
	{
		
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElement(driver, categorySave);
		categorySave.click();
	}
	
	public String alertDisplay() 
	{
		String messageDisplayed = successAlertDisplay.getText();
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForTextPresentInElement(driver, successAlertDisplay, messageDisplayed);
		return messageDisplayed;
	}
}
