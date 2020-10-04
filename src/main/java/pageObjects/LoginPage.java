package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	//First step to create a global variable for driver
	public WebDriver driver;
	
	//Second step to create a contructor for driver object with parameter
	public LoginPage (WebDriver driver)
	{
		this.driver=driver;
	}
	

	//creating page object model normal pattern
	By username=By.cssSelector("input[id='user_email']");
	By password=By.cssSelector("input[id='user_password']");
	By submit=By.cssSelector("input[type='submit']");
	By iamhuman=By.id("checkbox-label");
	By captcha=By.id("checkbox");
	By submitCaptcha=By.cssSelector("input[id='hcaptcha_submit']");

	
	//creating the methods with return
	public WebElement userName()
	{
		return driver.findElement(username);
	}
	
	public WebElement userPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement loginSubmitButton()
	{
		return driver.findElement(submit);
	}
	
	public WebElement getCaptchaText()
	{
		return driver.findElement(iamhuman);
	}
	
	public WebElement getCaptcha()
	{
		return driver.findElement(captcha);
	}
	
	public WebElement getSubmitCaptcha()
	{
		return driver.findElement(submitCaptcha);
	}
	
}
