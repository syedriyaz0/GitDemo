package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;//Global variable with static method
	
	//creating method for Html extentReporter
	public static ExtentReports getReportsObject() 
	{
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		//ExtentReports, ExtentSparkReporter -> This are classes Need to create object for this class
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		
		//EXtentReports object creartion with class
		 extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Riyaz"); 
		
		return extent;
	}

}
