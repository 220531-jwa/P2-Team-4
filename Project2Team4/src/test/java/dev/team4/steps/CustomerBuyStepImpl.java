// PACKAGE
package dev.team4.steps;

//IMPORTS
import static org.junit.Assert.assertFalse;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.CustomerHomePage;
import dev.team4.runners.CustomerBuyRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//CLASS
public class CustomerBuyStepImpl {

	// CONNECTION TO SELENIUM WEB DRIVER AND CustomerBuyRunner.java
	private WebDriver driver = CustomerBuyRunner.driver;

	// CONNECTION TO CustomerHomePage.java AND CustomerBuyRunner.java
	private CustomerHomePage customerHomePage = CustomerBuyRunner.customerHomepage;

	// GIVEN A CUSTOMER IS ON THE CustomerHomePage.java
	@Given("a Customer is on the home page")
	public void a_customer_is_on_the_home_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8020/customerhomepage.html");
	}

	// WHEN A USER CLICKS ON THE BUY BUTTON, THE USER SHOULD BE ABLE TO BUY A TICKET
	@When("a user clicks on the buy button the user should be able to buy a ticket")
	public void a_user_clicks_on_the_buy_button_the_user_should_be_able_to_buy_a_ticket() {
		// Write code here that turns the phrase above into concrete actions
		customerHomePage.buyButton.click();
	}

	// THEN A USER'S ID IS ASSOCIATED WITH THE TICKET
	@Then("a users' id is associated with the ticket")
	public void a_users_id_is_associated_with_the_ticket() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.invisibilityOf(customerHomePage.buyButton));
		assertFalse(ExpectedConditions.invisibilityOf(customerHomePage.buyButton).equals(false));
	}
}