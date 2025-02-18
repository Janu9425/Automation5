package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageFooterTextPage;
import retry.Retry;
import utility.ExcelUtility;

@Test (description = "Check the User can Update the Manage Footer Text Page " , retryAnalyzer = Retry.class)
public class ManageFooterTextTest extends Base {
	public void verifytheUserIsAbleToEditTheManageFooterText()
	{
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String Password = ExcelUtility.getString(1, 1, "LoginPage");
		String Url = ExcelUtility.getString(1, 0, "ManageFooterTextPage");
		String address = ExcelUtility.getString(1, 1, "ManageFooterTextPage");
		String email = ExcelUtility.getString(1, 2, "ManageFooterTextPage");
		String number = ExcelUtility.getIntegerData(1, 3, "ManageFooterTextPage");
		String expectedAlertMessageForUserCreate = ExcelUtility.getString(1, 4, "ManageFooterTextPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(Password).clickOnTheSignInButton();
		ManageFooterTextPage managecontactpage = new ManageFooterTextPage(driver);
		managecontactpage.manageFooterTextPageLoad(Url).contactEditingButtonSelection().addressFieldEditing(address).emailFieldEditing(email).phoneNumberEditing(number).pagescrollingdown().footerTextUpdate();
		String actualAlertMessageForUserCreate= managecontactpage.alertdisplay();
		assertEquals(expectedAlertMessageForUserCreate,actualAlertMessageForUserCreate,"User cann't able to update the Manage Footer Text");
		
	}
}
