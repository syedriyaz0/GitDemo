package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	//1.Here creating a method to invoke browsers by using global data parameterizing file, so that we use different browser to run test case
	//2.Create file in main src so that it can access the data, and name it as data.properties
	//3. In fileinpustream object parameter give the data.properties file location path what we created.
	
		public WebDriver driver; //declaring object as global variable so that it can be accessbel in each method.
		public Properties prop; //declaring object as global variable so that it can be accesssble.
		
	public WebDriver intializeDriver() throws IOException
	{
		 prop= new Properties();//creating object with properties class
		 
		 //For dynamic paths file location use java code: System.getProperty("user.dir") in parameter
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");//For we need to create a file were it can grap the data
		
		prop.load(fis);// Here we are giving properties object, knowledge of data.properties file
		
		//Maven Browser optimizing and command mvn test -Dbrowser=chrome
		//String browserName=System.getProperty("browser");
		
		String browserName=prop.getProperty("browser"); //giving browser input from data.properties file
		System.out.println(browserName);
		
		if(browserName.contains("chrome"))
		{
			//give the path for chrome driver and declare webdriver object
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\java\\resources\\chromedriver.exe");
			//To run headless chrome creating object with ChromeOptions method
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless"))
					{
						options.addArguments("headless");//giving argument as headless to run
					}
			driver=new ChromeDriver(options);// using driver as global variable name
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//give the path for firefox driver and declare webdriver object
			System.setProperty("webdriver.gecko.driver", ".\\src\\main\\java\\resources\\geckodriver.exe");
			driver= new FirefoxDriver(); //using driver as global variable name 
		}
		else if(browserName=="IE")
		{
			//give the path for IE driver and declare webdriver object
			
		}
		
		//Declaring global implicit wait time for every testcases 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;  //giving return type as webdriver
		
	}
	
	//For screen capturing need to import maven dependency apache.commons IO
	//ScreeenSHot capture mehod
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver; //creating an object of screen capture
		File source =ts.getScreenshotAs(OutputType.FILE);//It will store the screen caprure virtually
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
		return destinationFile;
	}
	
	
}
