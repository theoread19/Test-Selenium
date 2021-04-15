package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test {
	WebDriver driver;
	JavascriptExecutor jse;

	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.gecko.driver",
					"E:\\selenium\\geckodriver-v0.28.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://localhost:8080/Forum/trang-chu");
			searchCourse();
		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void searchCourse() {

	}

	public static void main(String[] args) {
		System.out.print("hello");
		test myObj = new test();
		myObj.invokeBrowser();
	}
}
