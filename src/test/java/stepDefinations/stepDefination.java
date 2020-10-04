package stepDefinations;

import cucumber.api.java.en.Given;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingHomePage;
import pageObjects.LoginPage;
import pageObjects.PortalPageAfterLogin;
import resources.Base;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefination extends Base {

	
	
	
    @Given("^Initialize the borwser with chrome$")
    public void initialize_the_borwser_with_chrome() throws Throwable {
    	driver=intializeDriver();
    }

    @And("^Navigate to \"([^\"]*)\" url$")
    public void navigate_to_something_url(String strArg1) throws Throwable {
        driver.get(strArg1);
    }

    @And("^Click on login link in homepage to land on secure sign in page$")
    public void click_on_login_link_in_homepage_to_land_on_secure_sign_in_page() throws Throwable {
    	LandingHomePage lp= new LandingHomePage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		lp.getLogin().click();
    	
    }
    
    @When("^User enter (.+) and (.+) and logs in$")
    public void user_enter_and_and_logs_in(String username, String password) throws Throwable {
        
    	LoginPage lg= new LoginPage(driver);
    	
    	lg.userName().sendKeys(username);
    	
    	lg.userPassword().sendKeys(password);
    	
    	lg.loginSubmitButton().click();
    	
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	
    	if (lg.getCaptchaText().isDisplayed())
    	{
    		lg.getCaptcha().click();
    		
    		lg.getSubmitCaptcha().click();
    	}
    	
    }

    
	

    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
       
    	//creating page object
    	PortalPageAfterLogin pp= new PortalPageAfterLogin(driver);
    	Assert.assertTrue(pp.getSearchBox().isDisplayed()); //Using Assertion for validation
    	
    }

    

}

	
