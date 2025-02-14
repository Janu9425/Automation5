package utility;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	
	public void selectValueFromDropDownUsingIndex(WebElement element, int index)
	{
	
		Select select = new Select(element); 
		select.selectByIndex(index);

	}

	public void selectValueFromDropDownUsingValue(WebElement element, String value)
	{
	
		Select select = new Select(element); 
		select.selectByValue(value);

	}
	
	public void selectValueFromDropDownUsingVisibleText(WebElement element, String text)
	{
	
		Select select = new Select(element); 
		select.selectByVisibleText(text);

	}
	
	public String alertTextFetching(WebElement element ,WebDriver driver)
	{
		String alertBoxText = driver.switchTo().alert().getText();
		return alertBoxText;
	}
	
	public void alertPopupAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void alertPopupDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void alertPopupValueSendBySendkeys(WebDriver driver)
	{
		driver.switchTo().alert().sendKeys("Janet Thomas");
		driver.switchTo().alert().accept();
	}
	
	public void scrollTODown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
	
	}
	
	public void scrollToUp(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-200)", "");
	
	}
	
	public void completeScrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	}
	
	public void navigation(WebDriver driver, String Url) {
		driver.navigate().to(Url);
	}
	
	public void swithchToChildWindowClickAnElement(WebDriver driver,WebElement element)
	{
		String mainWindow = driver.getWindowHandle();// used to identify the parent
		Set<String> popupWindow = driver.getWindowHandles();
		Iterator<String> i1=popupWindow.iterator();
		while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!mainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);
                    element.click();
                 
            }
        }
		
		driver.close();
		driver.switchTo().window(mainWindow);
	}
	
	
	public void actionsMouseHover(WebElement element, WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();	
	}
	
	public void actionClassForDoubleClick(WebElement element, WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	public void actionRightClick(WebElement element, WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	public void actionClassForDragandDrop(WebElement element,WebElement element2, WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element, element2).build().perform();
	}
	
	public String cssValueOfWebElement(WebElement element, String property) 
	{
		String cssValue = element.getCssValue(property);
		return cssValue;
		
	}
	
	public String attributeValueOfWebElement(WebElement element, String attribute)
	{
		String attributeValue = element.getAttribute(attribute);
		return attributeValue;
	}
	
	public void switchToIFrame(WebDriver driver,WebElement iFrameElement)
	{
		driver.switchTo().frame(iFrameElement);
	}
	
	public void switchToIFrameByIndex(WebDriver driver,WebElement element,int index ) 
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToIFrameById(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	}
}