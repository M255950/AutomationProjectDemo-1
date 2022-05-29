package com.upstox.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.upstox.base.UpstoxBase;

public class SignInPage extends UpstoxBase {

	// step 1
	// create web elements
	@FindBy(xpath = "//img[@alt='upstox logo']")
	private WebElement loginPageLogo;

	@FindBy(xpath = "//h1[@data-qa='login-title']")
	private WebElement loginTitle;

	@FindBy(xpath = "//input[@name='userId']")
	private WebElement userID;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@id='submit-btn']")
	private WebElement submitBtn;

	@FindBy(xpath = "//div[@data-qa='login-api-error']")
	private WebElement loginError;

	public WebElement getLoginError() {
		return loginError;
	}

	// step 2
	public WebElement getLoginPageLogo() {
		return loginPageLogo;
	}

	public WebElement getLoginTitle() {
		return loginTitle;
	}

	public WebElement getUserID() {
		return userID;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	// step 3
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	// Business logic

	public boolean verifyOnSignPage() {
		return getLoginPageLogo().isDisplayed() && getLoginTitle().isDisplayed();
	}

	void doLogin(String userID, String pass) {

		getUserID().sendKeys(userID);
		getPassword().sendKeys(pass);
		getSubmitBtn().click();
	}

	public String getErrorMsg() {
		return getLoginError().getText();
	}

	public PassCodePage verifyLoginByCurrectInput(String user, String pass) {
		doLogin(user, pass);
		return new PassCodePage();
	}

	public boolean verifyLoginByWrongInput(String user, String pass) {
		doLogin(user, pass);
		if (getLoginError().isDisplayed()) {
			return false;
		}
		return true;
	}

}
