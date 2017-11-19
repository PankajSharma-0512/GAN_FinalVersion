package core_framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentTest;

import core_keyword.Keyword;

public class Launch_browser  {

	public WebDriver driver;
	public WebDriver Launchbrowser(String browser, String url) {
	
		if(browser.equalsIgnoreCase("Mozilla")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver= new FirefoxDriver();
			}
		
		else if(browser.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
						}
		else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			DesiredCapabilities cap= new DesiredCapabilities();
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);
			driver= new InternetExplorerDriver();
		}
		
		else if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
			}
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
