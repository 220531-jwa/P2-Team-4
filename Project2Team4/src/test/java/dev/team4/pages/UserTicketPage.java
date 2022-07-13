package dev.team4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTicketPage {

	private WebDriver driver;

    public UserTicketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

// <button class="btn btn-primary" id="createRequest">Buy Ticket</button>
    

   // @FindBy(xpath = "/html/body/div/button")   
    @FindBy(xpath = "/html/body/div/button") 
    public WebElement BuyButton;
    
}
