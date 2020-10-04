package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	
	//Step1: Creating global variable inside a class
		public WebDriver driver;
		
		//Step2: Creating constructor with parameter WebDriver, driver 
		public ForgotPasswordPage(WebDriver driver)
		{
			this.driver=driver;
		}
		
		
		//Creating variable with Page Object patterns
		By signin=By.cssSelector("a[href*='sign_in']");
		By forgotPassword =By.cssSelector("a[href*='password/new']");
		By email =By.cssSelector("input[id='user_email']");
		By sendMeInstruction=By.cssSelector("input[value='Send Me Instruction']");
		
		
		
		//creating methods to return
		public WebElement getLogin()
		{
			return driver.findElement(signin);
		}
		
		public WebElement getClickForgotPassword() 
		{
			return driver.findElement(forgotPassword);
		}
		
		public WebElement getForgotUserEmail()
		{
			return driver.findElement(email);
		}
		
		public WebElement getSendMeInstruction()
		{
			return driver.findElement(sendMeInstruction);
		}
		
		

}
