package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utility.PageUtility;
import utility.RandomUtility;
import utility.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//child::i[@class='fas fa-arrow-circle-right']") WebElement adminInfoPage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newAdminUserCreateButton;
	@FindBy(xpath = "//input[@id='username']") WebElement newAdminUserNameField;
	@FindBy(xpath = "//input[@id='password']") WebElement newAdminUserPasswordField;
	@FindBy(xpath = "//select[@id='user_type']") WebElement typeDropDownSelection;
	@FindBy(xpath = "//button[@name='Create']") WebElement newAdminUserCreateSaveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertSuccessDisplay;
	@FindBy(xpath = "//button[@class='close']") WebElement closeAlertSuccessDisplay;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement searchButtonSelection;
	@FindBy(xpath = "//input[@id='un']") WebElement searchAdminUserNameField;
	@FindBy(xpath = "//select[@id='ut']") WebElement searchTypeDropDownSelection;
	@FindBy(xpath = "//button[@name='Search']") WebElement searchUserSelected;
	@FindBy(xpath = "/html/body/div/div[1]/section/div[2]/div/div[3]/div[2]/table/thead/tr/th[1]") WebElement tableColumn;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr//td") WebElement tableResult;
	
	public void clickOnAdminUserInfoPage() 
	{
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForClick(driver, adminInfoPage);
		adminInfoPage.click();
	}
	
	
	public AdminUsersPage newAdminUserCreateButtonSelection()
	{
		newAdminUserCreateButton.click();
		return this;
	}
	
	public AdminUsersPage createNewAdminUserName(String username)
	{
		newAdminUserNameField.sendKeys(username);
		return this;
	}
	
	public AdminUsersPage createFakerUserNameForNewAdminUserCreate()
	{
		RandomUtility randomutility = new RandomUtility();
		String fakerUsername =randomutility.createNewFakerUserName();
		newAdminUserNameField.sendKeys(fakerUsername);
		return this;
	}
	
	public AdminUsersPage createNewAdminUserPassword(String userpassword)
	{
		newAdminUserPasswordField.sendKeys("" +userpassword);
		return this;
	}
	
	public AdminUsersPage createFakerPassWordForNewAdminCreate()
	{
		RandomUtility randomutility = new RandomUtility();
		long fakerPassword=randomutility.createNewFakerPassword();
		newAdminUserPasswordField.sendKeys("" +fakerPassword);
		return this;
	}
	
	public AdminUsersPage typeSelectionFromDropDown()
	{
		PageUtility pageutility = new PageUtility();
		pageutility.selectValueFromDropDownUsingIndex(typeDropDownSelection, 1);
		return this;
	}
	
	public AdminUsersPage newAdminUserCreation()
	{
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForClick(driver, newAdminUserCreateSaveButton);
		newAdminUserCreateSaveButton.click();
		return this;
	}
	
	public String alertdisplay()
	{
		String alertDisplayfromScreen = alertSuccessDisplay.getText();
		return alertDisplayfromScreen;
	}
	
	public void alertClick()
	{
		closeAlertSuccessDisplay.click();
	}
	
	public AdminUsersPage searchButtonClick()
	{
		searchButtonSelection.click();
		return this;
	}
	
	public AdminUsersPage searchAdminUserName(String searchUsername)
	{
		searchAdminUserNameField.sendKeys(searchUsername);
		return this;
	}
	
	public AdminUsersPage searchtypeSelectionFromDropDown()
	{
	Select select = new Select(searchTypeDropDownSelection); 
	select.selectByIndex(1);
	return this;
	}
	
	public AdminUsersPage searchUserCreated()
	{
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForClick(driver, searchUserSelected);
		searchUserSelected.click();
		return this;
	}
	
	public String searchedResultFromTable()
	{
		String searchedResult = tableResult.getText();
		return searchedResult;
	}

}
