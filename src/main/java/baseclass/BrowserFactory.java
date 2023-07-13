package baseclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {
	private static BrowserFactory browserIns = null;
	public static WebDriver driver = null;
	private BrowserFactory() {
				
	}
	
	public static BrowserFactory getBrowserIns() {
		if(browserIns == null) {
			browserIns = new BrowserFactory();
		}
		return browserIns;
	}
	
	public void  launchChromeDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/siva/Documents/WMB/SelBasics/Drivers/chromedriver");
		ChromeOptions options = new ChromeOptions();
		
		
	 driver = new ChromeDriver(options);
		
		driver.get("http://www.westmorebeauty.com");	

	}

	public static void  launchFireFoxDriver() {
		
		System.setProperty("webdriver.gecko.driver","/Users/siva/Documents/WMB/SelBasics/Drivers/geckodriver");
		
		
		driver = new FirefoxDriver();
		
		driver.get("http://www.westmorebeauty.com");	
		driver.navigate().to("https://www.proactiv.com/");
		
		
		String title = driver.getTitle();
		System.out.println("Web page title is ======"+ title);
		System.out.println("Web page getCurrentUrl is ======"+ driver.getCurrentUrl());
		System.out.println("Web page getPageSource is ======"+ driver.getPageSource());

		driver.manage().window().maximize();
		System.out.println("Web page getClass is ======"+ driver.getClass());
		
		
		
		
	}
	
	
	public void closeBrowser() {
		if(driver!= null)
			driver.close();
	}
	

	public boolean getAllLinks() {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		int count = links.size();
		
		System.out.println("Number of links are:"+count);
		
				for(int i=0; i<count; i++) {
					
					System.out.println(links.get(i).getText());
				}
			
				return true;	
	}
}

