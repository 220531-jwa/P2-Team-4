package dev.team4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {

	// SELENIUM WEB DRIVER
	private WebDriver driver;

	// LOGIN PAGE
	public UserLoginPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// CUSTOMER USERNAME
	@FindBy(id = "cUname")
	public WebElement usernameInput;

	// CUSTOMER PASSWORD
	@FindBy(id = "cPass")
	public WebElement passwordInput;

	// LOGIN BUTTON
	@FindBy(xpath = "/html/body/div/button")
	public WebElement loginButton;
}
