package compliance_Homepage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import core_framework.Launch_browser;
import core_keyword.Keyword;

public class userLoginvalidation extends Keyword{

	public Launch_browser lb;
	public Keyword keywords;
	public static WebDriver driver;
	public static ExtentTest test;
	
	public userLoginvalidation(){
		super(driver,test);
	}
	
	@Test
	public void user_Loginvalidation() throws InterruptedException{
		test= extent.startTest("Userloginvalidation");
		lb= new Launch_browser();
		test.log(LogStatus.INFO, "Launch Browser");
		driver= lb.Launchbrowser("chrome","https://test.gan-compliance.com/login");
		keywords = new Keyword(driver,test);
		keywords.Login("foo@foo.com", "bar");
		keywords.closebrowser();
		
	}
}
