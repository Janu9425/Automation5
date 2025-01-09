package testscript;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElements extends Base {
	public void locators()
	{
		WebElement showmessagebutton = driver.findElement(By.id("button-one"));//to identify webelement
		WebElement classNameSample = driver.findElement(By.className("clearfix"));
		WebElement nameSample = driver.findElement(By.name("viewport"));
		WebElement linkTextSample = driver.findElement(By.linkText("Checkbox Demo"));
		WebElement partialLinkTextSample = driver.findElement(By.partialLinkText("Checkbox"));
		WebElement enterMessage = driver.findElement(By.id("single-input-field"));
		WebElement enterValueA = driver.findElement(By.id("value-a"));
		WebElement nameDescription = driver.findElement(By.name("description"));
		WebElement nameAuthor = driver.findElement(By.name("author"));
		WebElement classNameHeader = driver.findElement(By.className("copyright"));
		WebElement classNameHeaderText =driver.findElement(By.className("mt-5"));
		WebElement linkTextDemo = driver.findElement(By.linkText("Radio Buttons Demo"));
		WebElement partialLinkTextDemo = driver.findElement(By.partialLinkText("Radio"));
		WebElement linkTextCheckbox = driver.findElement(By.linkText("Simple Form Demo"));
		WebElement partialLinkTextCheckbox = driver.findElement(By.partialLinkText("Simple"));
		WebElement cssSelectorOfClass = driver.findElement(By.cssSelector(".clearfix"));
		WebElement cssSelectorOfTagClass = driver.findElement(By.cssSelector("section.clearfix"));
		WebElement cssSelectorOfTagId = driver.findElement(By.cssSelector("button#button-one"));
		WebElement cssSelectorOfAnotherAttribute = driver.findElement(By.cssSelector("link[href='css/main.css']"));
		WebElement tagNameSample = driver.findElement(By.tagName("div"));
		WebElement xpathSample = driver.findElement(By.xpath("//button[@id='button-one']"));
	}

	public static void main(String[] args) {
		WebElements webelements = new WebElements();
		webelements.initialiseBrowser();
		webelements.locators();
		webelements.browserQuit();
	}

}
