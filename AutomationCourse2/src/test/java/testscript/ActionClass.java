package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClass extends Base {
	public void action()
	{
		driver.navigate().to("https://selenium.qabible.in/drag-drop.php");
		WebElement draggable1 = driver.findElement(By.xpath("//div[@id=\"todrag\"]//child::span[text()= 'Draggable n°1']"));
		WebElement dottedBox = driver.findElement(By.xpath("//div[@id='mydropzone']"));
		Actions action = new Actions(driver);// argument driver ayittu anu pass cheyunnathu beacuse nammal browseril anu operations cheyunnathu 
		//action.moveToElement(draggable1).build().perform();// mouse hower cheyana anu
		//action.doubleClick(draggable1).perform();// element ene double click cheyanel
		//action.contextClick(draggable1).perform(); //element ene right click cheyan
		action.dragAndDrop(draggable1, dottedBox).build().perform(); //drag and drop cheyan 
		
	}

	public static void main(String[] args) {
		ActionClass actionclass = new ActionClass();
		actionclass.initialiseBrowser();
		actionclass.action();
		actionclass.browserQuit();

	}

}
