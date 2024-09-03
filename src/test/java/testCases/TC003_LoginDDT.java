package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_LoginDDT(String email,String pwd,String exp) {
		logger.info("******Starting TC003_LoginDDT*******" );
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage login= new LoginPage(driver);
			login.setEmail(email);
			login.setPassword(pwd);
			login.clickLogin();

			MyAccountPage macc= new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountIsExist();

			if(exp.equalsIgnoreCase("Valid")) 
			{

				if(targetpage==true) 
				{
					macc.clickLogout();
					Assert.assertTrue(true);
				}else 
				{
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("Invalid")) 
			{
				if(targetpage==true) 
				{
					macc.clickLogout();
					Assert.assertTrue(false);
				}else 
				{

					Assert.assertTrue(true);
				}
			}




		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("******Finished TC003_LoginDDT*******" );
	}
}