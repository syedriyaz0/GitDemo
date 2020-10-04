package RiyazProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import resources.Base;
import resources.ExtentReporterNG;

//Below implementing TestNg listeners for capaturing screen shot 
//Inheriting listeners class withe Base class so that it can access variabke of it.
public class Listeners extends Base implements ITestListener{
	
	ExtentReports extent= ExtentReporterNG.getReportsObject(); //Creating static variable to access extentreports class
	ExtentTest test;// Extentreports global level varible so it can be accessable to every method
	//TheardLocal is java method which control the methods to override from each other when test executed parallelly.
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();//wrapped with test bariable object
	
	
 //If we use testNg version >7 right click on listeners=>goto=>source=>override/implemented methods and check methods click finish
	@Override
	public void onTestStart(ITestResult result) {
		// onTestStart listener will execute first before any test execution
		test =extent.createTest(result.getMethod().getMethodName()); //this will create report for each test case before it executes
		extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//ExtentReport for html report code
		extentTest.get().fail(result.getThrowable());//This will give the fail report along with logs
		
		
		//Write screen shot capture code for any test case get failed
		WebDriver driver=null;
		String testMethodName=result.getMethod().getMethodName();//creating a method for capturing methodName
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e)
		{
			
		}
		try {
			//below code will attach screen shot in extent html report as well gets the failed method name
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();//stoping the extent report class after eact etest execution
		
	}
	
	
	
	

}
