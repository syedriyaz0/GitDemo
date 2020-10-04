package RiyazProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import resources.Base;

public class validationForgotPasswordPage extends Base{
	
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
		public void validateForgotPassword()
		{
			//Create an object for validationForgotPasswordPage class
			ForgotPasswordPage fp=new ForgotPasswordPage(driver);
			
			fp.getLogin().click();
			log.info("Successfully clicked on login");
			
			fp.getClickForgotPassword().click();
			log.info("Sucessfully clicked on forgot password link");
			
			fp.getForgotUserEmail().sendKeys(prop.getProperty("email")); //email is brinfing from data.properties file
			log.info("Successfully entered user email");
			
			fp.getSendMeInstruction().click();
			log.info("Successfully clicked on sendMeIntructionButton");
			
			
		}
		
		
		
		//This is for closing the browser aftertest execution
		@AfterTest
		public void teardown()
		{
			driver.close();
			log.info("Successfully closed the browser");
		}
		
		

}
