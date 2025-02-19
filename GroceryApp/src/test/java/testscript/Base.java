package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utility.ScreenShotUtility;
import utility.WaitUtility;

public class Base {
	
	public WebDriver driver;
	
	@BeforeMethod (alwaysRun = true)
	@Parameters("browser")
	public void initialiseBrowser(String browser) throws Exception
	{
		Properties pro = new Properties();
		FileInputStream fs = new FileInputStream(Constants.CONFIGFILE);
		pro.load(fs);
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			throw new Exception("Wrong Browser");
		}
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	}
	
	@AfterMethod (alwaysRun = true )
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenShotUtility screenshort = new ScreenShotUtility();
			screenshort.getScreenShot(driver, iTestResult.getName());
		}
		
		driver.quit();
	}

}
