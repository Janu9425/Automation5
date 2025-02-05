package testscript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Ascertion extends BaseTestNG{
	@Test(description = "Checking the Background Color of the Showmessage Button")
	public void verifyTheBackGroundColorOfShowMessageButton() {
		String expectedShowMessageButtonColor = "rgba(0, 123, 255, 1)";

		WebElement showMessagebutton = driver.findElement(By.xpath("//button[@id='button-one']"));
		String actualBackgroundcolor=showMessagebutton.getCssValue("background-color");
		assertEquals(expectedShowMessageButtonColor,actualBackgroundcolor,"Expected Background Color is  "+ expectedShowMessageButtonColor + "But it is " + actualBackgroundcolor);
		
	}
	@Test(description = "ShowMessage button is available in home page")
	public void verifyWheatherTheShowMessageButtonISAvailableInTheHomePage()
	{
		WebElement showMessagebutton = driver.findElement(By.xpath("//button[@id='button-one']"));
		boolean isShowMessageButtonDisplayed = showMessagebutton.isDisplayed();//display avundo visible avundo ennu nokan ulla method
		assertTrue(isShowMessageButtonDisplayed,"Show Message button is not available");
	}
	
	@Test(description = "Checking the Your Message Text displayed in the Single Input Field is correct or not ")
	public void verifyTheSingleInputField()
	{

		WebElement singleInputField = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		String expectedInputValue = "hello";
		singleInputField.sendKeys(expectedInputValue);
		WebElement showMessagebutton = driver.findElement(By.xpath("//button[@id='button-one']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));// syntax of explicit
		wait.until(ExpectedConditions.elementToBeClickable(showMessagebutton));//same this is also for syntax complete
		showMessagebutton.click();
		boolean isShowMessageButtonEnabled =showMessagebutton.isEnabled();
		boolean isShowMessageIsDiplsayed=showMessagebutton.isDisplayed();
		WebElement yourMessage = driver.findElement(By.xpath("//div[@id='message-one']"));
		String yourMessageText =yourMessage.getText();
		String actualYourMessageText =yourMessageText.substring(15);
		assertEquals(expectedInputValue,actualYourMessageText,"The text displayed after the your message is " + expectedInputValue + " but it is " + actualYourMessageText);
		
	}
	
	
	@Test(description = "Verify wheather the male option is selected when we click on male radio button")
	public void verifyTheUserIsAbleToSelectMaleOption()
	{
		String expectedMessage = "Radio button 'Male' is checked" ;
		driver.navigate().to("https://selenium.qabible.in/radio-button-demo.php");
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='inlineRadio1']")));
		
		WebElement  radioButtonMale =driver.findElement(By.xpath("//input[@id='inlineRadio1']"));	
		WebElement radioButtonFemale = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		boolean maleRadioButtonUnSelected= radioButtonMale.isSelected();
		boolean femaleRadioButtonUnSelected = radioButtonFemale.isSelected();
	/*	if(radioButtonMale.isSelected()==false && radioButtonFemale.isSelected()==false)
		{
			System.out.println("Male & Female Radio Buttons are disabled");
		}
		else
		{
			System.out.println("Male & Female Radio Buttons are enabled");
		}*/
		
		assertFalse(maleRadioButtonUnSelected,"Male & Female Radio Buttons are enabled");
		assertFalse(femaleRadioButtonUnSelected,"Male & Female Radio Buttons are enabled");
		
		WebElement  maleRadioButtonSelection =driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		maleRadioButtonSelection.click();
		boolean isMaleRadioButtonSelected = maleRadioButtonSelection.isSelected();
		
		
		/*if(maleRadioButtonSelection.isSelected()==true)
		{
			System.out.println("Male Radio Button is enabled");
		}
		else
		{
			System.out.println("Male Radio Button is disabled");
		}*/
		assertTrue(isMaleRadioButtonSelected,"Male Radio Button is disabled");
		
		WebElement showSelectedValueButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		showSelectedValueButton.click();
		String actualMessage = driver.findElement(By.xpath("//div[@id='message-one']")).getText();
		
	/*	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.textToBePresentInElement(showSelectedValueButton, actualMessage));*/

		assertEquals(expectedMessage,actualMessage,"The button selection shows as " + expectedMessage + "But is shows as " + actualMessage );
		
		
		boolean flag = false;
		assertFalse(flag,"Expected message is true but it is false");
		
		int a=5;
		int b=6;
		assertNotEquals(a,b,"A and B are equal");
		
		String str = null;
		assertNull(str,"str is not null");
		
		String s = "Not Null";
		assertNotNull(s,"s is null");

	}
	
	@Test
	public void softAssert()
	{
		SoftAssert softassert = new SoftAssert();
		boolean flag = true;
		softassert.assertFalse(flag,"Expected message is true but it is false");
		
		int a=5;
		int b=6;
		softassert.assertNotEquals(a,b,"A and B are equal");
		
		String str = null;
		softassert.assertNull(str,"str is not null");
		
		softassert.assertAll();
	}


}
