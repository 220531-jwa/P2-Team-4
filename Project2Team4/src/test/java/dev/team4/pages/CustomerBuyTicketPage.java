// PACKAGE
package dev.team4.pages;

//IMPORTS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//CLASS
public class CustomerBuyTicketPage {

	// CONNECTION TO SELENIUM WEB DRIVER
	private WebDriver driver;

	public CustomerBuyTicketPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// BUY TICKETS
	// @FindBy(xpath = "/html/body/div/button")
	@FindBy(xpath = "/html/body/div/button")
	public WebElement BuyButton;
}