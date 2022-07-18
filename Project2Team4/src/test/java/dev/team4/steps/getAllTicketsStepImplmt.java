package dev.team4.steps;

import dev.team4.pages.UserLoginPage;
import dev.team4.pages.UserTicketPage;

import dev.team4.runners.UserLoginRunner;
import dev.team4.runners.UserTicketRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class getAllTicketsStepImplmt {

	
	private WebDriver driver = UserLoginRunner.driver;
	private UserLoginPage userLoginPage = UserLoginRunner.userLoginPage;
	
	
//	@Given("a Customer is on the home page can see all tickets")
//	public void a_customer_is_on_the_home_page_can_see_all_tickets() {
//		driver.get("http://localhost:8080/homePage.html"); 
//	}
//
//	@When("the Customer types in their {string} and {string} and clicks the Customer Login button")
//	public void the_customer_types_in_their_and_and_clicks_the_customer_login_button(String username, String password) 
//	{
//		
//		userLoginPage.usernameInput.sendKeys(username);
//		userLoginPage.passwordInput.sendKeys(password);
//	}
//
//	@Then("the user should be on the home page with all tickets available")
//	public void the_user_should_be_on_the_home_page_with_all_tickets_available() 
//	{
// 
//	 new WebDriverWait(driver, Duration.ofSeconds(10))
//     .until(ExpectedConditions.titleContains("Home Page"));
//
//	 assertEquals("Home Page", driver.getTitle());
//	
//	}
	
	@Given("a Customer is on the login page they can login go to customer landing page and see all ticket")
	public void a_customer_is_on_the_login_page_they_can_login_go_to_customer_landing_page_and_see_all_ticket() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8041/loginpage.html"); 
	}

	@When("the Customer types in their {string} and {string} and clicks the Login button")
	public void the_customer_types_in_their_and_and_clicks_the_login_button(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
		userLoginPage.usernameInput.sendKeys(username);
		userLoginPage.passwordInput.sendKeys(password);
		userLoginPage.loginButton.click();
	}

	@Then("the user should be on the home page with all tickets available")
	public void the_user_should_be_on_the_home_page_with_all_tickets_available() 
	{
	    // Write code here that turns the phrase above into concrete actions
		new WebDriverWait(driver, Duration.ofSeconds(5))
	     .until(ExpectedConditions.titleContains("Home Page"));

		 assertEquals("Home Page", driver.getTitle());
	}
	
	
}

