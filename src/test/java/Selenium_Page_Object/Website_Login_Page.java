package Selenium_Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Website_Login_Page {
	WebDriver driver;

	public Website_Login_Page(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUserName;
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;

	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String upassword) {
		txtPassword.sendKeys(upassword);
	}

	public void Clicksubmit() {
		btnLogin.click();
	}

}
