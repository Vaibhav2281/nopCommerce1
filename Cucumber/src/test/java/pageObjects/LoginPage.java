package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver lDriver;
	
	public LoginPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id = "Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath= "//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUsername(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}

}
