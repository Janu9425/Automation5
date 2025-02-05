package testscript;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table extends Base {
	
	public void verifyFromTableDeskMethod()
	{
		driver.navigate().to("https://selenium.qabible.in/table-pagination.php");
		WebElement tableWithPagination = driver.findElement(By.xpath("//ul[@class='navbar-nav']//following::a[@href='table-pagination.php' and @class='nav-link']"));
		tableWithPagination.click();
		List<WebElement> dropDownFromTable = driver.findElements(By.xpath("//table[@id='dtBasicExample']//child::tr[@class='odd']"));
		
		for(WebElement option : dropDownFromTable)
		{
			String text = option.getText();
			//System.out.println(text);
			if(text.equals("Ashton Cox Junior Technical Author San Francisco 66 2009/01/12 $86,000"))
			{
				//option.click();
				System.out.println("Ashton Cox is present in the table");
				break;
			}
		}	
		
	}
	
	
	public void verifyNameListingFromTable()
	{
		driver.navigate().to("https://selenium.qabible.in/table-pagination.php");
		WebElement tableWithPagination = driver.findElement(By.xpath("//ul[@class='navbar-nav']//following::a[@href='table-pagination.php' and @class='nav-link']"));
		tableWithPagination.click();
		List<WebElement> dropDownFromTable = driver.findElements(By.xpath("//table[@id='dtBasicExample']//descendant::td[text() ='Tiger Nixon' or text() ='Garrett Winters' or text()='Ashton Cox' or text()='Cedric Kelly' or text()='Airi Satou' or text()= 'Brielle Williamson' or text() ='Herrod Chandler'  or text()= 'Rhona Davidson' or text() ='Colleen Hurst' or text()= 'Sonya Frost']"));
		
		for(WebElement option : dropDownFromTable)
		{
			String text = option.getText();
			//System.out.println(text);
			if(text.equals("Ashton Cox"))
			{
				//option.click();
				System.out.println("Ashton Cox is present in the table");
				break;
			}
		}	
		
	}
	
	
	public void verifyNameFromTheTableList()
	{
		driver.navigate().to("https://selenium.qabible.in/table-pagination.php");
		WebElement tableWithPagination = driver.findElement(By.xpath("//ul[@class='navbar-nav']//following::a[@href='table-pagination.php' and @class='nav-link']"));
		tableWithPagination.click();
		List<WebElement> dropDownFromTable = driver.findElements(By.xpath("//table[@id='dtBasicExample']//descendant::td[text() ='Tiger Nixon' or text() ='Garrett Winters' or text()='Ashton Cox' or text()='Cedric Kelly' or text()='Airi Satou' or text()= 'Brielle Williamson' or text() ='Herrod Chandler'  or text()= 'Rhona Davidson' or text() ='Colleen Hurst' or text()= 'Sonya Frost']"));
		
		for(WebElement option : dropDownFromTable)
		{
			String text = option.getText();
			//System.out.println(text);
			if(text.equals("Cedric Kelly"))
			{
				//option.click();
				System.out.println("Cedric Kelly is present in the table");
				break;
			}
		}	
		
	}
	
	
	public void verifyTheHeadersOFTable()
	{
		driver.navigate().to("https://selenium.qabible.in/table-pagination.php");
		WebElement tableWithPagination = driver.findElement(By.xpath("//ul[@class='navbar-nav']//following::a[@href='table-pagination.php' and @class='nav-link']"));
		tableWithPagination.click();
		List<String> expectedHeaderText = new ArrayList<String>();
		expectedHeaderText.add("Name");
		expectedHeaderText.add("Position");
		expectedHeaderText.add("Office");
		expectedHeaderText.add("Age");
		expectedHeaderText.add("Start date");
		expectedHeaderText.add("Salary");
		System.out.println(expectedHeaderText);
		List<WebElement> headerOptionsFromTable = driver.findElements(By.xpath("//tr[@role='row']//descendant::th[@class='th-sm sorting_disabled']"));
		List<String> visibleHeaderText = new ArrayList<String>();
		
		for(WebElement option : headerOptionsFromTable)
		{
			 visibleHeaderText.add(option.getText());	
			// System.out.println(visibleHeaderText);
		}
		System.out.println(visibleHeaderText);
		if(visibleHeaderText.equals(expectedHeaderText))
		{
			System.out.println("Headers are Matching");
		}
		else
		{
			System.out.println("Headers are not Matching ");
		}
		
	}
	

	public static void main(String[] args) {
		Table table = new Table();
		table.initialiseBrowser();
		//table.verifyFromTableDeskMethod();
		//table.verifyNameListingFromTable();
		//table.verifyNameFromTheTableList();
		table.verifyTheHeadersOFTable();
		table.browserQuit();

	}

}
