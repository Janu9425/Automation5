package testscript;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementsCommands extends Base {
	public void webElementCommand()
	{
		String expectedBackGroundColor = "rgba(0, 123, 255, 1)";
		
		
		WebElement singleInputField = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		singleInputField.sendKeys("hello");
		singleInputField.clear();
		WebElement showMessage =driver.findElement(By.xpath("//button[@id='button-one']"));
		showMessage.click();
		boolean isShowMessageButtonEnabled =showMessage.isEnabled();
		boolean isShowMessageIsDiplsayed=showMessage.isDisplayed();
		WebElement yourMessage = driver.findElement(By.xpath("//div[@id='message-one']"));
		String yourMessageText = yourMessage.getText(); // compare
		String attribute =showMessage.getAttribute("type");
		String attribute2 =showMessage.getAttribute("class");
		String attribute3 =showMessage.getAttribute("id");
		String attribute4 =singleInputField.getAttribute("class");
		String attribute5 =yourMessage.getAttribute("class");
		String backgroundColor =showMessage.getCssValue("background-color");
		String tagname = showMessage.getTagName();
		
		
	}
	
	public void verifyTheSingleInputField()
	{

		WebElement singleInputField = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		//StringBuffer sb = new StringBuffer();
		//StringBuffer test = sb.append("test");
		String expectedInputValue = "hello";
		singleInputField.sendKeys(expectedInputValue);
		singleInputField.clear();
		WebElement showMessagebutton = driver.findElement(By.xpath("//button[@id='button-one']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));// syntax of explicit
		wait.until(ExpectedConditions.elementToBeClickable(showMessagebutton));//same this is also for syntax complete
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", showMessagebutton);
		js.executeScript("window.scrollBy(0,200)", "");
		js.executeScript("window.scrollBy(0,-200)", "");
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");*/
		showMessagebutton.click();
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
	
	
	public void verifyTheTwoInputValue()
	{
		int a =10;
		int b=20;
		int c=a+b;
		//System.out.println(c);
		String expectedTotalValue= String.valueOf(c);
		WebElement enterValueA = driver.findElement(By.xpath("//input[@id='value-a']"));
		enterValueA.sendKeys(""+a);
		WebElement enterValueB = driver.findElement(By.xpath("//input[@id='value-b']"));
		enterValueB.sendKeys(""+b);
		WebElement getTotalButton =driver.findElement(By.xpath("//button[@id='button-two']"));
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(getTotalButton));
		getTotalButton.click();
		WebElement total =driver.findElement(By.xpath("//div[@id='message-two']"));
		String totalValue= total.getText();
		String actualTotalValue=totalValue.substring(14);
		if(actualTotalValue.equals(expectedTotalValue))
		{
			System.out.println("Matches Correct");
		}
		else
		{
			System.out.println("Matches In correct");
		}		
	}
	
	public void backGroundColor()
	{
		String expectedShowMessageButton = "rgba(0, 123, 255, 1)";

		WebElement showMessagebutton = driver.findElement(By.xpath("//button[@id='button-one']"));
		String actualBackgroundcolor=showMessagebutton.getCssValue("background-color");
		if(actualBackgroundcolor.equals(expectedShowMessageButton))
		{
			System.out.println("Matches");
		}
		else
		{
			System.out.println("Doesn't Matches");
		}
	}
	
	public void borderColor()
	{
		String expectedBorderColor = "rgb(0, 123, 255)";
		WebElement showMessagebutton = driver.findElement(By.xpath("//button[@id='button-one']"));
		String actualBorderColor = showMessagebutton.getCssValue("border-color");
		if(actualBorderColor.equals(expectedBorderColor))
		{
			System.out.println("Matches");
	
		}
		else
		{
			System.out.println("Doesn't Matches");
		}
		
	}
	
	public void fontWeight()
	{
		String expectedFontWeight = "400";
		WebElement showMessagebutton = driver.findElement(By.xpath("//button[@id='button-one']"));
		String actualFontWeight = showMessagebutton.getCssValue("font-weight");
		if(expectedFontWeight.equals(actualFontWeight))
		{
			System.out.println("Matches");
	
		}
		else
		{
			System.out.println("Doesn't Matches");
		}
		
	}

	public static void main(String[] args) {
		WebElementsCommands webelementscommands = new WebElementsCommands();
		webelementscommands.initialiseBrowser();
		//webelementscommands.webElementCommand();
		webelementscommands.verifyTheSingleInputField();;
		//webelementscommands.verifyTheTwoInputValue();
		//webelementscommands.backGroundColor();
		//webelementscommands.borderColor();
		//webelementscommands.fontWeight();
		webelementscommands.browserQuit();
		

	}

}
