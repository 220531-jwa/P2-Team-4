// PACKAGE
package dev.team4.pages;

//IMPORTS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//CLASS
public class AdminHomePage {

	// SELENIUM WEB DRIVER
	private WebDriver driver;

	// ADMIN HOME PAGE
	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// TICKETS BUTTON
	@FindBy(xpath = "/html/body/button")
	public WebElement ticketButton;
}