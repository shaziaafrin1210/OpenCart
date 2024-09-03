package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass {


	@Test(groups= {"Regression","Master"})
	public void verify_AccountRegistration() {

		logger.info("******** Starting TC001_AccountRegistration******** ");
		try {
			HomePage hp= new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account......");
			hp.clickRegisterLink();
			logger.info("Clicked on RegisterLink......");

			AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
			logger.info("Providing customer details....");

			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString()+"@gmail.com");
			regpage.setPhoneNum(randomNumeric());
			String password=randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setCnfrmPassword(password);
			regpage.clickCheckBox();
			regpage.clickAgree();
			regpage.clickContinue();
			logger.info("Validating Confirmation Message......");
			String cnfrmMsg=regpage.getConfirmationMessage();
			if(cnfrmMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}else {
				logger.error("Test Failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}
			//Assert.assertEquals(cnfrmMsg, "Your Account Has Been Created!");
		}catch(Exception e) {
            e.getMessage();
			Assert.fail();
		}

	}

}
