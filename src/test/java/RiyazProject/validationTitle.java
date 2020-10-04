package RiyazProject;

import org.testng.annotations.Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.LandingHomePage;
import resources.Base;

public class validationTitle extends Base {

	//Log4j needs to created and in LogManager.getLogger(Base class name- need to be added following with .class.getName());
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	//Accessing and copying WebDriver driver global variable from Base class
	public WebDriver driver;
	
	LandingHomePage lp; //Creating a global variable object and declared of LandingPage class
	
	//BeforeTest will invoke browser and url init.
			@BeforeTest
			public void browserinvoke() throws IOException
			{
				driver=intializeDriver(); //Calling Base class method name with return driver
				log.info("Driver is initialize"); //Log4j included logs need to generate in separate file
				
				driver.get(prop.getProperty("url")); //Calling Base class object globle variable name
				log.info("Navigated to home page url"); //Log4j included logs need to generate in separate file
			}
	
	@Test
	//Parameters in method basepagenavigation should be equal to dataProvider index 	
	public void validateTitleLandingPage() throws IOException
	{
		
		//Creating an object for LandingPage class
		lp= new LandingHomePage(driver);
		//compare the text from the browser with actual text.--Error
		
		//For comapring or doing any validation we are using assertions Assert.assertEquals(actual, Expected)
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES123");
		log.info("Successfully validated text message");
		//Assertions Assert.assertTrue(condition)
		
		
	}
	
	@Test
	//Parameters in method basepagenavigation should be equal to dataProvider index 	
	public void validateHeaderTitle() throws IOException
	{
		
		//Creating an object for LandingPage class
		lp= new LandingHomePage(driver);
		//compare the text from the browser with actual text.--Error
		
		//For comapring or doing any validation we are using assertions Assert.assertEquals(actual, Expected)
		Assert.assertEquals(lp.getHeaderTitle().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Successfully validatedHeaderTitle text message");
		//Assertions Assert.assertTrue(condition)
		
		
	}
	
	//This is for closing the browser aftertest execution
		@AfterTest
		public void teardown()
		{
			driver.close();
			log.info("Successfully closed the browser");
		}
	
	
}
