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
}

