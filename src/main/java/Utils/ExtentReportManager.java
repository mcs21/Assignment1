package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReportManager 
{

	public static ExtentReports report;
    
    public static ExtentReports getReportInstance()
    {
   	 if(report==null)
   	 {
   		 ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport/testreport.html");
   		 report=new ExtentReports();
   		 report.attachReporter(htmlReporter);
   		 
   		 //Any Kind of System Information whatever you want
   		 report.setSystemInfo("User Name", "Surajkumar Pandit");
   		 report.setSystemInfo("OS", "Windows 10");
   		 report.setSystemInfo("Enviornment", "UAT");
   		 report.setSystemInfo("Build No", "10.8.1");
   		 
   		 
   		 
   		 htmlReporter.config().setDocumentTitle("Display Bookshelves Report");
   		 htmlReporter.config().setReportName("Final Reports");
   		 htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
   		 htmlReporter.config().setTimeStampFormat("dd-MMM-yyyy hh:mm:ss a");	 
   	 } 
   	 
   	 return report;
   	 
    }
}
