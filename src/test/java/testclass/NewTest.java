package testclass;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BrowserFactory;

public class NewTest {
	@BeforeTest
	public void OpenBrowser() throws InterruptedException   {
		BrowserFactory sharedins = BrowserFactory.getBrowserIns();
		
		 sharedins.launchChromeDriver();
		
	}
	
	
  @Test
  public void getAllLinks() {
	  
	  BrowserFactory sharedins = BrowserFactory.getBrowserIns();
		
	  Assert.assertEquals(sharedins.getAllLinks(), true);				
	  
  }
	


	@AfterTest
	public void closeBrowser() {
		BrowserFactory sharedins = BrowserFactory.getBrowserIns();
			
		 sharedins.closeBrowser();
	}
	
}
