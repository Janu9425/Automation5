package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExcecutorForScroll extends Base {
	
	public void verifyTheSingleInputFieldForScrollStudy()
	{

		WebElement singleInputField = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		String expectedInputValue = "hello";
		singleInputField.sendKeys(expectedInputValue);
		WebElement showMessagebutton = driver.findElement(By.xpath("//button[@id='button-one']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", showMessagebutton);
		js.executeScript("window.scrollBy(0,200)", "");
		js.executeScript("window.scrollBy(0,-200)", "");
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		boolean isShowMessageButtonEnabled =showMessagebutton.isEnabled();
		boolean isShowMessageIsDiplsayed=showMessagebutton.isDisplayed();
		WebElement yourMessage = driver.findElement(By.xpath("//div[@id='message-one']"));
		String yourMessageText =yourMessage.getText();
		String actualYourMessageText =yourMessageText.substring(15);
		System.out.println(actualYourMessageText);
	//	String message =showMessagebutton.getAttribute("value");
		if(expectedInputValue.equals(actualYourMessageText))
		{
			System.out.println("Matches Correct");
		}
		else
		{
			System.out.println("Matches In correct");
		}
		
	}

	public static void main(String[] args) {
		JavaScriptExcecutorForScroll javascriptexecutorforscroll = new JavaScriptExcecutorForScroll();
		javascriptexecutorforscroll.initialiseBrowser();
		javascriptexecutorforscroll.verifyTheSingleInputFieldForScrollStudy();;
	//	javascriptexecutorforscroll.browserQuit();

	}

}
