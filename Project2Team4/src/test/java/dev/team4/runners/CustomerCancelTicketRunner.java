// PACKAGE
package dev.team4.runners;

// IMPORTS
import java.io.File;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.team4.pages.CustomerCancelTicketPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// CONNECTION TO CUCUMBER
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "dev.team4.steps")

// CLASS
public class CustomerCancelTicketRunner {

	// CONNECTION TO SELENIUM WEB DRIVER
	public static WebDriver driver;

	// CONNECTION TO CustomerCancelTicketPage
	public static CustomerCancelTicketPage customerCancelTicketPage;

	// START CHROME DRIVER CONNECTION
	@BeforeAll
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
		customerCancelTicketPage = new CustomerCancelTicketPage(driver);
	}

	// END CHROME DRIVER CONNECTION
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
}