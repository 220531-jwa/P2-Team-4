// PACKAGE
package dev.team4.steps;

//IMPORTS
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.AdminUpdateDescriptionPage;
import dev.team4.runners.AdminUpdateDescriptionRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//CLASS
public class AdminUpdateDescriptionStepImpl {

	// CONNECTION TO SELENIUM WEB DRIVER AND UpdateDescriptionRunner.java
	private WebDriver driver = AdminUpdateDescriptionRunner.driver;

	// CONNECTION TO updateDescriptionPage AND UpdateDescriptionRunner
	private AdminUpdateDescriptionPage adminUpdateDescriptionPage = AdminUpdateDescriptionRunner.adminUpdateDescriptionPage;

	// GIVEN THE ADMIN IS ON THE ADMIN UPDATE DESCRIPTION PAGE
	@Given("The Admin is on the Admin Update Description Page")
	public void the_admin_is_on_the_admin_edit_description_page() {
		driver.get("http://localhost:8030/AdminUpdateDescriptionPage.html");
	}

	// WHEN THE ADMIN TYPES IN THE FLIGHT ID AND THE DESCRIPTION AND CLICKS THE
	// UPDATE BUTTON
	@When("The Admin types in the {string} and {string} and clicks the update button")
	public void the_admin_types_in_the_and_and_clicks_the_update_button(String fid, String description) {
		adminUpdateDescriptionPage.fidInput.sendKeys(fid);
		adminUpdateDescriptionPage.descriptionInput.sendKeys(description);
		adminUpdateDescriptionPage.updateButton.click();

	}

	// THEN THE ADMIN SHOULD BE ABLE TO SEE THE DESCRIPTION CHANGED IN THE ADMIN
	// HOME PAGE.
	@Then("The Admin should be able to see the description changed in the Admin Home Page")
	public void the_admin_should_be_able_to_see_the_description_changed_in_the_admin_home_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Admin Home Page"));
		assertEquals("Admin Home Page", driver.getTitle());
	}
}