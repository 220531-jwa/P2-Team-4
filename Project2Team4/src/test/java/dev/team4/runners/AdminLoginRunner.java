// PACKAGES
package dev.team4.runners;

// IMPORTS
import java.io.File;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.team4.pages.AdminLoginPage;
import dev.team4.pages.CustomerLoginPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// CONNECITON TO CUCUMBER
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "dev.team4.steps")

// CLASS
public class AdminLoginRunner {

	// CONNECITON TO SELNIUM WEB DRIVER
	public static WebDriver driver;

	// CONNECTION TO CustomerLoginPage and AdminLoginPage
	public static CustomerLoginPage customerLoginPage;
	public static AdminLoginPage adminLoginPage;

	// START CHROME DRIVER CONNECTION
	@BeforeAll
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
		customerLoginPage = new CustomerLoginPage(driver);
	}

	// END CHROME DRIVER CONNECTION
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
}