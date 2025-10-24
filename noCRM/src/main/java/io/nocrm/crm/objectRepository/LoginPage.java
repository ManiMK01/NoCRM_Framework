package io.nocrm.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(partialLinkText = "Login")
	private WebElement loginLink;
	
	@FindBy(id = "email")
	private WebElement emailTextField;
	
	@FindBy(id = "password")
	private WebElement passwordTextField;
	
	@FindBy(partialLinkText = "Forgot password?")
	private WebElement forgotPasswordlink;
	
	@FindBy(id = "remember_me")
	private WebElement rememberMeCheckBox;
	
	@FindBy(xpath = "//input[@value='Sign in']")
	private WebElement signinBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getForgotPasswordlink() {
		return forgotPasswordlink;
	}

	public WebElement getRememberMeCheckBox() {
		return rememberMeCheckBox;
	}

	public WebElement getSigninBtn() {
		return signinBtn;
	}
	
public void loginToApp(String url, String username, String password) {
		
		driver.get(url);
		loginLink.click();
		emailTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		signinBtn.click();
	}
}
