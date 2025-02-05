package testscript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends Base {
	@Test (description = " Checking HomePage is Loaded after LogIN with valid credentials")
	public void verifyWheatherTheUserIsAbleToNavigateToTheHomePageafterEnteringCorrectUserNameANDPassword()
	{
		String expectedHomePageDisplayed = "Dashboard";
		String userName = "admin";
		String Password = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(Password); 
		loginpage.clickOnTheSignInButton();
		String actualNavigation = loginpage.homeNavigation();
		assertEquals(expectedHomePageDisplayed,actualNavigation,"HomePage is not loaded after successfull Login");
	}
	
	//@Test(description = "Check the login is not working with valid username and invalid password")
	public void verifyWheatherTheUserIsNotAbleToNavigateToTheHomePageafterEnteringCorrectUserNameANDWrongPassword()
	{
		
		String userName = "admin";
		String Password = "test";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(Password); 
		loginpage.clickOnTheSignInButton();
		boolean invalidMessageDisplay = loginpage.alertPresent();
		assertTrue(invalidMessageDisplay,"User can loggedIn to the homepage with Invalid password and valid username");
		
	}
	
	//@Test(description = "Check wheather the user is not able to loggedIn with Invalid Username and Valid password")
	public void verifyWheatherTheUserIsNotAbleToNavigateToTheHomePageafterEnteringWrongtUserNameANDCorrectPassword()
	{
		String userName = "Test";
		String Password = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(Password); 
		loginpage.clickOnTheSignInButton();
		boolean invalidMessageDisplay = loginpage.alertPresent();
		assertTrue(invalidMessageDisplay,"User can loggedIn to the homepage with Invalid Username and Valid password");
	}
	
	//@Test(description = "Check the user is not able to login in to application with Invalid Username and password")
	public void verifyWheatherTheUserIsNotAbleToNavigateToTheHomePageafterEnteringWrongtUserNameANDWrongPassword()
	{
		String userName = "Test";
		String Password = "Testadmin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(Password); 
		loginpage.clickOnTheSignInButton();
		boolean invalidMessageDisplay = loginpage.alertPresent();
		assertTrue(invalidMessageDisplay,"User can loggedIn to the homepage with Invalid Username and InValid password");
	}
}
