package dev.team4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateFlightLocationDescriptionPage 
{
	private WebDriver driver;
	
	public UpdateFlightLocationDescriptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "flightId")
    public WebElement flightID;

    @FindBy(id = "flightDescription")
    public WebElement flightDescriptionInput;

    @FindBy(id = "editFlightDescription")
    public WebElement submitButton;
}
