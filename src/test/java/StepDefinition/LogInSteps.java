package StepDefinition;

import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import PageMethods.LoginPageMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInSteps {
	
	public static String Browser= "chrome";
	WebDriver driver = null;
	LoginPageMethods loginMethod;
	public DesiredCapabilities cap = new DesiredCapabilities();
	//@Parameters({"Browser"})
	@Before
	public void BrowserSetup() throws MalformedURLException {
		//System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");
		//driver = new ChromeDriver();
		//driver.manage().window().maximize();
		if(Browser.equals("chrome")) {
			cap.setPlatform(Platform.ANY); 
			cap.setBrowserName("chrome");
			
			ChromeOptions options = new ChromeOptions();
			options.merge(cap);
		}
		else if(Browser.equals("firefox")) {
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("firefox");
			
			FirefoxOptions options = new FirefoxOptions();
			options.merge(cap);
		}
		else if(Browser.equals("MicrosoftEdge")) {
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("MicrosoftEdge");
			
			EdgeOptions options = new EdgeOptions();
			options.merge(cap);
		}
		
		
		
		driver = new RemoteWebDriver(new URL(" http://192.168.29.8:4444"),cap);
		}
	@After
	public void CloseBrowser() {
		 driver.quit();
	}
	@Given("user is on log in page")
	public void user_is_on_log_in_page() {
		
		System.out.println("inside first step");
		
		
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
	}

	@When("^User enters (.*) and (.*)$")
	public void user_enters_user1_and_password(String Username,String Password) {
		loginMethod = new LoginPageMethods(driver);
		System.out.println("inside 2nd step");
		loginMethod.enterUsername(Username);
		//driver.findElement(By.id("username")).sendKeys(Username);
		loginMethod.enterPassword(Password);
		//driver.findElement(By.id("password")).sendKeys(Password);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
	    
		System.out.println("inside 3rd step");
		loginMethod.ClickLogin();
	    //driver.findElement(By.xpath("//button[text()=\"Submit\"]")).click();
	    
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("inside 4th step");
		try {
			loginMethod.ValidateLogout();
		//driver.findElement(By.xpath("//a[text()=\"Log out\"]")).isDisplayed();
		}
		catch (Exception e){
			
			fail();
			 
		}
	    
	   
	}

}
