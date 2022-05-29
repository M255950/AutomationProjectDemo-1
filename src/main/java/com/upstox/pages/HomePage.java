package com.upstox.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.upstox.base.UpstoxBase;

public class HomePage extends UpstoxBase {

	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	
	@FindBy(xpath = "//span[text()='santosh m.']")
	private WebElement userNameTxt;


	@FindBy(xpath = "//div[text()=\"No, I’m good\"]")
	private WebElement cancleTure;
	
	@FindBy(xpath = "//div[text()='RELIANCE']")
	private WebElement relStock;

	
//	@FindBy(xpath = "//div[contains(@data-id,'scripBuy')]//ancestor::div[@id='NSE_EQ|2885']")
//	private WebElement buyBtn;
	
	@FindBy(xpath = "//div[contains(@data-id,'scripSell')]//ancestor::div[@id='NSE_EQ|2885']")
	private WebElement buyBtn;
	
	
	@FindBy(xpath = "//div[text()='RELIANCE INDUSTRIES LTD']")
	private WebElement nameOfStockTobuy;
	
	public WebElement getUserNameTxt() {
		return userNameTxt;
	}
	
	public WebElement getCancleTure() {
		return cancleTure;
	}

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyOnHomePage() {
		getCancleTure().click();
		return getUserNameTxt().isDisplayed();
	}
	
	

	public boolean clickOnShareToBuy(String stockName) throws InterruptedException {
		
		Actions act=new Actions(driver);
		act.moveToElement(relStock).build().perform();
		//buyBtn.click();
		Thread.sleep(3000);
		
		
		
		js.executeScript("arguments[0].click();", buyBtn);
		
		Thread.sleep(3000);
		return nameOfStockTobuy.isDisplayed();
	}

}
