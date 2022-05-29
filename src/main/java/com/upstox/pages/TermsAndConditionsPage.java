package com.upstox.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.upstox.base.UpstoxBase;

public class TermsAndConditionsPage extends UpstoxBase {

	
	@FindBy(xpath = "//h1[text()='Terms & Conditions']")
	private WebElement termsAndConHeding;
	
	public TermsAndConditionsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean onTermsPage() {
		return termsAndConHeding.isDisplayed();
	}
}
