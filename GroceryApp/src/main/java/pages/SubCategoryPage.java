package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utility.FileUpLoadUtility;
import utility.PageUtility;
import utility.RandomUtility;

public class SubCategoryPage {
public WebDriver driver;
	
	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']//child::i[@class='fas fa-arrow-circle-right']") WebElement subCategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement subcategoryCreateButton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']") WebElement categoryField;
	@FindBy(xpath = "//input[@id='subcategory']") WebElement SubcategoryField;
	@FindBy(xpath = "//input[@id='main_img']") WebElement fileChoose;
	@FindBy(xpath = "//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertSuccessDisplay;
	
	
	public void selctionOfSubCategoryPage()
	{
		subCategory.click();
	}
	
	public SubCategoryPage selectionfSubCategoryCreateButton()
	{
		subcategoryCreateButton.click();
		return this;
	}
	
	public SubCategoryPage categorySelectedFromDropDown()
	{
		PageUtility pageutility = new PageUtility();
		pageutility.selectValueFromDropDownUsingIndex(categoryField, 4);
		return this;
	}
	
	public SubCategoryPage enteringSubcategoryName()
	{
		RandomUtility randomutility = new RandomUtility();
		String Subcategoryadding = randomutility.createsubCategoryName();
		SubcategoryField.sendKeys(Subcategoryadding);
		return this;
	}
	
	public SubCategoryPage imageuploadingForSubCategoryCreate()
	{
		FileUpLoadUtility fileuploadutility = new FileUpLoadUtility();
		fileuploadutility.FileUploadUsingSendKeys(fileChoose, Constants.TESTIMAGEFILE1);
		return this;
	}
	
	public SubCategoryPage buttonClickForCreatingSubCategory()
	{
		saveButton.click();
		return this;
	}
	
	public String alertdisplay()
	{
		String alertDisplayfromScreen = alertSuccessDisplay.getText();
		return alertDisplayfromScreen;
	}
	
	
	
	
}
