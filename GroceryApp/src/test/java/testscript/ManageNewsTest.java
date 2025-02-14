package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test (description = "Check new news can add to the list")
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

}
