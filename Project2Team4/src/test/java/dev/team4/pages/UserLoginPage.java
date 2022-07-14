package dev.team4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage 
{
	private WebDriver driver;
	
	public UserLoginPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "cUname")
	public WebElement usernameInput;
	
	@FindBy(id = "cPass")
	public WebElement passwordInput;
	
	@FindBy(xpath = "/html/body/div/button")
	public WebElement loginButton;
	

}
