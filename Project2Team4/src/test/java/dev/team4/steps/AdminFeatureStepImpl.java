package dev.team4.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.team4.pages.UserLoginPage;
import dev.team4.runners.UserLoginRunner;

public class AdminFeatureStepImpl 
{
	private WebDriver driver = UserLoginRunner.driver;
	private UserLoginPage userLoginPage = UserLoginRunner.userLoginPage;
	
	@Given("a Admin is on the Login Page")
	public void a_admin_is_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8030/loginpage.html");
	}

	@When("the Admin types in their {string} and {string} and clicks the Login button")
	public void the_admin_types_in_their_and_and_clicks_the_login_button(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
		userLoginPage.usernameInput.sendKeys(username);
		userLoginPage.passwordInput.sendKeys(password);
		userLoginPage.loginButton.click();
	}

	@Then("the Admin should be on the Admin Homepage")
	public void the_admin_should_be_on_the_admin_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		 new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Admin Landing Page"));
		    
		    assertEquals("Admin Landing Page", driver.getTitle());
	}

}
