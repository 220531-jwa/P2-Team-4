// PACKAGE
package dev.team4.steps;

//IMPORTS
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.AdminLoginPage;
import dev.team4.runners.CustomerLoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//CLASS
public class AdminLoginStepImpl {

	// CONNECTION TO SELENIUM WEB DRIVER AND LoginRunner.java
	private WebDriver driver = CustomerLoginRunner.driver;

	// CONNECTION TO AdminLoginPage.java and LoginRunner.java
	private AdminLoginPage adminLoginPage = CustomerLoginRunner.adminLoginPage;

	// GIVEN AN ADMIN IS ON THE LOGIN PAGE
	@Given("the Admin is on the Login Page")
	public void a_admin_is_on_the_login_page() {
		driver.get("http://localhost:8030/AdminLoginPage.html");
	}

	// WHEN THE ADMIN TYPES IN THEIR USERNAME AND PASSWORD AND CLICKS THE ADMIN
	// LOGIN BUTTON
	@When("the Admin types in their {string} and {string} and clicks the Admin Login button")
	public void the_admin_types_in_their_and_and_clicks_the_admin_login_button(String username, String pass) {
		adminLoginPage.usernameInput.sendKeys(username);
		adminLoginPage.passwordInput.sendKeys(pass);
		adminLoginPage.loginButton.click();
	}

	// THEN THE ADMIN SHOULD BE ON THE ADMIN HOMEPAGE
	@Then("the Admin should be on the Admin Homepage")
	public void the_admin_should_be_on_the_admin_home_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Admin Home Page"));
		assertEquals("Admin Home Page", driver.getTitle());
	}
}