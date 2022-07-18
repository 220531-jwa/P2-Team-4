package dev.team4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateFlightPricePage  {
private WebDriver driver;
	
	public UpdateFlightPricePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tId")
    public WebElement flightIDInput;

    @FindBy(id = "newprice")
    public WebElement flightPriceInput;

    @FindBy(id = "editFlightprice")
  //  @FindBy (xpath = "/html/body/button")///html/body/button
    public WebElement submitButton;
}
