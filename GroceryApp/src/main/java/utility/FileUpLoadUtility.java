package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;

public class FileUpLoadUtility {

	public void FileUploadUsingSendKeys(WebElement element ,String imageuploadpath)
	{
		element.sendKeys(imageuploadpath);
	}
	
	public void fileuploadUsingRobotClass(WebElement element ,String path) throws AWTException
	{
	
		element.click();
		StringSelection stringselection = new StringSelection(path);
		
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
}
