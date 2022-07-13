// PACKAGE
package dev.team4.steps;

//IMPORTS
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.UpdateFlightLocationDescriptionPage;
import dev.team4.runners.UpdateFlightLocationDescriptionRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//CLASS
public class UpdateFlightLocationDescriptionStepImpl {

	// CONNECTION TO SELENIUM WEB DRIVER AND
	// UpdateFlightLocationDescriptionRunner.java
	private WebDriver driver = UpdateFlightLocationDescriptionRunner.driver;

	// CONNECTION TO UpdateFlightLocationDescriptionPage.java AND
	// UpdateFlightLocationDescriptionRunner.java
	private UpdateFlightLocationDescriptionPage updateFlightLocationDescriptionPage = UpdateFlightLocationDescriptionRunner.updateFlightLocationDescriptionPage;

	// GIVEN THE ADMIN IS ON THE ADMIN EDIT DESCRIPTION PAGE
	@Given("the administrator is on the Admin Edit Description Page")
	public void the_administrator_is_on_the_admin_edit_description_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8040/adminEditFlightDescPage.html");
	}

	// WHEN THE ADMIN TYPES IN THEIR CREDENTIALS AND CLICKS ON THE SUBMIT BUTTON
	@When("the Admin types in the {string} and {string} and clicks the submit button")
	public void the_admin_types_in_the_and_and_clicks_the_submit_button(String flightid, String flightdescription) {
		// Write code here that turns the phrase above into concrete actions
		updateFlightLocationDescriptionPage.flightID.sendKeys(flightid);
		updateFlightLocationDescriptionPage.flightDescriptionInput.sendKeys(flightdescription);
		updateFlightLocationDescriptionPage.submitButton.click();

	}

	// THEN THE ADMIN SHOULD BE ABLE TO SEE THE DESCRIPTION CHANGED IN THE ADMIN
	// HOME PAGE.
	@Then("the Admin should be able to see the description changed in the Admin Home Page")
	public void the_admin_should_be_able_to_see_the_description_changed_in_the_admin_home_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Admin Landing Page"));
		assertEquals("Admin Landing Page", driver.getTitle());
	}
}