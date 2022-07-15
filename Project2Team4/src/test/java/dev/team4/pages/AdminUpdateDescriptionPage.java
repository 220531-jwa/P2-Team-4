// PACKAGE
package dev.team4.pages;

//IMPORTS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//CLASS
public class AdminUpdateDescriptionPage {

	// SELENIUM WEB DRIVER
	private WebDriver driver;

	// UPDATE FLIGHT LOCATION DESCRIPTION PAGE
	public AdminUpdateDescriptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// FLIGHT ID
	@FindBy(id = "fid")
	public WebElement fidInput;

	// FLIGHT DESCRIPTION
	@FindBy(id = "description")
	public WebElement descriptionInput;

	// SUBMIT BUTTON
	@FindBy(id = "updateDescription")
	public WebElement updateButton;
}