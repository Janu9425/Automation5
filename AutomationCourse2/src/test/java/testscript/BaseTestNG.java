package testscript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTestNG {

	public WebDriver driver;
	@BeforeMethod
	public void initialiseBrowser()
	{
		driver=new ChromeDriver();
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// Implicit wait
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void browserQuit()
	{
		driver.close();
	}
}
