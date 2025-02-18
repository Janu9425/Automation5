package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utility.PageUtility;
import utility.WaitUtility;

public class ManageNewsPage {

public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newsCreateButton;
	@FindBy(xpath = "//textarea[@id='news']") WebElement textenterFieldForNewsCreation;
	@FindBy(xpath = "//button[@type='submit']") WebElement saveButtonForNews;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement successAlertDisplay;
	@FindBy(xpath = "//tr[1]//a[@class=\"btn btn-sm btn btn-danger btncss\"]") WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement deleteSuccessAlertDisplay;

	
	public ManageNewsPage navigateToTheManageNewsPage(String url)
	{
		PageUtility pageutility = new PageUtility();
		pageutility.navigation(driver, url);
		return this;
	}
	
	public ManageNewsPage newButtonClickforNewsCreation()
	{
		newsCreateButton.click();
		return this;
	}
	
	public ManageNewsPage contentAddingForNewsCreation(String text)
	{
	
		textenterFieldForNewsCreation.sendKeys(text);
		return this;
	}
	
	public ManageNewsPage buttonClickForNewsCreation()
	{
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForClick(driver, saveButtonForNews);
		saveButtonForNews.click();
		return this;
	}
	
	public String alertDisplay()
	{
		String messageDisplayed = successAlertDisplay.getText();
		return messageDisplayed;
	}
	
	public ManageNewsPage newsDeleteButtonSelection()
	{
		deleteButton.click();
		return this;
	}
	
	public ManageNewsPage newsDeleting()
	{
		PageUtility pageutility = new PageUtility();
		pageutility.alertPopupAccept(driver);
		return this;
	}
	
	public String deleteAlertDisplay()
	{
		String deletemessageDisplayed = deleteSuccessAlertDisplay.getText();
		return deletemessageDisplayed;
	}
	
	
	
}
