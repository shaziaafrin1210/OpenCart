package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath="//input[@name='email']")
	WebElement username;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	
	public void setEmail(String email) {
		username.sendKeys(email);
	}
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void clickLogin() {
		login.click();
	}
}
