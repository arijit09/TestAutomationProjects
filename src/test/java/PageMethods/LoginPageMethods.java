package PageMethods;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageLocators.LoginPage;

public class LoginPageMethods {
	WebDriver driver;
	LoginPage login;
	
	
	public LoginPageMethods(WebDriver driver) {
		this.driver=driver;
		//LoginPage login = new LoginPage();
		PageFactory.initElements(driver,this);
	}
	@FindBy(id = "username")
	public WebElement txt_username; 
	//By txt_username = By.id("username");
	@FindBy(id = "password")
	public WebElement txt_password; 
	//By txt_password = By.id("password");
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement btn_login; 	
	//By btn_login = By.xpath("//button[text()=\"Submit\"]");
	@FindBy(xpath = "//a[text()='Log out']")
	public WebElement btn_logout; 
	//By btn_logout = By.xpath("//a[text()='Log out']");
	
	public void enterUsername(String userneme)
	{
		txt_username.sendKeys(userneme);
	}
	public void enterPassword(String password)
	{
		txt_password.sendKeys(password);
	}
	public void ClickLogin() {
		
		btn_login.click(); 
	}
	public void ValidateLogout() {
		//assert.assertTrue(btn_logout.isDisplayed());
		
		btn_logout.isDisplayed();
		
	}

}
