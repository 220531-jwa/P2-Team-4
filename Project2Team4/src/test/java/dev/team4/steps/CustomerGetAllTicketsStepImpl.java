// PACKAGE
package dev.team4.steps;

// IMPORTS
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.CustomerLoginPage;
import dev.team4.runners.CustomerLoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// CLASS
public class CustomerGetAllTicketsStepImpl {

	// CONNECTION TO SELENIUM WEB DRIVER AND CustomerLoginRunner
	private WebDriver driver = CustomerLoginRunner.driver;

	// CONNECTION TO CustomerLoginPage AND CustomerLoginRunner
	private CustomerLoginPage customerLoginPage = CustomerLoginRunner.customerLoginPage;

	// GIVEN A CUSTOMER IS ON THE LOGIN PAGE, THEY CAN LOGIN TO GO TO
	@Given("A Customer is on the login page they can login to go to the customer home page and see all their tickets")
	public void a_customer_is_on_the_login_page_they_can_login_go_to_customer_landing_page_and_see_all_ticket() {
		driver.get("http://localhost:8030/CustomerLoginPage.html");
	}

	// WHEN CUSTOMER TYPES IN THEIR USERNAME AND PASSWORD AND CLICKS THE LOGIN
	// BUTTON
	@When("A Customer types in their {string} and {string} and clicks the Login button")
	public void the_customer_types_in_their_and_and_clicks_the_login_button(String username, String password) {
		customerLoginPage.usernameInput.sendKeys(username);
		customerLoginPage.passwordInput.sendKeys(password);
		customerLoginPage.loginButton.click();
	}

	// THEN A CUSTOMER SHOULD BE ON THE CUSTOMER HOME PAGE WITH ALL THEIR TICKETS
	// AVAILABLE
	@Then("A Customer should be on the Customer Home Page with all their tickets available")
	public void the_user_should_be_on_the_home_page_with_all_tickets_available() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Home Page"));
		assertEquals("Home Page", driver.getTitle());
	}
}