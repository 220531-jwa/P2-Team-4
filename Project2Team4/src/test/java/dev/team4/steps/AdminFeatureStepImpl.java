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
public class AdminFeatureStepImpl {

	// CONNECTION TO SELENIUM WEB DRIVER AND UserLoginRunner.java
	private WebDriver driver = UserLoginRunner.driver;

	// CONNECTION TO userLoginPage.java and UserLoginRunner.java
	private UserLoginPage userLoginPage = UserLoginRunner.userLoginPage;

	// GIVEN AN ADMIN IS ON THE LOGIN PAGE
	@Given("a Admin is on the Login Page")
	public void a_admin_is_on_the_login_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8030/loginpage.html");
	}

	// WHEN THE ADMIN TYPES IN THEIR CREDENTIALS AND CLICKS ON THE LOGIN BUTTON
	@When("the Admin types in their {string} and {string} and clicks the Login button")
	public void the_admin_types_in_their_and_and_clicks_the_login_button(String username, String password) {
		// Write code here that turns the phrase above into concrete actions
		userLoginPage.usernameInput.sendKeys(username);
		userLoginPage.passwordInput.sendKeys(password);
		userLoginPage.loginButton.click();
	}

	// THEN THE ADMIN SHOULD BE ON THE ADMIN HOMEPAGE
	@Then("the Admin should be on the Admin Homepage")
	public void the_admin_should_be_on_the_admin_homepage() {
		// Write code here that turns the phrase above into concrete actions
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Admin Landing Page"));
		assertEquals("Admin Landing Page", driver.getTitle());
	}
}