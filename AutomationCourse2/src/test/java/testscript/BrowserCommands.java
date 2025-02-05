package testscript;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserCommands extends Base {
	public void browserCommands()
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
		//wait.until(ExpectedConditions.titleIs(title));
		String title=driver.getTitle();

		String url = driver.getCurrentUrl();
		String pagesource = driver.getPageSource();
	}


	public static void main(String[] args) {
		BrowserCommands browsercommands=new BrowserCommands();
		browsercommands.initialiseBrowser();
		browsercommands.browserCommands();
		browsercommands.browserQuit();

	}

}
