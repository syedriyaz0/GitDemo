package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class PortalPageAfterLogin extends Base {

	//First step to create a global variable for driver
		public WebDriver driver;
		
		//Second step to create a contructor for driver object with parameter
		public PortalPageAfterLogin (WebDriver driver)
		{
			this.driver=driver;
		}
	
	
		
		//creating page object model normal pattern
		By searchbox = By.id("search-courses");
		
		
		//creating the methods with return
		public WebElement getSearchBox()
		{
			return driver.findElement(searchbox);
		}
		
	
}
