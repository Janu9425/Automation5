package testscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames extends Base {
	public void handlingFrames()
	{
		//iframe int tag il ullathu anel direct click nadakilla (oru html page int agathottu mattoru html page ene embbed cheythu vekan anu iframe use cheythirikunnthu ) athayathu ithu oru frame il ayirikum cheythirikunnathu 
		
		driver.navigate().to("https://demo.guru99.com/test/guru99home/");
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		
		//driver.switchTo().frame(2);
		driver.switchTo().frame(frame);
		//driver.switchTo().frame("a077aa5e");
		WebElement addesSelection =driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
		addesSelection.click();
	}

	public static void main(String[] args) {
		Frames frames = new Frames();
		frames.initialiseBrowser();
		frames.handlingFrames();
		frames.browserQuit();

	}

}
