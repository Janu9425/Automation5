package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import retry.Retry;
import utility.ExcelUtility;

public class ManageContactTest extends Base {
	@Test (description = "Check the user can edit the contact details" , retryAnalyzer = Retry.class)
	public void verifytheUserIsAbleToEditTheContact()
	{
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String Password = ExcelUtility.getString(1, 1, "LoginPage");
		String Url = ExcelUtility.getString(1, 0, "ManageContactPage");
		String number = ExcelUtility.getIntegerData(1, 1, "ManageContactPage");
		String email = ExcelUtility.getString(1, 2, "ManageContactPage");
		String address = ExcelUtility.getString(1, 3, "ManageContactPage");
		String deliveryTime = ExcelUtility.getIntegerData(1, 4, "ManageContactPage");
		String deliverychargeTime = ExcelUtility.getIntegerData(1, 5, "ManageContactPage");
		String expectedAlertMessageForUserCreate = ExcelUtility.getString(1, 6, "ManageContactPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(Password).clickOnTheSignInButton();
		ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage.manageContactPageLoad(Url).contactEditingButtonSelection().phoneNumberEditing(number).emailFieldEditing(email).addressFieldEditing(address).deliveryTimeEditing(deliveryTime).pagescrollingdown().deliveryChargeEditing(deliverychargeTime).contactUpdate();
		String actualAlertMessageForUserCreate= managecontactpage.alertdisplay();
		assertEquals(expectedAlertMessageForUserCreate,actualAlertMessageForUserCreate,"Contact not updated properly");
		
	}
}
