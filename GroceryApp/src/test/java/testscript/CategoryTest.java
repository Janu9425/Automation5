package testscript;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.CategoryPage;
import pages.LoginPage;
import retry.Retry;
import utility.ExcelUtility;

public class CategoryTest extends Base {
	@Test (description = "check the user can create a new category" , retryAnalyzer = Retry.class)
	public void verifyWheathertheUserCanCreateACategory()
	{
		String expectedAlertMessageForUserCreate = ExcelUtility.getString(1, 0, "CategoryPage");
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String Password = ExcelUtility.getString(1, 1, "LoginPage");
		String url = ExcelUtility.getString(1, 1, "CategoryPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(Password); 
		loginpage.clickOnTheSignInButton();
		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.categoryTabSelection(url);
		categorypage.categoryCreateButtonselection();
		categorypage.enterCategoryName();
		categorypage.selectingTheGroupsForCategoryDisplay();
		categorypage.fileUploadforCategoryCreate();
		categorypage.selectionofCategoryDisplayinTopMenu();
		categorypage.pagescrollingdown();
		categorypage.createdCategorySavingtoTheList();
		String actualAlertMessage=categorypage.alertDisplay();
		assertEquals(actualAlertMessage, expectedAlertMessageForUserCreate,"Category is not created and it is not displayed in the list");
	}
}