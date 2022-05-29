package com.upstox.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.upstox.base.UpstoxBase;
import com.upstox.pages.PassCodePage;
import com.upstox.pages.SignInPage;

public class SignInPageTest extends UpstoxBase{

	SignInPage login=null;
	PassCodePage passCode=null;
	
	@BeforeMethod
	void setup() {
		init();
		login=new SignInPage();
	}
	
	@Test
	void validateSignInPage() {
		Assert.assertTrue(login.verifyOnSignPage());
	}

	@Test(priority = 1)
	void validateSignInFunWithCurroctIdPass() {
		passCode=login.verifyLoginByCurrectInput(props.getProperty("userID"), props.getProperty("password"));
		Assert.assertTrue(passCode.verifyOnPasscodePage());
	}
	
	@Test(priority = 2)
	void validateSignInFunWithIncurroctIdPass() {
		
		boolean result = login.verifyLoginByWrongInput("userId101", "Pass101");
		Assert.assertFalse(result);
		Assert.assertEquals(login.getErrorMsg(), "Incorrect User ID or Password");
	}
	
	@AfterMethod
	void teardown() {
		closeAll();
	}
}
