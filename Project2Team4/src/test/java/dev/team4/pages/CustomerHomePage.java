// PACKAGE
package dev.team4.pages;

//IMPORTS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//CLASS
public class CustomerHomePage {

	// SELENIUM WEB DRIVER
	private WebDriver driver;

	// CUSTOMER HOME PAGE
	public CustomerHomePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// BUTTON
	@FindBy(xpath = "/html/body/button")
	public WebElement buyButton;
}