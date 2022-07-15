// PACKAGE
package dev.team4.pages;

//IMPORTS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//CLASS
public class AdminCreateFlightPage {

	// SELENIUM WEB DRIVER
	private WebDriver driver;

	// CREATE FLIGHT PAGE
	public AdminCreateFlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// AIRLINE
	@FindBy(id = "airline")
	public WebElement airlineInput;

	// ARRIVING
	@FindBy(id = "arriving")
	public WebElement arrivingTimeInput;

	// DEPARTING
	@FindBy(id = "departing")
	public WebElement departingTimeInput;

	// SUBMIT BUTTON
	@FindBy(id = "createButton")
	public WebElement createButton;
}