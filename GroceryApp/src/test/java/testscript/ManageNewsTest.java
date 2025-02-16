package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import retry.Retry;
import utility.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test (description = "Check new news can add to the list" , retryAnalyzer = Retry.class)
	public void verifyThatnewUserCanAddNewNews()
	{
		String text = ExcelUtility.getString(1, 2, "ManageNewsPage");
		String expectedAlertMessageForUserCreate = ExcelUtility.getString(1, 1, "ManageNewsPage");
		String url = ExcelUtility.getString(1, 0, "ManageNewsPage");
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String Password = ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(Password); 
		loginpage.clickOnTheSignInButton();
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.navigateToTheManageNewsPage(url);
		managenewspage.newButtonClickforNewsCreation();
		managenewspage.contentAddingForNewsCreation(text);
		managenewspage.buttonClickForNewsCreation();
		String actualAlertMessage = managenewspage.alertDisplay();
		assertEquals(actualAlertMessage, expectedAlertMessageForUserCreate,"News is not created and it is not displayed in the list");

	}
	
	@Test (description = " Check the user is able to delete News" , retryAnalyzer = Retry.class)
	public void verifyWheathertheUserIsAbleToDeleteTheNewsFromTheList()
	{
		String url = ExcelUtility.getString(1, 0, "ManageNewsPage");
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String Password = ExcelUtility.getString(1, 1, "LoginPage");
		String expectedAlertMessageForUserCreate = ExcelUtility.getString(1, 3, "ManageNewsPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(Password); 
		loginpage.clickOnTheSignInButton();
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.navigateToTheManageNewsPage(url);
		managenewspage.newsDeleteButtonSelection();
		managenewspage.newsDeleting();
		String actualAlertMessage = managenewspage.deleteAlertDisplay();
		assertEquals(actualAlertMessage, expectedAlertMessageForUserCreate,"User cann't delete a news from the news list");
		
	}

}
