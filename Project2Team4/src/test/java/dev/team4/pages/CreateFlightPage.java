package dev.team4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateFlightPage {
    private WebDriver driver;

    public CreateFlightPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "airline")
    public WebElement airlineInput;

    @FindBy(id = "arriving")
    public WebElement arrivingTimeInput;

    @FindBy(id = "departing")
    public WebElement departingTimeInput;

    @FindBy(id = "submitButton")
    public WebElement submit;
}
