package com.ltk.selenuim.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumConfig {
	private WebDriver driver;

	public WebDriver invokeFirefoxBrowser(String url) {
		try {			
			System.setProperty("webdriver.gecko.driver",
					"driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(url);
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public WebDriver invokeChromeBrowser(String url) {
		try {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(url);
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
	
}

