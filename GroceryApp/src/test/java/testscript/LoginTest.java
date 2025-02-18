package testscript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import retry.Retry;
import utility.ExcelUtility;

public class LoginTest extends Base {
	@Test (description = " Checking HomePage is Loaded after LogIN with valid credentials" , groups = ("smoke") , retryAnalyzer = Retry.class)
	public void verifyWheatherTheUserIsAbleToNavigateToTheHomePageafterEnteringCorrectUserNameANDPassword()
	{
		String expectedHomePageDisplayed = "Dashboard";
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String Password = ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(Password).clickOnTheSignInButton();
		String actualNavigation = loginpage.homeNavigation();
		assertEquals(expectedHomePageDisplayed,actualNavigation,"HomePage is not loaded after successfull Login");
	}
	
	
	@Test(description = "Check the login is not working with valid username and invalid password" , groups = ("regression") , retryAnalyzer = Retry.class)
	public void verifyWheatherTheUserIsNotAbleToNavigateToTheHomePageafterEnteringCorrectUserNameANDWrongPassword()
	{
		
		String userName = ExcelUtility.getString(2, 0, "LoginPage");
		String Password = ExcelUtility.getString(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(Password).clickOnTheSignInButton();
		boolean invalidMessageDisplay = loginpage.alertPresent();
		assertTrue(invalidMessageDisplay,"User can loggedIn to the homepage with Invalid password and valid username");
		
	}
	
	@Test(description = "Check wheather the user is not able to loggedIn with Invalid Username and Valid password" , groups = ("regression") , retryAnalyzer = Retry.class)
	public void verifyWheatherTheUserIsNotAbleToNavigateToTheHomePageafterEnteringWrongtUserNameANDCorrectPassword()
	{
		String userName = ExcelUtility.getString(3, 0, "LoginPage");
		String Password = ExcelUtility.getString(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(Password).clickOnTheSignInButton();
		boolean invalidMessageDisplay = loginpage.alertPresent();
		assertTrue(invalidMessageDisplay,"User can loggedIn to the homepage with Invalid Username and Valid password");
	}
	
	@Test(description = "Check the user is not able to login in to application with Invalid Username and password" , dataProvider = "LoginProvider"  , retryAnalyzer = Retry.class)
	public void verifyWheatherTheUserIsNotAbleToNavigateToTheHomePageafterEnteringWrongtUserNameANDWrongPassword(String userName , String Password)
	{
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(Password).clickOnTheSignInButton();
		boolean invalidMessageDisplay = loginpage.alertPresent();
		assertTrue(invalidMessageDisplay,"User can loggedIn to the homepage with Invalid Username and InValid password");
	}
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { ExcelUtility.getString(4, 0, "LoginPage"), ExcelUtility.getString(4, 1, "LoginPage") },
			{"adc","abc"},
			{"hello","heloo3456"}

		};
}
}
