package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver){
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_Firstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_Lastname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_telephone;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_cnfrmPassword;
	@FindBy(xpath="//label[normalize-space()='No']")
	WebElement chkbox;
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkbox_Privacypolicy;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_submit;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement txt_cnfirmationMsg;


	public void setFirstName(String fname) {
		txt_Firstname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txt_Lastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}

	public void setPhoneNum(String num) {
		txt_telephone.sendKeys(num);
	}
	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void setCnfrmPassword(String confirmPwd) {
		txt_cnfrmPassword.sendKeys(confirmPwd);
	}

	public void clickCheckBox() {
		chkbox.click();

	}
	public void clickAgree() {
		chkbox_Privacypolicy.click();		
	}


	public void clickContinue() {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",btn_submit );
	}
	public String getConfirmationMessage() {

		try {
			return (txt_cnfirmationMsg.getText());
		}catch(Exception e) {
			return e.getMessage();
		}
	}
}
