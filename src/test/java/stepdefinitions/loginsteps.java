package stepdefinitions;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.LandingPage;
import pages.LoginPage;
import utilis.ConfigReader;

public class loginsteps extends DriverFactory{
	public LandingPage LanPage;
	public LoginPage LogPage;
	public AccountPage APage;
	Logger logs;
	
	@When("User navigates to application Landing page")
	public void open_Application_Home_Page() {
		Properties value = ConfigReader.intializeProperties();
		
		String url = value.getProperty("url");
		LanPage = new LandingPage(driver);
		LanPage.openApplication(url);
		logs.debug("Open application");
		
		
	}
	@And("User enters valid password {string}")
	public void User_enters_valid_password(String password) {
		LogPage.password(password);
		logs.debug("entered password");
		
	}
	
	@And("User clicks on Login button")
	public void User_clicks_on_Login_button() {
		APage = LogPage.loginbutton();
		logs.debug("clicked on loginbutton");
		
	}
	
	@When("^User enters email address (.+)$")
	public void User_enters_email_address(String email) {
		//LogPage = new LoginPage(driver);
		LogPage.emailAddress(email);
		logs.debug("entered emailaddress");
	}
	
	@And("^User enters password (.+)$")
	public void User_enters_password(String password) {
		LogPage.password(password);
		logs.debug("entered password");
	}

	@Then("User should not login successfully")
	public void User_should_not_login_successfully() {
		
		
		Assert.assertTrue(LogPage.errormessage());
		logs.info("login unsuccessfull");
		 
		
	}
	
}

