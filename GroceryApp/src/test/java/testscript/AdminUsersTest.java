package testscript;

import org.testng.annotations.Test;

import pages.AdminUsersPage;

public class AdminUsersTest extends LoginTest {
	
	@Test (description = "Check the admin user creation is working")
	public void verifyWheatherNewAdminUserCanCreate()
	{
		AdminUsersPage adminuserpage = new AdminUsersPage(driver);
		adminuserpage.clickOnAdminUserInfoPage();
	}

}
