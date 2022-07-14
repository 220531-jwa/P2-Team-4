package dev.team4.runners;

import dev.team4.pages.CreateFlightPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

@Suite
public class CreateFlightRunner {
    public static WebDriver driver;
    public static CreateFlightPage createFlightPage;

    @BeforeAll
    public static void setup() {
        File chrome = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        driver = new ChromeDriver();
        createFlightPage = new CreateFlightPage(driver);
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }
}
