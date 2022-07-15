// PACKAGE
package dev.team4.steps;

// IMPORTS
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.AdminLoginPage;
import dev.team4.runners.AdminLoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// CLASS
public class AdminGetAllTicketsStepImpl {

	// CONNECTION TO SELENIUM WEB DRIVER AND AdminLoginRunner
	private WebDriver driver = AdminLoginRunner.driver;

	// CONNECTION TO AdminLoginPage AND CustomerLoginRunner
	private AdminLoginPage adminLoginPage = AdminLoginRunner.adminLoginPage;

	// GIVEN THE ADMIN IS ON THE ADMIN LOGIN PAGE, THEY CAN LOGIN TO GO TO THE ADMIN
	// HOME PAGE AND SEE ALL THE TICKETS
	@Given("The Admin is on the Admin Login Page to login so they can go to the Admin Home Page to see all the tickets")
	public void the_admin_is_on_the_admin_login_page_to_login_so_they_can_go_to_the_admin_home_page_to_see_all_the_tickets() {
		driver.get("http://localhost:8030/AdminLoginPage.html");
	}

	// WHEN THE ADMIN TYPES IN THEIR USERNAME AND PASSWORD AND CLICKS THE LOGIN
	// BUTTON
	@When("The Admin types in their {string} and {string} and clicks the Admin Login button")
	public void the_admin_types_in_their_and_and_clicks_the_admin_login_button(String username, String pass) {
		adminLoginPage.usernameInput.sendKeys(username);
		adminLoginPage.passwordInput.sendKeys(pass);
		adminLoginPage.loginButton.click();
	}

	// THEN THE ADMIN SHOULD BE ON THE ADMIN HOME PAGE WITH ALL THE TICKETS
	// AVAILABLE
	@Then("The Admin should be on the Admin Home Page with all the tickets")
	public void the_admin_should_be_on_the_admin_home_page_with_all_the_tickets() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Admin Home Page"));
		assertEquals("Admin Home Page", driver.getTitle());
	}
}