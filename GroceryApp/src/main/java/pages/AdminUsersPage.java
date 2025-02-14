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
	
	
	public void newAdminUserCreateButtonSelection()
	{
		newAdminUserCreateButton.click();
	}
	
	public void createNewAdminUserName(String username)
	{
		newAdminUserNameField.sendKeys(username);
	}
	
	public void createFakerUserNameForNewAdminUserCreate()
	{
		RandomUtility randomutility = new RandomUtility();
		String fakerUsername =randomutility.createNewFakerUserName();
		newAdminUserNameField.sendKeys(fakerUsername);
	}
	
	public void createNewAdminUserPassword(String userpassword)
	{
		newAdminUserPasswordField.sendKeys("" +userpassword);
	}
	
	public void createFakerPassWordForNewAdminCreate()
	{
		RandomUtility randomutility = new RandomUtility();
		long fakerPassword=randomutility.createNewFakerPassword();
		newAdminUserPasswordField.sendKeys("" +fakerPassword);
	}
	
	public void typeSelectionFromDropDown()
	{
		PageUtility pageutility = new PageUtility();
		pageutility.selectValueFromDropDownUsingIndex(typeDropDownSelection, 1);
	}
	
	public void newAdminUserCreation()
	{
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForClick(driver, newAdminUserCreateSaveButton);
		newAdminUserCreateSaveButton.click();
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
	
	public void searchButtonClick() {
		searchButtonSelection.click();
	}
	
	public void searchAdminUserName(String searchUsername)
	{
		searchAdminUserNameField.sendKeys(searchUsername);
	}
	
	public void searchtypeSelectionFromDropDown()
	{
	Select select = new Select(searchTypeDropDownSelection); 
	select.selectByIndex(1);
	}
	
	public void searchUserCreated()
	{
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForClick(driver, searchUserSelected);
		searchUserSelected.click();
	}
	
	public String searchedResultFromTable()
	{
		String searchedResult = tableResult.getText();
		return searchedResult;
	}

}
