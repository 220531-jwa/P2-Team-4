package dev.team4.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.UpdateFlightPricePage;
import dev.team4.runners.UpdateFlightPriceRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateFlightPriceStepsImpl {
	
	private WebDriver driver = UpdateFlightPriceRunner.driver;
	private UpdateFlightPricePage updateFlightPricePage = UpdateFlightPriceRunner.updateFlightPricePage;
	
	
	@Given("the admin is on the adminSetDiscount.html Page")
	public void the_admin_is_on_the_admin_set_discount_html_page() {
		driver.get("http://localhost:8041/adminSetDiscount.html");
	}

	@When("the Admin enter in the {string}> and {string} and clicks the submit button")
	public void the_admin_enter_in_the_and_and_clicks_the_submit_button(String flightid, String price) {
		updateFlightPricePage.flightIDInput.sendKeys(flightid);
		updateFlightPricePage.flightPriceInput.sendKeys(price);
		updateFlightPricePage.submitButton.click();
	}

	@Then("the Admin should be able to see the price changed in the Admin Home Page and back to AdminHomePage")
	public void the_admin_should_be_able_to_see_the_price_changed_in_the_admin_home_page_and_back_to_admin_home_page() {
		new WebDriverWait(driver, Duration.ofSeconds(5))
       // .until(ExpectedConditions.titleContains("Admin Landing Page"));
		.until(ExpectedConditions.titleContains("Admin Edit price Page"));

	  assertEquals("Admin Edit price Page", driver.getTitle());
	}
}
