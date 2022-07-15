// PACKAGE
package dev.team4.steps;

//IMPORTS
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

//CLASS
public class CustomerLoginStepImpl {

	// CONNECTION TO SELENIUM WEB DRIVER AND LoginRunner.java
	private WebDriver driver = CustomerLoginRunner.driver;

	// CONNECTION TO CustomerLoginPage.java AND LoginRunner.java
	private CustomerLoginPage customerLoginPage = CustomerLoginRunner.customerLoginPage;

	// GIVEN A CUSTOMER IS ON THE LOGIN PAGE
	@Given("A Customer is on the Customer Login Page")
	public void a_customer_is_on_the_login_page() {
		driver.get("http://localhost:8030/CustomerLoginPage.html");
	}

	// WHEN A CUSTOMER TYPES IN THEIR USERNAME AND PASSWORD AND CLICKS THE CUSTOMER
	// LOGIN
	// BUTTON
	@When("A Customer types in their {string} and {string} and clicks the Customer Login button")
	public void the_customer_types_in_their_and_and_clicks_the_customer_login_button(String username, String pass) {
		customerLoginPage.usernameInput.sendKeys(username);
		customerLoginPage.passwordInput.sendKeys(pass);
		customerLoginPage.loginButton.click();
	}

	// THEN THE CUSTOMER SHOULD BE ON THE CUSTOMER HOME PAGE
	@Then("A Customer should be on the Customer Home Page")
	public void a_customer_should_be_on_the_customer_home_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Customer Home Page"));
		assertEquals("Customer Home Page", driver.getTitle());
	}
}