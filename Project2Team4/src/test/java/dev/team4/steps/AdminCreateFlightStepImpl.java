// PACKAGE
package dev.team4.steps;

//IMPORTS
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.AdminCreateFlightPage;
import dev.team4.runners.AdminCreateFlightRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// CLASS
public class AdminCreateFlightStepImpl {

	// CONNECTION TO SELENIUM WEB DRIVER AND AdminCreateFlightRunner.java
	private final WebDriver driver = AdminCreateFlightRunner.driver;

	// CONNECTION TO AdminCreateFlightPage.java AND AdminCreateFlightRunner.java
	private final AdminCreateFlightPage adminCreateFlightPage = AdminCreateFlightRunner.adminCreateFlightPage;

	// GIVEN AN ADMIN IS ON THE AdminCreateFlightPage
	@Given("The Admin is on the Admin Create Flight Page")
	public void the_admin_is_on_the_admin_create_flight_page() {
		this.driver.get("http://localhost:8030/AdminCreateFlight.html");
	}

	// WHEN THE ADMIN TYPES IN THEIR CREDENTIALS
	@When("The Admin types in the {string}, {string}, and {string} and clicks the Create Flight Button")
	public void the_admin_types_in_the_airline_arrival_and_departure_and_clicks_the_create_flight_button(String airline,
			String arrival, String departure) {
		adminCreateFlightPage.airlineInput.sendKeys(airline);
		adminCreateFlightPage.arrivingTimeInput.sendKeys(arrival);
		adminCreateFlightPage.departingTimeInput.sendKeys(departure);
		adminCreateFlightPage.createButton.click();
	}

	// THEN THE ADMIN IS ON THE ADMIN HOME PAGE
	@Then("The Admin is back on the Admin Home Page")
	public void the_admin_is_back_on_the_admin_home_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Admin Home Page"));
		assertEquals("Admin Home Page", driver.getTitle());
	}
}