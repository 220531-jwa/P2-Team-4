// PACKAGE
package dev.team4.pages;

// IMPORTS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// CLASS
public class AdminLoginPage {

	// SELENIUM WEB DRIVER
	private WebDriver driver;

	// ADMIN LOGIN PAGE
	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ADMIN USERNAME
	@FindBy(id = "au")
	public WebElement usernameInput;

	// ADMIN PASSWORD
	@FindBy(id = "ap")
	public WebElement passwordInput;

	// LOGIN BUTTON
	@FindBy(xpath = "/html/body/div/button")
	public WebElement loginButton;
}
