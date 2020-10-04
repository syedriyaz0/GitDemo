package RiyazProject;

import org.testng.annotations.Test;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pageObjects.LandingHomePage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePageTest extends Base {
	
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
		
	@Test(dataProvider="getData")
	//Parameters in method basepagenavigation should be equal to dataProvider index 	
	public void validateUserLogin(String Username,String Password,String text) throws IOException
	{
		
		driver.get(prop.getProperty("url")); //Calling Base class object globle variable name
		log.info("Navigated to home page url");
		//Creating an object for LandingPage class
		LandingHomePage lp= new LandingHomePage(driver);
		
		lp.getLogin().click();
		log.info("Successfully clicked on LoginButton");
		
		
		//Creating an object for LoginPage class
		LoginPage lg= new LoginPage(driver);
				
		lg.userName().sendKeys(Username);
		log.info("Successfully entered username");
		lg.userPassword().sendKeys(Password);
		log.info("Successfully entered password");
		//System.out.println(text);	
		lg.loginSubmitButton().click();
		log.info("Successfully clicked on SubmitButton");
		
	}
	
	//This is for closing the browser aftertest execution
			@AfterTest
			public void teardown()
			{
				driver.close();
				log.info("Successfully closed the browser");
			}
		
	
	//Introducing TestNG @DataProvider annotation
	@DataProvider
	public Object[][] getData()
	{
		//Rows stand for how many different data types test should run
		//Column stand for how many values for each test
		
		//Array size is 2
		Object[][] data=new Object[2][3]; //object is with 2-rows and 3-columns
		//0th row
		data[0][0]="nonrestricteduser@gmail.com";
		data[0][1]="123456879";
		data[0][2]="Non Restricted user";
		
		//1st row
		data[1][0]="restricteduser@gmail.com";
		data[1][1]="9874563210";
		data[1][2]="Restricted user";
		
		return data;
		
	}
	
}
