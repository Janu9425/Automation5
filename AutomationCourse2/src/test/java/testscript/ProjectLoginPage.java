package testscript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ProjectLoginPage extends Base {
	
	@Test(description = " Checking HomePage is Loaded after LogIN with valid credentials")
	public void verifyWheatherTheUserIsAbleToNavigateToTheHomePageafterEnteringCorrectUserNameANDPassword()
	{
		String expectedHomePageDisplayed = "Home";
		String expectedUsername = "admin";
		String expectedPassword = "admin";
		WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
		userName.sendKeys(expectedUsername);
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys(expectedPassword );
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		WebElement homeScreenDisplay = driver.findElement(By.xpath("//a[text()='Home']"));
		String actualHomePageNavigation = homeScreenDisplay.getText();
		assertEquals(expectedHomePageDisplayed,actualHomePageNavigation,"HomePage is not loaded after successfull Login");
		
	}
	
	@Test(description = "Check the login is not working with valid username and invalid password")
	public void verifyWheatherTheUserIsNotAbleToNavigateToTheHomePageafterEnteringCorrectUserNameANDWrongPassword()
	{
		
		String expectedUsername = "admin";
		String expectedPassword = "test";
		WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
		userName.sendKeys(expectedUsername);
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys(expectedPassword);
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		WebElement alertDisplay = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean invalidMessage = alertDisplay.isDisplayed();
		assertTrue(invalidMessage,"User can loggedIn to the homepage with Invalid password and valid username");
		
	}
	
	@Test(description = "Check wheather the user is not able to loggedIn with Invalid Username and Valid password")
	public void verifyWheatherTheUserIsNotAbleToNavigateToTheHomePageafterEnteringWrongtUserNameANDCorrectPassword()
	{
		String expectedUsername = "test";
		String expectedPassword = "admin";
		WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
		userName.sendKeys(expectedUsername);
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys(expectedPassword);
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		WebElement alertDisplay = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean invalidMessage = alertDisplay.isDisplayed();
		assertTrue(invalidMessage,"User can loggedIn to the homepage with Invalid Username and Valid password");
	}
	
	@Test(description = "Check the user is not able to login in to application with Invalid Username and password")
	public void verifyWheatherTheUserIsNotAbleToNavigateToTheHomePageafterEnteringWrongtUserNameANDWrongPassword()
	{
		
		String expectedUsername = "Test";
		String expectedPassword = "admintest";
		WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
		userName.sendKeys(expectedUsername);
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys(expectedPassword);
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		WebElement alertDisplay = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean invalidMessage = alertDisplay.isDisplayed();
		assertTrue(invalidMessage,"User can loggedIn to the homepage with Invalid password and Invalid username");

	}
}

