package com.upstox.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.upstox.base.UpstoxBase;
import com.upstox.pages.HomePage;
import com.upstox.pages.PassCodePage;
import com.upstox.pages.SignInPage;

public class HomePageTest extends UpstoxBase {

	SignInPage login = null;
	PassCodePage passCode = null;
	HomePage homePage = null;

	@BeforeMethod
	void setup() {
		init();
		login = new SignInPage();
		passCode = login.verifyLoginByCurrectInput(props.getProperty("userID"), props.getProperty("password"));
		homePage = passCode.enterPassCodeAndGo(props.getProperty("passcode"));
	}

//	@Test
//	void validateHomePageUser() {
//		Assert.assertTrue(homePage.verifyOnHomePage());
//	}
	
	@Test(priority = 1)
	void validateBuyingFun() throws InterruptedException {
		homePage.verifyOnHomePage();
		Assert.assertTrue(homePage.clickOnShareToBuy("RELIANCE"));
		
	}
	
	
	@AfterMethod
	void closeTest() {
		closeAll();
	}
}
