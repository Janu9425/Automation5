package testscript;





import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FileUpLoad extends Base{
	public void fileuploadUsingSendKeys()
	{
		driver.navigate().to("https://demo.guru99.com/test/upload/");
		WebElement chooseFileButtonSelection= driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		chooseFileButtonSelection.sendKeys("D:\\selenium_self created note\\Selenium_Note.pdf");
		
	}
	
	public void fileuploadUsingRobotClass() throws AWTException
	{
		driver.navigate().to("https://www.ilovepdf.com/pdf_to_word");
		WebElement fileuploadButtonSelection = driver.findElement(By.xpath("//a[@id='pickfiles']"));
		fileuploadButtonSelection.click();
		StringSelection stringselection = new StringSelection("D:\\selenium_self created note\\Selenium_Note.pdf");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,null);
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      robot.keyRelease(KeyEvent.VK_ENTER);
	      robot.keyPress(KeyEvent.VK_CONTROL);
	      robot.keyPress(KeyEvent.VK_V);//two
	     
	     
	      robot.keyRelease(KeyEvent.VK_CONTROL);//release command

	      robot.keyRelease(KeyEvent.VK_V);
	      robot.keyPress(KeyEvent.VK_ENTER);
	     
	     // r.delay(90);
	      robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void main(String[] args)  {
		FileUpLoad fileupload = new FileUpLoad();
		fileupload.initialiseBrowser();
		//fileupload.fileuploadUsingSendKeys();
		try {
			fileupload.fileuploadUsingRobotClass();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fileupload.browserQuit();
	}

}
