package dev.team4.runners;
import java.io.File;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.team4.pages.UpdateFlightLocationDescriptionPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "dev.team4.steps")
public class UpdateFlightLocationDescriptionRunner 
{
	public static WebDriver driver;
	public static UpdateFlightLocationDescriptionPage updateFlightLocationDescriptionPage;
	
	@BeforeAll
	public static void setup()
	{
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
		
		updateFlightLocationDescriptionPage = new UpdateFlightLocationDescriptionPage(driver);
	}
	
	@AfterAll
	public static void teardown() 
	{
		driver.quit();
	}

}
