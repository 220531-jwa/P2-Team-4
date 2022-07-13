package dev.team4.steps;

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

public class UpdateFlightLocationDescriptionStepImpl 
{
	private WebDriver driver = UpdateFlightLocationDescriptionRunner.driver;
	private UpdateFlightLocationDescriptionPage updateFlightLocationDescriptionPage = UpdateFlightLocationDescriptionRunner.updateFlightLocationDescriptionPage;
	
	@Given("the administrator is on the Admin Edit Description Page")
	public void the_administrator_is_on_the_admin_edit_description_page() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get("http://localhost:8040/adminEditFlightDescPage.html");
	}

	@When("the Admin types in the {string} and {string} and clicks the submit button")
	public void the_admin_types_in_the_and_and_clicks_the_submit_button(String flightid, String flightdescription) {
	    // Write code here that turns the phrase above into concrete actions
		updateFlightLocationDescriptionPage.flightID.sendKeys(flightid);
		updateFlightLocationDescriptionPage.flightDescriptionInput.sendKeys(flightdescription);
		updateFlightLocationDescriptionPage.submitButton.click();
	    
	}

	@Then("the Admin should be able to see the description changed in the Admin Home Page")
	public void the_admin_should_be_able_to_see_the_description_changed_in_the_admin_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.titleContains("Admin Landing Page"));

		assertEquals("Admin Landing Page", driver.getTitle());
	}

}
