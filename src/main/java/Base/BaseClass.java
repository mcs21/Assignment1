package Base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import com.aventstack.extentreports.ExtentReports;

import Utils.ExtentReportManager;

public class BaseClass 
{
	
	
	public static WebDriver driver;

	ExtentReports report = ExtentReportManager.getReportInstance();

	// Open Browser Dynamically
	public void invokeBrowser() 
	{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\src\\test\\resources\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("debuggerAddress", "localhost:5656");
			driver = new ChromeDriver(options);
	}

	// Open URL
	public void openURL() 
	{
		driver.get("https://onecognizant.cognizant.com/");
	}

	// Quit Browser
	public void quitBrowser() {
		report.flush();
		driver.quit();
	}

}
