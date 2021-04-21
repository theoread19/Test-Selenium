package com.ltk.selenuim.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ltk.selenuim.config.SeleniumConfig;

public class TestScenario1 {
	WebDriver driver;
	
	/**
	 * Hàm khởi tạo
	 */
	public TestScenario1() {
		SeleniumConfig seleniumConfig = new SeleniumConfig();
		driver = seleniumConfig.invokeFirefoxBrowser("http://localhost:8080/Forum/trang-chu");
		//driver = seleniumConfig.invokeChromeBrowser("http://localhost:8080/Forum/trang-chu");
	}

	/**
	 * Kiểm tra hiển thị trang đăng ký 1
	 */
	@Test()
	public void testCase01() {
		String ExpectedResult = new String("http://localhost:8080/Forum/dang-ky");
		String ActualResult = "";
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/a[2]")).click();
			Thread.sleep(2000);
			ActualResult = driver.getCurrentUrl();
			Assert.assertEquals(ActualResult,ExpectedResult,"TestCase1: Không đạt");
			System.out.println("TestCase1 : Đạt");
			Thread.sleep(8000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	/**
	 * Kiểm tra hiển thị trang đăng ký 2
	 */
	public void testCase02() {
		String ExpectedResult = new String("http://localhost:8080/Forum/dang-ky");
		String ActualResult = driver.getCurrentUrl();
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/a[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/section/div/div/div[1]/a")).click();
			Thread.sleep(2000);
			Assert.assertEquals(ActualResult,ExpectedResult,"Không đạt");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	/**
	 * Kiểm tra chuyển sang trang đăng nhập
	 */
	public void testCase03() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/section/div/div/div[2]/a")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	/**
	 * Kiểm tra đăng ký với thông tin đúng và hợp lệ
	 */
	public void testCase04() {		
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("username");
			driver.findElement(By.id("email")).sendKeys("email@gmail.com");
			driver.findElement(By.id("fullName")).sendKeys("name");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.id("re_pass")).sendKeys("password");
			Thread.sleep(5000);
			driver.findElement(By.id("signup")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	/**
	 * Kiểm tra đăng ký không nhập tên tài khoản và các thông tin còn lại đúng
	 */
	public void testCase05() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("");
			driver.findElement(By.id("email")).sendKeys("email@gmail.com");
			driver.findElement(By.id("fullName")).sendKeys("name");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.id("re_pass")).sendKeys("password");
			Thread.sleep(5000);
			driver.findElement(By.id("signup")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	/**
	 * Kiểm tra đăng ký không nhập email và các thông tin còn lại đúng
	 */
	public void testCase06() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("username");
			driver.findElement(By.id("email")).sendKeys("");
			driver.findElement(By.id("fullName")).sendKeys("name");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.id("re_pass")).sendKeys("password");
			Thread.sleep(5000);
			driver.findElement(By.id("signup")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	/**
	 * Kiểm tra đăng với email sai và các thông tin còn lại đúng
	 */
	public void testCase07() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("username");
			driver.findElement(By.id("email")).sendKeys("email");
			driver.findElement(By.id("fullName")).sendKeys("name");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.id("re_pass")).sendKeys("password");
			Thread.sleep(5000);
			driver.findElement(By.id("signup")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	/**
	 * Kiểm tra đăng ký không nhập họ tên và các thông tin còn lại đúng
	 */
	public void testCase08() {
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
		driver.close();
	}
	
	/**
	 * Kiểm tra đăng ký không nhập mật khẩu và các thông tin còn lại đúng
	 */
	public void testCase09() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("username");
			driver.findElement(By.id("email")).sendKeys("email@gmail.com");
			driver.findElement(By.id("fullName")).sendKeys("name");
			driver.findElement(By.id("password")).sendKeys("");
			driver.findElement(By.id("re_pass")).sendKeys("");
			Thread.sleep(5000);
			driver.findElement(By.id("signup")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	/**
	 * Kiểm tra đăng ký với xác nhận mật khẩu sai và các thông tin còn lại đúng
	 */
	public void testCase10() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("username");
			driver.findElement(By.id("email")).sendKeys("email@gmail.com");
			driver.findElement(By.id("fullName")).sendKeys("name");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.id("re_pass")).sendKeys("failword");
			Thread.sleep(5000);
			driver.findElement(By.id("signup")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	public void quitDriver() {
		driver.quit();
	}
	
	public void testAll() {
		System.out.println("-- Start testcase 1 --");
		testCase01();
		System.out.println("-- Stop testcase 1 --");
		
		System.out.println("-- Start testcase 2 --");
		testCase02();
		System.out.println("-- Stop testcase 2 --");
		
		System.out.println("-- Start testcase 3 --");
		testCase03();
		System.out.println("-- Stop testcase 3 --");
		
		System.out.println("-- Start testcase 4 --");
		testCase04();
		System.out.println("-- Stop testcase 4 --");
		
		System.out.println("-- Start testcase 5 --");
		testCase05();
		System.out.println("-- Stop testcase 5 --");
		
		System.out.println("-- Start testcase 6 --");
		testCase06();
		System.out.println("-- Stop testcase 6 --");
		
		System.out.println("-- Start testcase 7 --");
		testCase07();
		System.out.println("-- Stop testcase 7 --");
		
		System.out.println("-- Start testcase 8 --");
		testCase08();
		System.out.println("-- Stop testcase 8 --");
		
		System.out.println("-- Start testcase 9 --");
		testCase09();
		System.out.println("-- Stop testcase 9 --");
		
		System.out.println("-- Start testcase 10 --");
		testCase10();
		System.out.println("-- Stop testcase 10 --");
	}
}
