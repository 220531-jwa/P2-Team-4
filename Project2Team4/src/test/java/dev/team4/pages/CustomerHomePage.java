package dev.team4.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CustomerHomePage 
{

	private WebDriver driver;
	
	public CustomerHomePage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/button")
	public WebElement buyButton;
	
}
