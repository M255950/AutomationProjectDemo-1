package com.upstox.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UpstoxBase {
	
	public static WebDriver driver=null;
	public static Properties props=null;
	
	public static void init() {
		
		props=new Properties();
		try {
			FileInputStream file=new FileInputStream("C:\\Users\\Santosh\\Desktop\\My Git Work\\AutomationProjectDemo\\src\\main\\java\\com\\upstox\\resources\\config.properties");
			props.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(props.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Santosh\\Desktop\\My Git Work\\AutomationProjectDemo\\src\\main\\java\\com\\upstox\\resources\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(props.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Software Testing\\UpstoxPracticeProject\\src\\main\\java\\com\\upstox\\resources\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty("timeout")), TimeUnit.SECONDS);
		driver.get(props.getProperty("baseURL"));
	}
	
	public static void closeAll() {
		driver.quit();
	}
}
