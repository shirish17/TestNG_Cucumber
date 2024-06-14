package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilis.Constants;
import utilis.ElementUtilis;

public class LandingPage {
	
	
		
		//Implementing Page Factory
		
		WebDriver driver;
		Actions action;
		private ElementUtilis elementutilis;
		
		public LandingPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
			elementutilis = new ElementUtilis(driver);
			}
		
		@FindBy(xpath="//span[text()='My Account']")
		private WebElement MyAccount;
		
		@FindBy(linkText="Register")
		private WebElement Register;
		
		@FindBy(linkText="Login")
		private WebElement Login;
		
		@FindBy(xpath="//input[@name='search']")
		private WebElement searchfieldtext;
		
		@FindBy(xpath="//button[@class='btn btn-light btn-lg']")
		private WebElement searchiconoption;
		
		@FindBy(linkText="Shopping Cart")
		private WebElement Shoppingcart;
		
		
		
		
		public void openApplication(String URL) {
			driver.get(URL);
		}
		
		
		
		
		
		

	}


