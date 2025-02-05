package testscript;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts extends Base{
	public void alertsByClick()
	{
		driver.navigate().to("https://selenium.qabible.in/javascript-alert.php");
		WebElement javaScriptAlertBoxClickme = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		javaScriptAlertBoxClickme.click();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		String alertBoxTextVerifying = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
	
		WebElement javaScriptConfirmBoxClickme = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
		javaScriptConfirmBoxClickme.click();
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.alertIsPresent());
		
		//driver.switchTo().alert().accept();// this code is for ok button press
		driver.switchTo().alert().dismiss();// this codeis for cancel the alert screen
		WebElement javaScriptClickForPromptBox = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		javaScriptClickForPromptBox.click();
		driver.switchTo().alert().sendKeys("Janet Thomas"); //value entering in the alert box 
		driver.switchTo().alert().accept();
	}
	

	public static void main(String[] args) {
		
		Alerts alerts = new Alerts();
		alerts.initialiseBrowser();
		alerts.alertsByClick();
		//alerts.browserQuit();

	}

}
