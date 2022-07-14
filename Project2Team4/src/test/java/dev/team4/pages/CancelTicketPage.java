package dev.team4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelTicketPage 
{
	private WebDriver driver;

    public CancelTicketPage(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ticketId")
    public WebElement ticketIdInput;

    @FindBy(id = "cancelTicketButton")
    public WebElement submitButton;

}
