package testscript;

import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class PopUP  extends Base {
	public void handlingPOPUP()
	{
		driver.navigate().to("https://selenium.qabible.in/window-popup.php");
		WebElement popupFacebookLike = driver.findElement(By.xpath("//a[text()= '  Like us On Facebook ']"));
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(popupFacebookLike));
		
		popupFacebookLike.click();
		
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
            		//WebElement navigateToFacebook = driver.findElement(By.xpath("//div[@class='x1xka2u1 xqfms19']//following::div[@aria-label='Accessible login button']")); 
                    WebElement navigateToFacebook = driver.findElement(By.xpath("(//span[text()='See more from Obsqura Zone | Kazhakuttam '])[1]"));
            }
        }
		
		driver.close();
		driver.switchTo().window(mainWindow);
	}

	public static void main(String[] args) {
		PopUP popup =new PopUP();
		popup.initialiseBrowser();
		popup.handlingPOPUP();
		//popup.browserQuit();

	}

}
