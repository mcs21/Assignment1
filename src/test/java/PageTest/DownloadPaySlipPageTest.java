package PageTest;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.DownloadPaySlipPage;

public class DownloadPaySlipPageTest extends DownloadPaySlipPage
{

	@BeforeMethod
	public void setUp() 
	{
		invokeBrowser();
		openURL();		
	}
	

	@Test
	public void BookshlevesTest() throws InterruptedException, IOException 
	{
		payslips();
	}

	@AfterMethod
	public void close()
	{
		quitBrowser();
	}
}
