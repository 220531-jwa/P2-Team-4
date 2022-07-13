// PACKAGE
package dev.team4.steps;

//IMPORTS
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.UserLoginPage;
import dev.team4.runners.UserLoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//CLASS
public class UserFeatureStepImpl {

	// CONNECTION TO SELENIUM WEB DRIVER AND UserLoginRunner.java
	private WebDriver driver = UserLoginRunner.driver;

	// CONNECTION TO UserLoginPage.java AND UserLoginRunner.java
	private UserLoginPage userLoginPage = UserLoginRunner.userLoginPage;

	// GIVEN A CUSTOMER IS ON THE LOGIN PAGE
	@Given("a Customer is on the Login Page")
	public void a_customer_is_on_the_login_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8030/loginpage.html");
	}

	// WHEN A CUSTOMER TYPES IN THEIR CREDENTIALS AND CLICKS ON THE CUSTOMER LOGIN
	// BUTTON
	@When("the Customer types in their {string} and {string} and clicks the Customer Login button")
	public void the_customer_types_in_their_and_and_clicks_the_customer_login_button(String username, String password) {
		// Write code here that turns the phrase above into concrete actions
		userLoginPage.usernameInput.sendKeys(username);
		userLoginPage.passwordInput.sendKeys(password);
		userLoginPage.loginButton.click();
	}

	// THEN THE CUSTOMER SHOULD BE ON THE CUSTOMER HOME PAGE
	@Then("the Customer should be on the Customer Homepage")
	public void the_customer_should_be_on_the_customer_homepage() {
		// Write code here that turns the phrase above into concrete actions
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.titleContains("Customer Landing Page"));
		assertEquals("Customer Landing Page", driver.getTitle());
	}
}