package Hooks;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilis.ConfigReader;
import utilis.Constants;

public class Hooks extends DriverFactory {

	Logger logs;

	@Before
	public void setup(Scenario scenario) {

		logs = LogManager.getLogger(Hooks.class.getName());

		Properties value = ConfigReader.intializeProperties();

		String browserName = value.getProperty("browserName");

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();			
		}else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();			
		}else {
			logs.error("Browser is not defined, as the provided browser value: "+browserName+"is incorrect.");
		}

		driver.manage().window().maximize();
		logs.debug("Browser got maximized");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		driver.get(value.getProperty("url"));
		logs.debug("Application is opened");

	}

	@After
	public void closure(Scenario scenario) {

		boolean failed = scenario.isFailed();
		if (failed) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());

		}

		driver.quit();
		logs.debug("Browser  got closed");
	}

}
