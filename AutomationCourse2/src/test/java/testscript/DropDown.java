package testscript;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown extends Base{
public void verifyDropDown()
{
	driver.navigate().to("https://selenium.qabible.in/select-input.php");
	WebElement dropDownSelection = driver.findElement(By.xpath("//select[@id='single-input-field']"));

	Select select = new Select(dropDownSelection); // select ennu paranju a class nammuku selenium tharunnund so nammal athu kondu object create cheyanam .selct class oru element ene expect cheyuund so nammude element ene kooduthu athayathu dropdownelement ene koduthu .
	select.selectByValue("Red");
	select.selectByVisibleText("Yellow");
	select.selectByIndex(3);
	List<WebElement> options = select.getOptions();
	int numberOfoptions = options.size();
}
public void verifyAnotherDropDown()
{
	driver.navigate().to("https://www.selenium.dev");
	WebElement dropDownOFAnotherPage = driver.findElement(By.xpath("//div[@class='dropdown']//child::a[@data-bs-toggle='dropdown']"));
	dropDownOFAnotherPage.click();
	List<WebElement > dropDownOptions = driver.findElements(By.xpath("//div[@class='dropdown']//child::a[@class='dropdown-item']"));
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));	
	wait.until(ExpectedConditions.visibilityOfAllElements(dropDownOptions));
	
	for(WebElement option : dropDownOptions)
	{
		String language = option.getText();
		if(language.equals("Português (Brasileiro)"))
		{
			option.click();
			break;
		}
	}
}


public void multipleElementSelect()
{
	driver.navigate().to("https://selenium.qabible.in/select-input.php");
	WebElement multipleselection = driver.findElement(By.xpath("//select[@id='multi-select-field']"));
	Select select = new Select(multipleselection);
	boolean isDropDownISMultiSelect = select.isMultiple();
	select.selectByIndex(1);
	select.selectByIndex(2);
	// //select[@id='multi-select-field']//child::option[text()='Red' or text()='Yellow' or text()='Green'] - list 3 color display
}

public void actionsClass()
{
	driver.navigate().to("https://selenium.qabible.in/drag-drop.php");
	WebElement draggable1 = driver.findElement(By.xpath("//div[@id=\"todrag\"]//child::span[text()= 'Draggable n°1']"));
	WebElement dottedBox = driver.findElement(By.xpath("//div[@id='mydropzone']"));
	Actions actions = new Actions(driver);
	//actions.moveToElement(draggable1).build().perform();
	//actions.doubleClick(draggable1).perform();
	//actions.contextClick(draggable1).perform();
	actions.dragAndDrop(draggable1, dottedBox).build().perform();
	
	
}


public void handlingFrames()
{
	driver.navigate().to("https://demo.guru99.com/test/guru99home/");
	WebElement frame = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
	//driver.switchTo().frame(2);
	driver.switchTo().frame(frame);
	//driver.switchTo().frame("a077aa5e");
	WebElement selection =driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
	selection.click();
}





	public static void main(String[] args) {
	DropDown dropdown = new DropDown();
	dropdown.initialiseBrowser();
	dropdown.verifyDropDown();
	//dropdown.verifyAnotherDropDown();
	//dropdown.multipleElementSelect();
	//dropdown.actionsClass();
	//dropdown.handlingFrames();
	//dropdown.browserQuit();
	

	}

}
