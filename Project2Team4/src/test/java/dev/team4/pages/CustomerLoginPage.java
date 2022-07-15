// PACKAGE
package dev.team4.pages;

// IMPORTS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// CLASS
public class CustomerLoginPage {

	// SELENIUM WEB DRIVER
	private WebDriver driver;

	// CUSTOMER LOGIN PAGE
	public CustomerLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// CUSTOMER USERNAME
	@FindBy(id = "cu")
	public WebElement usernameInput;

	// CUSTOMER PASSWORD
	@FindBy(id = "cp")
	public WebElement passwordInput;

	// LOGIN BUTTON
	@FindBy(xpath = "/html/body/div/button")
	public WebElement loginButton;
}
