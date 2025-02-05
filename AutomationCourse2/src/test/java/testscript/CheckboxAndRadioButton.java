package testscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxAndRadioButton extends Base{
	public void checkBox()
	{
		driver.navigate().to("https://selenium.qabible.in/check-box-demo.php");
		WebElement checkBoxSelection = driver.findElement(By.xpath("//input[@id='gridCheck']"));
		boolean BeforeisCheckBoxSelected=checkBoxSelection.isSelected();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(checkBoxSelection));
		
		checkBoxSelection.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeSelected(checkBoxSelection));
		
		boolean isCheckBoxSelected=checkBoxSelection.isSelected();
	}
	
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
		if(radioButtonMale.isSelected()==false && radioButtonFemale.isSelected()==false)
		{
			System.out.println("Male & Female Radio Buttons are disabled");
		}
		else
		{
			System.out.println("Male & Female Radio Buttons are enabled");
		}
		WebElement  maleRadioButtonSelection =driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		maleRadioButtonSelection.click();
		boolean isMaleRadioButtonSelected = maleRadioButtonSelection.isSelected();
		if(maleRadioButtonSelection.isSelected()==true)
		{
			System.out.println("Male Radio Button is enabled");
		}
		else
		{
			System.out.println("Male Radio Button is disabled");
		}
		WebElement showSelectedValueButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		showSelectedValueButton.click();
		String actualMessage = driver.findElement(By.xpath("//div[@id='message-one']")).getText();
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.textToBePresentInElement(showSelectedValueButton, actualMessage));
		
		//System.out.println(actualMessage);
		if(actualMessage.equals(expectedMessage))
		{
			System.out.println("Message Mathches !!");
		}
		else
		{
			System.out.println("Message did not Matches !!");
		}
		

	}

	public static void main(String[] args) {
		CheckboxAndRadioButton checkboxandradiobutton = new CheckboxAndRadioButton();
		checkboxandradiobutton.initialiseBrowser();
		checkboxandradiobutton.checkBox();
		checkboxandradiobutton.verifyTheUserIsAbleToSelectMaleOption();
		checkboxandradiobutton.browserQuit();
	}

}
