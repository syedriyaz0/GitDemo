package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingHomePage {
	
	//Creating global variable inside a class
	public WebDriver driver;
	
	//Creating constructor with arguments so that it gives life to driver variable
	public LandingHomePage(WebDriver driver) {

		this.driver=driver;
	}
	
	
	//Creating a PAGE OBJECT Patterns normal
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector(".text-center>h2");
	By navbar=By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	By headertitle=By.cssSelector("div[class*='video-banner'] h3");
	
	
	

	//Creating the method to return
	public WebElement getLogin()
	{
		
		return driver.findElement(signin);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}

	public WebElement getNavigationbar()
	{
		return driver.findElement(navbar);
	}
	
	public WebElement getHeaderTitle()
	{
		return driver.findElement(headertitle);
	}
	
}
