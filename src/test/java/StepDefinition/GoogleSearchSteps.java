package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;


public class GoogleSearchSteps {
	
	WebDriver driver = null;
	@Given("Browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");
		System.out.println("inside google");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		
		
		
		
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		driver.navigate().to("https://www.google.com/");
		
		
	}

	@When("User enters a text in the test box")
	public void user_enters_a_text_in_the_test_box() {
		driver.findElement(By.name("q")).sendKeys("Apovlabel.com");
		
	}

	@And("hits enter")
	public void hits_enter() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("User is navigated to search results")
	public void user_is_navigated_to_search_results() {
		driver.getPageSource().contains("Sunkissed breez");
		driver.close();
		driver.quit();
	}


}
