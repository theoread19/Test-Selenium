package test_BTPM_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_7 {
	WebDriver driver;
	JavascriptExecutor jse;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "E:\\Chrome driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("http://localhost:8080/Forum/trang-chu");
			search();
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void search() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("username");
			driver.findElement(By.id("email")).sendKeys("email@gmail.com");
			driver.findElement(By.id("fullName")).sendKeys("");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.id("re_pass")).sendKeys("password");
			Thread.sleep(5000);
			driver.findElement(By.id("signup")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		//B1704833
		test_7 myObj = new test_7();
		myObj.invokeBrowser();

	}

}
