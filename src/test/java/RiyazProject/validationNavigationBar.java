package RiyazProject;

import org.testng.annotations.Test;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;

import pageObjects.LandingHomePage;
import resources.Base;

public class validationNavigationBar extends Base {

	//Log4j needs to created and in LogManager.getLogger(Base class name- need to be added following with .class.getName());
		public static Logger log =LogManager.getLogger(Base.class.getName());
		
		//Accessing and copying WebDriver driver global variable from Base class
		public WebDriver driver;
	
	//BeforeTest will invoke browser and url init.
	@BeforeTest
	public void browserinvoke() throws IOException
	{
		driver=intializeDriver(); //Calling Base class method name with return driver
		log.info("Driver is initialize");
		
		driver.get(prop.getProperty("url")); //Calling Base class object globle variable name
		log.info("Navigated to home page url");
		
	}
	
	@Test
	//Parameters in method basepagenavigation should be equal to dataProvider index 	
	public void validateNavigationBarDisplayed()
	{
		
		
		//Creating an object for LandingPage class
		LandingHomePage lp= new LandingHomePage(driver);
		
		//This assertion helps us to validate the particuler webelement
		//Using assertion Assert.asserTrue()| isDisplayed() bolean condition in assertion parameter
		Assert.assertTrue(lp.getNavigationbar().isDisplayed());
		log.info("Successfully displayed navigation bar");
		
	}
	
	//This is for closing the browser aftertest execution
	@AfterTest
	public void teardown()
	{
		driver.close();
		log.info("Successfully closed the browser");
	}
	
	
}
