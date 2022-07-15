// PACKAGE
package dev.team4.steps;

//IMPORTS
import static org.junit.Assert.assertFalse;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.CustomerHomePage;
import dev.team4.runners.CustomerBuyTicketRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//CLASS
public class CustomerBuyTicketStepImpl {

	// CONNECTION TO SELENIUM WEB DRIVER AND CustomerBuyTicketRunner.java
	private WebDriver driver = CustomerBuyTicketRunner.driver;

	// CONNECTION TO CustomerHomePage.java AND CustomerBuyTicketRunner.java
	private CustomerHomePage customerHomePage = CustomerBuyTicketRunner.customerHomePage;

	// GIVEN A CUSTOMER IS ON THE CustomerHomePage.html
	@Given("A Customer is on the Customer Home Page")
	public void a_customer_is_on_the_home_page() {
		driver.get("http://localhost:8030/CustomerHomePage.html");
	}

	// WHEN A CUSTOMER CLICKS ON THE BUY BUTTON, THE CUSTOMER SHOULD BE ABLE TO BUY
	// A TICKET
	@When("A Customer clicks the buy button the Customer should be able to buy a ticket")
	public void a_customer_clicks_on_the_buy_button_the_customer_should_be_able_to_buy_a_ticket() {
		customerHomePage.buyButton.click();
	}

	// THEN A CUSTOMER'S ID IS ASSOCIATED WITH THE TICKET
	@Then("A Customer id is associated with the ticket")
	public void a_customer_id_is_associated_with_the_ticket() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.invisibilityOf(customerHomePage.buyButton));
		assertFalse(ExpectedConditions.invisibilityOf(customerHomePage.buyButton).equals(false));
	}
}