// PACKAGE
package dev.team4.pages;

// IMPORTS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// CLASS
public class AdmingGetAllTicketsPage {

	// SELENIUM WEB DRIVER
	private WebDriver driver;

	// ADMIN VIEW ALL TICKETS PAGE
	public AdmingGetAllTicketsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// AIRLINE
	@FindBy(id = "airline")
	public WebElement airlineInput;

	// ARRIVAL
	@FindBy(id = "arrival")
	public WebElement arrivalInput;

	// DEPARTURE
	@FindBy(id = "departure")
	public WebElement departureInput;

	// CITY
	@FindBy(id = "city")
	public WebElement cityInput;

	// COUNTRY
	@FindBy(id = "country")
	public WebElement countryInput;

	// DESCRIPTION
	@FindBy(id = "description")
	public WebElement description;

	// BACK BUTTON
	@FindBy(xpath = "/html/body/div/button")
	public WebElement backButton;
}
