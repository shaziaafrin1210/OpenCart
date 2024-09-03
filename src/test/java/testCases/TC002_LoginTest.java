package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups= {"Sanity","Master"})
	public void verify_LoginTest() {
      try {
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		LoginPage login= new LoginPage(driver);
		login.setEmail(p.getProperty("email"));
		login.setPassword(p.getProperty("password"));
		login.clickLogin();
		
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountIsExist();
		
		 Assert.assertEquals(targetpage,true);
      }catch(Exception e) {
    	  Assert.fail();
      }
	}

}
