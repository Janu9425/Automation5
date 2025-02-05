package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MultiElementSelect extends Base {
	public void multiSelect()
	{
		driver.navigate().to("https://selenium.qabible.in/select-input.php");
		WebElement multipleselection = driver.findElement(By.xpath("//select[@id='multi-select-field']"));
		Select select = new Select(multipleselection);
		boolean isDropDownISMultiSelect =select.isMultiple();//Multipleselect thanne ano ennu conform cheyunnathu anu ithu (ithu true anel multiple select und ithu return cheyunnathu false anel multiple select ullathu alla
		select.selectByIndex(1);
		select.selectByIndex(2);
		
	}

	public static void main(String[] args) {
		MultiElementSelect multielementselect = new MultiElementSelect();
		multielementselect.initialiseBrowser();
		multielementselect.multiSelect();
		multielementselect.browserQuit();

	}

}
