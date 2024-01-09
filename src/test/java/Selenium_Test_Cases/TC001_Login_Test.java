package Selenium_Test_Cases;

import org.testng.Assert;
import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.Test;
import Selenium_Page_Object.Website_Login_Page;

public class TC001_Login_Test extends Selenium_Base_Class {
	@Test(priority = 1)
	public void logintest() {

		logger.info("URL Is Opened");

		Website_Login_Page lp = new Website_Login_Page(driver);

		lp.setUserName(Username);
		logger.info("Username Entered");

		lp.setPassword(Password);
		logger.info("Password Entered");

		lp.Clicksubmit();
		BasicConfigurator.configure();
		logger.info("Loging into page");

		if (driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Login Test Fail");
		}

	}

}
