package com.ltk.selenuim.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumConfig {
	private WebDriver driver;

	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.gecko.driver",
					"E:\\JavaWeb\\workspaceTest\\Test_Selenium\\SeleniumDriver\\geckodriver-v0.28.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://localhost:8080/Forum/trang-chu");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
