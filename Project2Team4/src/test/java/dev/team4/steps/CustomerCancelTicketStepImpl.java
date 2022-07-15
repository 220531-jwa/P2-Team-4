// PACKAGE
package dev.team4.steps;

//IMPORTS
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.CustomerCancelTicketPage;
import dev.team4.runners.CustomerCancelTicketRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// CLASS
public class CustomerCancelTicketStepImpl {

	// CONNECTION TO SELENIUM WEB DRIVER AND CustomerCancelTicketRunner
	private WebDriver driver = CustomerCancelTicketRunner.driver;

	// CONNECTION TO CustomerCancelTicketPage AND CustomerCancelTicketRunner
	private CustomerCancelTicketPage customerCancelTicketPage = CustomerCancelTicketRunner.customerCancelTicketPage;

	// GIVEN A CUSTOMER IS ON THE CUSTOMER CANCEL TICKET PAGE
	@Given("A Customer is on the Customer Cancel Ticket Page")
	public void a_customer_is_on_the_customer_cancel_ticket_page() {
		driver.get("http://localhost:8030/CustomerCancelTicket.html");
	}

	// WHEN A CUSTOMER ENTERS THE TICKET ID AND CLICKS THE CANCEL BUTTON
	@When("A Customer enters the {string} and clicks the cancel button")
	public void a_customer_enters_the_and_clicks_the_cancel_button(String ticketid) {
		customerCancelTicketPage.ticketIdInput.sendKeys(ticketid);
		customerCancelTicketPage.cancelButton.click();
	}

	// THEN A CUSTOMER CAN BE REDIRECTED TO THE CUSTOMER HOME PAGE
	@Then("A customer can be redirected to the Customer Home Page")
	public void a_customer_can_be_redirected_to_the_customer_home_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Customer Home Page"));
		assertEquals("Customer Home Page", driver.getTitle());
	}
}