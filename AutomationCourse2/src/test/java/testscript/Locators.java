package testscript;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Locators extends Base {
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
		WebElement cssSelectorOfClassName = driver.findElement(By.cssSelector(".copyright"));
		WebElement cssSelectorOfClassName2 = driver.findElement(By.cssSelector(".mt-5"));
		WebElement cssSelectorTagNameOfClassName = driver.findElement(By.cssSelector("footer.mt-5"));
		WebElement cssSelectorTagNameOfClassName2 = driver.findElement(By.cssSelector("div.copyright"));
		WebElement cssSelectorofTagNameWithID = driver.findElement(By.cssSelector("input#value-a"));
		WebElement cssSelectorofTagNameWithID2 = driver.findElement(By.cssSelector("button#button-two"));
		WebElement cssSelectorOfAnotherAttributeValue = driver.findElement(By.cssSelector("link[rel='canonical']"));
		WebElement cssSelectorOfAnotherAttributeValue2 = driver.findElement(By.cssSelector("meta[charset='UTF-8']"));
		WebElement cssSectorWithTagName = driver.findElement(By.tagName("ul"));//more than one varum so tag name suggest cheyaru illa this just for sample
		//driver.navigate().to("https://www.finderskeepers.com/lander");
		WebElement xpathofID = driver.findElement(By.xpath("//button[@id='button-two']"));
		WebElement xpathID = driver.findElement(By.xpath("//div[@id='message-two']"));
		WebElement xpathID2 = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		WebElement xpathID3 = driver.findElement(By.xpath("//input[@id='value-a']"));
		WebElement xpathID4 = driver.findElement(By.xpath("//input[@id='value-b']"));
		//xpath different technique for dynamically changing values fields
		WebElement xpathID5 = driver.findElement(By.xpath("//button[contains(@id,'button-o')]"));
		WebElement xpathID6 = driver.findElement(By.xpath("//button[starts-with(@id,'button-o')]"));
		WebElement xpathID7 = driver.findElement(By.xpath("//button[text()='Show Message']"));
		WebElement xpathID8 = driver.findElement(By.xpath("//button[contains(text(),'Show Message')]"));
		WebElement xpathID9 = driver.findElement(By.xpath("//button[text()='Show Message' and @id='button-one']"));
		WebElement xpathID10 = driver.findElement(By.xpath("//button[text()='Show Message' or @id='button-three']"));
		/*      parent finding with xpath eg::written example of show message button parent finding 
		        button[@id='button-one']/..           */
		WebElement xpathID11 = driver.findElement(By.xpath("//button[@id='button-one']//parent::form"));
		// Access Methods
		WebElement xpathID12 = driver.findElement(By.xpath("//section[@class='clearfix']//child::div[@class='container page']"));
		WebElement xpathID13 = driver.findElement(By.xpath("//button[@id='button-one']//following::div[@id='message-one']"));
		WebElement xpathID14 = driver.findElement(By.xpath("//button[@id='button-one']//preceding::div[@class='header-top']"));
		WebElement xpathID15 = driver.findElement(By.xpath("//button[@id='button-one']//ancestor::div[@class='container page']"));
		WebElement xpathID16 = driver.findElement(By.xpath("//section[@class='clearfix']//descendant::div[@class='container page']"));
		WebElement xpathID17 = driver.findElement(By.xpath("//button[@id='button-one']//following-sibling::div"));
	}

	public static void main(String[] args) {
		Locators webelements = new Locators();
		webelements.initialiseBrowser();
		webelements.locators();
		webelements.browserQuit();
	}

}
