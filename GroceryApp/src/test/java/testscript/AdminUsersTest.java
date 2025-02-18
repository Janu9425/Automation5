package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


import pages.AdminUsersPage;
import pages.LoginPage;
import retry.Retry;
import utility.ExcelUtility;

public class AdminUsersTest extends Base {
	
	@Test(description = "Check the new admin user is created" , priority = 2 , retryAnalyzer = Retry.class)
		public void verifyWheatherNewAdminUserCanCreate()
		{
			String userName = ExcelUtility.getString(1, 0, "LoginPage");
			String Password = ExcelUtility.getString(1, 1, "LoginPage");
			String username =ExcelUtility.getString(8, 0, "AdminUsersPage");
			String expectedAlertMessageForUserCreate = ExcelUtility.getString(2, 1, "AdminUsersPage");
			String password =ExcelUtility.getIntegerData(1, 2, "AdminUsersPage");
			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).clickOnTheSignInButton();
			AdminUsersPage adminpage = new AdminUsersPage(driver);
			adminpage.clickOnAdminUserInfoPage();
			adminpage.newAdminUserCreateButtonSelection().createNewAdminUserName(username).createNewAdminUserPassword(password).typeSelectionFromDropDown().newAdminUserCreation();
			String actualAlertMessageForUserCreate=adminpage.alertdisplay();
			assertEquals(expectedAlertMessageForUserCreate,actualAlertMessageForUserCreate,"User not created successfully");
		}
	
	@Test(description = "Verify wheather the user can be selected" ,priority = 1 , retryAnalyzer = Retry.class)
	public void verifyWheathertheEntiredUserIsDisplayedFromList()
	{
		String searchUsername = ExcelUtility.getString(1, 3, "AdminUsersPage");
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String Password = ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(Password).clickOnTheSignInButton();
		AdminUsersPage adminpage = new AdminUsersPage(driver);
		adminpage.clickOnAdminUserInfoPage();
		adminpage.searchButtonClick().searchAdminUserName(searchUsername).searchtypeSelectionFromDropDown().searchUserCreated();
		String actualSearchedResultFromTable=adminpage.searchedResultFromTable();
		assertEquals(actualSearchedResultFromTable, searchUsername, "The usernames listed on the table is not according to the searched username");
		
		
	}
	@Test (description = "Check new user can create with faker" , priority = 3 , retryAnalyzer = Retry.class)
	public void verifyNewAdminUserCanCreateWithFaker()
	{
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String Password = ExcelUtility.getString(1, 1, "LoginPage");
		String expectedAlertMessageForUserCreate = ExcelUtility.getString(2, 1, "AdminUsersPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(Password).clickOnTheSignInButton();
		AdminUsersPage adminpage = new AdminUsersPage(driver);
		adminpage.clickOnAdminUserInfoPage();
		adminpage.newAdminUserCreateButtonSelection().createFakerUserNameForNewAdminUserCreate().createFakerPassWordForNewAdminCreate().typeSelectionFromDropDown().newAdminUserCreation();
		String actualAlertMessageForUserCreate=adminpage.alertdisplay();
		assertEquals(actualAlertMessageForUserCreate,expectedAlertMessageForUserCreate,"User not created successfully");
	}
	
	
}
