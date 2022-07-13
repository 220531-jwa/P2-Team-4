// PACKAGE
package dev.team4.pages;

//IMPORTS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//CLASS
public class UpdateFlightLocationDescriptionPage {

	// SELENIUM WEB DRIVER
	private WebDriver driver;

	// UPDATE FLIGHT LOCATION DESCRIPTION PAGE
	public UpdateFlightLocationDescriptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// FLIGHT ID
	@FindBy(id = "flightId")
	public WebElement flightID;

	// FLIGHT DESCRIPTION
	@FindBy(id = "flightDescription")
	public WebElement flightDescriptionInput;

	// EDIT FLIGHT DESCRIPTION
	@FindBy(id = "editFlightDescription")
	public WebElement submitButton;
}