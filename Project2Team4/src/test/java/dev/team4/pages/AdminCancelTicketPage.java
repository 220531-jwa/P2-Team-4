// PACKAGE
package dev.team4.pages;

// IMPORTS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// CLASS
public class AdminCancelTicketPage {

	// CONNECTION TO SELENIUM WEB DRIVER
	private WebDriver driver;

	public AdminCancelTicketPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// TICKET ID
	@FindBy(id = "tid")
	public WebElement ticketIdInput;

	// CANCEL
	@FindBy(id = "cancelButton")
	public WebElement cancelButton;

}