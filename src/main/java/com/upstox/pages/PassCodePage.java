package com.upstox.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.upstox.base.UpstoxBase;

public class PassCodePage extends UpstoxBase {

	@FindBy(xpath = "//h1[@data-qa='login-title']")
	private WebElement passCodeTxt;

	public WebElement getPassCodeTxt() {
		return passCodeTxt;
	}

	public WebElement getPascodeInput() {
		return pascodeInput;
	}

	@FindBy(xpath = "//input[@name='yob']")
	private WebElement pascodeInput;

	public PassCodePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyOnPasscodePage() {
		return getPassCodeTxt().isDisplayed() && getPascodeInput().isDisplayed();
	}
	
	public HomePage enterPassCodeAndGo(String code) {
		getPascodeInput().sendKeys(code);
		return new HomePage();
	}

}
