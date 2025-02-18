package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoryPage;
import retry.Retry;
import utility.ExcelUtility;

public class SubCategoryTest extends Base {
	@Test(description = "check user can create subcategory" , retryAnalyzer = Retry.class)
	public void verifyWheatherUserCanCreateNewSubCategory()
	{
	String userName = ExcelUtility.getString(1, 0, "LoginPage");
	String Password = ExcelUtility.getString(1, 1, "LoginPage");
	String expectedAlertMessageForUserCreate =ExcelUtility.getString(1, 0, "SubCategoryPage");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(Password).clickOnTheSignInButton();
	SubCategoryPage subcategorypage = new SubCategoryPage(driver);
	subcategorypage.selctionOfSubCategoryPage();
	subcategorypage.selectionfSubCategoryCreateButton().categorySelectedFromDropDown().enteringSubcategoryName().imageuploadingForSubCategoryCreate().buttonClickForCreatingSubCategory();
	String actualAlertMessageForUserCreate=subcategorypage.alertdisplay();
	assertEquals(actualAlertMessageForUserCreate,expectedAlertMessageForUserCreate,"SubCategory not created successfully and not displayed in the subcategorylist");	
	}
	

}
