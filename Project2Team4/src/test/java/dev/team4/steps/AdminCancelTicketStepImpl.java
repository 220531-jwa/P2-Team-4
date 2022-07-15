// PACKAGE
package dev.team4.steps;

//IMPORTS
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.AdminCancelTicketPage;
import dev.team4.runners.AdminCancelTicketRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// CLASS
public class AdminCancelTicketStepImpl {

	// CONNECTION TO SELENIUM WEB DRIVER AND AdminCancelTicketRunner
	private WebDriver driver = AdminCancelTicketRunner.driver;

	// CONNECTION TO AdminCancelTicketPage AND AdminCancelTicketRunner
	private AdminCancelTicketPage adminCancelTicketPage = AdminCancelTicketRunner.adminCancelTicketPage;

	// GIVEN THE ADMIN IS ON THE ADMIN CANCEL TICKET PAGE
	@Given("The Admin is on the Admin Cancel Ticket Page")
	public void the_admin_is_on_the_admin_cancel_ticket_page() {
		driver.get("http://localhost:8030/AdminCancelTicket.html");
	}

	// WHEN THE ADMIN ENTERS THE TICKET ID AND CLICKS THE CANCEL BUTTON
	@When("The Admin enters the {string} and clicks the cancel button")
	public void the_admin_enters_the_and_clicks_the_cancel_button(String ticketid) {
		adminCancelTicketPage.ticketIdInput.sendKeys(ticketid);
		adminCancelTicketPage.cancelButton.click();
	}

	// THEN THE ADMIN CAN BE REDIRECTED TO THE ADMIN HOME PAGE
	@Then("The Admin can be redirected to the Admin Home Page")
	public void the_admin_can_be_redirected_to_the_admin_home_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Admin Home Page"));
		assertEquals("Admin Home Page", driver.getTitle());
	}
}