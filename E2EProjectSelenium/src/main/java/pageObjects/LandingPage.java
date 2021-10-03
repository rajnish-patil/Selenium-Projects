package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	private By signin = By.cssSelector("div.tools:nth-child(2) div.container-fluid nav.pull-right ul:nth-child(1) li:nth-child(4) a:nth-child(1) > span:nth-child(2)");
	private By title=By.cssSelector(".text-center>h2");
	private By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	private By header=By.cssSelector("div[class*='video-banner'] h3");

	//constructor
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getLogin() 
	{
		return driver.findElement(signin);
	}
	public WebElement getTitle() 
	{
		return driver.findElement(title);
	}
	public WebElement getNavigationBar() 
	{
		return driver.findElement(NavBar);
	}
	public WebElement getHeader() 
	{
		return driver.findElement(header);
	}
	
}
