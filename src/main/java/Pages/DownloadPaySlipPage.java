package Pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BaseClass;
import Utils.ExtentReportManager;

public class DownloadPaySlipPage extends BaseClass
{
	
	ExtentReports report=ExtentReportManager.getReportInstance();
	ExtentTest logger=report.createTest("Test-1:Download Payslips");
	
	public void payslips() throws InterruptedException, IOException
	{
		
		try 
		{		
				
				//Verify application is launched successfully and by printing the application name
				String exp_title = "OneCognizant"; 
		        String curr_window_title = driver.getTitle();
		        if(exp_title.equalsIgnoreCase(curr_window_title));
		        {
		        	System.out.println("Application is launched successfully and Application name is "+curr_window_title);
		        }
		        logger.log(Status.INFO,curr_window_title+" Portal is Launched Successfully");
		        Thread.sleep(2000);
		        
		        //Take a screenshots of HomePage
		        TakesScreenshot ts = (TakesScreenshot)driver;
		        File source = ts.getScreenshotAs(OutputType.FILE);
		        FileUtils.copyFile(source, new File(System.getProperty("user.dir") +"\\Screenshots\\"+curr_window_title+".png"));
		        logger.log(Status.INFO,"Take the Screeenshots of "+curr_window_title+" Portal");
		        
		        //for scrolling window
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("window.scrollBy(0,400)");
				Thread.sleep(2000);
				
				//Locate and click on Download Payslips
				driver.findElement(By.xpath("//*[@class=\"quickActionAppName\" and text()=\"Download Payslip\"]")).click();
				logger.log(Status.INFO,"Click on Download Payslips");
				Thread.sleep(2000);
				
				//Verify whether the Download Payslips app is open or not
				String expectedHeading = "Download Payslip";
				String heading = driver.findElement(By.xpath("//*[@class=\"activityHeaderTitle\" and text()=\"Download Payslip\"]")).getText(); 
				Thread.sleep(2000);
		        if(expectedHeading.equalsIgnoreCase(heading));
		        {
		        	System.out.println("Application is launched successfully and Apps name is "+heading);
		        }
		        logger.log(Status.INFO,heading+" App is Opened");
				Thread.sleep(2000);
				
				//Take a screenshots of Payslips Apps
				File source1 = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source1, new File(System.getProperty("user.dir")+"\\Screenshots\\"+heading+".png"));
				logger.log(Status.INFO,"Take the Screenshots of "+heading+" App");

				//Locate the year option & click on year option
				driver.findElement(By.xpath("//*[@class=\"select-wrapper\"]")).click();
				logger.log(Status.INFO,"click on year option");
				Thread.sleep(2000);
				
				//Locate the 2022 year and click on the 2022 year
				driver.findElement(By.xpath("//*[@class=\"select-wrapper\"]//li[2]")).click();
				logger.log(Status.INFO,"click on the 2022 year");
				Thread.sleep(2000);
				
				//Locate the month option & click on month option
				driver.findElement(By.xpath("//*[@class=\"col s6 m3 input-field paySlipMonth\"]")).click();
				logger.log(Status.INFO,"click on month option");
				Thread.sleep(2000);
				
				//Locate the January month and click on the January month
				driver.findElement(By.xpath("//*[@class=\"col s6 m3 input-field paySlipMonth\"]//li[3]")).click();
				logger.log(Status.INFO," click on the January month");
				Thread.sleep(2000);
				
				//for scrolling window
				js.executeScript("window.scrollBy(0,300)");
				Thread.sleep(2000);
				
				//Locate Checkbox and then click on Checkbox for attested copy
				driver.findElement(By.xpath("//*[@class=\"checkBoxCustomLabel\"]")).click();
				logger.log(Status.INFO,"Click on Checkbox for attested copy");
				Thread.sleep(2000);
				
				//Locate Download Button and click on it
				driver.findElement(By.id("paySlipDownloadbtn")).click();
				logger.log(Status.INFO,"click on Download Button to Download the Payslips");
				Thread.sleep(3000);
				
				//After Downloading its Print The message
				System.out.println("Payslip is Downloded Successfully");
				logger.log(Status.INFO,"Payslip is Downloded Successfully");
				Thread.sleep(2000);
				
				logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\"+curr_window_title+".png");
				logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\"+heading+".png");
				
				driver.findElement(By.xpath("//*[@class=\"closeActivityPopup\"]")).click();
				System.out.println("Close the Payslip Windows");
		}
		catch(Exception e)
		{
			logger.log(Status.FAIL, e.getMessage());
			Assert.fail();
		}
				
	}

}
