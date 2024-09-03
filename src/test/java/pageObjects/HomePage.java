package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver){
		super(driver);
	}

	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement clickMyAccount;

	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement clickRegister;

	@FindBy(xpath="//a[text()='Login']")
	WebElement loginLink;
	public void clickMyAccount() {
		//clickMyAccount.click();
		//Actions act=new Actions(driver);
		//act.moveToElement(clickMyAccount).click().perform();
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",clickMyAccount );


	}


	public void clickRegisterLink() {
		clickRegister.click();
	}
	public void clickLogin() {
		loginLink.click();
	}
}
