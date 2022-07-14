package dev.team4.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.CancelTicketPage;
import dev.team4.runners.CustomerCancelTicketRunner;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CancelTicketStepImpl 
{
	private WebDriver driver = CustomerCancelTicketRunner.driver;
	private CancelTicketPage cancelTicketPage = CustomerCancelTicketRunner.cancelTicketPage;
	
	@Given("the Customer is on the Cancel Ticket Page")
	public void the_customer_is_on_the_cancel_ticket_page() 
	{
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8030/customercancelflight.html");
	}

	@When("a customer enters the {string} and clicks the submit button")
	public void a_customer_enters_the_and_clicks_the_submit_button(String ticketid) 
	{
	    // Write code here that turns the phrase above into concrete actions
		cancelTicketPage.ticketIdInput.sendKeys(ticketid);
		cancelTicketPage.submitButton.click();
	}

	@Then("a customer can be redirected to the CustomerHomePage")
	public void a_customer_can_be_redirected_to_the_customer_home_page() 
	{
		 new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Customer Landing Page"));

	     assertEquals("Customer Landing Page", driver.getTitle());
	}

	

}
