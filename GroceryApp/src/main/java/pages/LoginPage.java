package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@type='text']") WebElement userNameField;
	@FindBy(xpath = "//input[@type='password']") WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']") WebElement Signin;
	@FindBy(xpath = "//li[text()='Dashboard']") WebElement homescreendisplay;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement alertDisplay ;
	
	
	public LoginPage enterUserNameOnUserNameField(String username)
	{
		userNameField.sendKeys(username);
		return this;
	}
	
	public LoginPage enterPasswordOnPasswordField(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
	
	public LoginPage clickOnTheSignInButton()
	{
		Signin.click();
		return this;
	}
	
	public String homeNavigation()
	{
		String actualHomePageNavigation = homescreendisplay.getText();
		return actualHomePageNavigation;
	}
	
	public boolean alertPresent()
	{
		boolean invalidMessage = alertDisplay.isDisplayed();
		return invalidMessage;
	}
}
