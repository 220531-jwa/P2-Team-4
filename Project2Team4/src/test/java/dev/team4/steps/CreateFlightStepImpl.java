// PACKAGE
package dev.team4.steps;

//IMPORTS
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.CreateFlightPage;
import dev.team4.runners.CreateFlightRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// CLASS
public class CreateFlightStepImpl {

	// CONNECTION TO SELENIUM WEB DRIVER AND CreateFlightRunner.java
	private final WebDriver driver = CreateFlightRunner.driver;

	// CONNECTION TO CreateFlightPage.java AND CreateFlightRunner.java
	private final CreateFlightPage createFlightPage = CreateFlightRunner.createFlightPage;

	// GIVEN AN ADMIN IS ON THE CreateFlightPage
	@Given("a Admin is on the CreateFlightPage")
	public void a_admin_is_on_the_create_flight_page() {
		this.driver.get("http://localhost:8080/newFlight.html");
	}

	// WHEN THE ADMIN TYPES IN THEIR CREDENTIALS
	@When("the Admin types in the {string}, {string}, and {string} and clicks the CreateFlightButton")
	public void the_admin_types_in_the_airline_arrival(String airline, String arrival, String departure) {
		createFlightPage.airlineInput.sendKeys(airline);
		createFlightPage.arrivingTimeInput.sendKeys(arrival);
		createFlightPage.departingTimeInput.sendKeys(departure);
		createFlightPage.submit.click();
	}

	// THEN THE ADMIN IS ON THE HOMEPAGE
	@Then("the Admin is back on the HomePage")
	public void the_admin_is_back_on_home_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Admin Landing Page"));
		assertEquals("Admin Landing Page", driver.getTitle());
	}
}