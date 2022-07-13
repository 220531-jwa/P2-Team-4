// PACKAGE
package dev.team4.runners;

//IMPORTS
import java.io.File;

import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.team4.pages.CreateFlightPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

//CLASS
@Suite
public class CreateFlightRunner {

	// SELENIUM WEB DRIVER
	public static WebDriver driver;

	// CONNECTION TO CreateFlightPage.java
	public static CreateFlightPage createFlightPage;

	// START CHROME DRIVER CONNECTION
	@BeforeAll
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
		createFlightPage = new CreateFlightPage(driver);
	}

	// END CHROME DRIVER CONNECTION
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
}