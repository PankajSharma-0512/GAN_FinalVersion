package core_keyword;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import core_framework.ExtentReport;
import loginPage_objectresource.Loginpage_Object;

public class Keyword extends ExtentReport{

	public WebDriver driver;
	public ExtentReports extent = ExtentReport.getInstance();
	public ExtentTest test;
	public Loginpage_Object loginpageobject;

	
	public Keyword(WebDriver tdriver, ExtentTest test){
		driver=tdriver;
		loginpageobject= PageFactory.initElements(driver, Loginpage_Object.class);
		this.test= test;
	}
	
	public void Login(String username, String password){
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		if(loginpageobject.login_formlayout.isDisplayed()){
			test.log(LogStatus.PASS,"Login Form is displayed");
		}
		loginpageobject.login_username.sendKeys(username);
		test.log(LogStatus.PASS,"Username entered");
		
		loginpageobject.login_password.sendKeys(password);
		test.log(LogStatus.PASS,"password entered");
		
		String driverbrowser= driver.toString();
		if(driverbrowser.contains("EdgeDriver")){
			Actions act= new Actions(driver);
			act.moveToElement(loginpageobject.login_button).perform();
			act.moveToElement(loginpageobject.login_button).click().perform();
		}
		else{
			loginpageobject.login_button.click();
			test.log(LogStatus.PASS,"Login button submit");
		}
		boolean errDisplay= loginpageobject.login_Errormsg.isDisplayed();
		if(errDisplay){
			String message=loginpageobject.login_Errormsg.getText();
			Assert.assertEquals("Incorrect username or password", message);
			test.log(LogStatus.PASS,"UnAuthorised login");	
		}
	}
	
	public void closebrowser(){
		test.log(LogStatus.INFO, "Close browser");
		driver.quit();
		extent.endTest(test);
		extent.flush();
		
	}
	

	
	
}
