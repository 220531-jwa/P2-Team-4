package dev.team4.runners;

import dev.team4.pages.UserLoginPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

@Suite
public class UserLoginRunner {
    public static WebDriver driver;
    public static UserLoginPage userLoginPage;

    @BeforeAll
    public static void setup() {
        File chrome = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        driver = new ChromeDriver();

        userLoginPage = new UserLoginPage(driver);
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }


}
