package loginPage_objectresource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage_Object {
	
		public static WebDriver driver;
		
		public Loginpage_Object(WebDriver tdriver){
			driver=tdriver;
		}
		
		@FindBy(xpath="//*[@class='main-form ng-scope']")
		public WebElement login_formlayout;
		
		@FindBy(xpath="//*[@id='input_0']")
		public WebElement login_username;
		
		@FindBy(xpath="//*[@name='userPassword']")
		public WebElement login_password;
		
		@FindBy(xpath="//*[@class='md-raised md-primary md-login m-0 md-button md-ink-ripple']")
		public WebElement login_button;
		
		@FindBy(xpath="//*[text()='Incorrect username or password']")
		public WebElement login_Errormsg;

	}

