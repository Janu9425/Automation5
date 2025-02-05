package testscript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	
	public void initialiseBrowser()
	{
		driver=new ChromeDriver();
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// Implicit wait
		driver.manage().window().maximize();
	}

	public void browserQuit()
	{
		driver.close();
	}

	public static void main(String[] args) 
	{
		Base base=new Base();
		base.initialiseBrowser();
		base.browserQuit();

	}


}
