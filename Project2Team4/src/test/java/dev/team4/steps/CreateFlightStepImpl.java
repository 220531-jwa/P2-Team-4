package dev.team4.steps;

import dev.team4.pages.CreateFlightPage;
import dev.team4.runners.CreateFlightRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateFlightStepImpl {
    private final WebDriver driver = CreateFlightRunner.driver;
    private final CreateFlightPage createFlightPage = CreateFlightRunner.createFlightPage;

    @Given("a Admin is on the CreateFlightPage")
    public void a_admin_is_on_the_create_flight_page() {
        this.driver.get("http://localhost:8080/newFlight.html");
    }

    @When("the Admin types in the {string}, {string}, and {string} and clicks the CreateFlightButton")
    public void the_admin_types_in_the_airline_arrival(String airline, String arrival, String departure) {
        createFlightPage.airlineInput.sendKeys(airline);
        createFlightPage.arrivingTimeInput.sendKeys(arrival);
        createFlightPage.departingTimeInput.sendKeys(departure);
        createFlightPage.submit.click();
    }

    @Then("the Admin is back on the HomePage")
    public void the_admin_is_back_on_home_page() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.titleContains("Admin Landing Page"));

        assertEquals("Admin Landing Page", driver.getTitle());
    }
}
