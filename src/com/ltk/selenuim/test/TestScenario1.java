package com.ltk.selenuim.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ltk.selenuim.config.SeleniumConfig;

public class TestScenario1 {
	WebDriver driver;
	SeleniumConfig seleniumConfig;
	
	/**
	 * Hàm khởi tạo
	 */
	public TestScenario1() {
		seleniumConfig = new SeleniumConfig();
	}	
	
	@BeforeMethod
	public void initDriver() {
		driver = seleniumConfig.invokeFirefoxBrowser("http://localhost:8080/Forum/trang-chu");
		//driver = seleniumConfig.invokeChromeBrowser("http://localhost:8080/Forum/trang-chu");
		System.out.println("-- Running Browser --");
	}
	 
	/**
	 * Kiểm tra hiển thị trang đăng ký 1
	 * Kết quả mong đợi: hiển thị trang đăng ký
	 */
	@Test
	public void testCase01() {
		String ExpectedResult = new String("http://localhost:8080/Forum/dang-ky");
		String ActualResult = "";
		System.out.println("-- Start testcase 1 --");
		try {
			driver.findElement(By.xpath("/html/body/header/div/nav/div/div/a[2]")).click();
			Thread.sleep(2000);
			ActualResult = driver.getCurrentUrl();
			Assert.assertEquals(ActualResult,ExpectedResult,"TestCase1: Failed");
			System.out.println("TestCase1: Passed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-- Stop testcase 1 --");
	}
	
	/**
	 * Kiểm tra hiển thị trang đăng ký 2
	 * Kết quả mong đợi: hiển thị trang đăng ký
	 */
	@Test
	public void testCase02() {
		String ExpectedResult = new String("http://localhost:8080/Forum/dang-ky");
		String ActualResult = "";
		System.out.println("-- Start testcase 2 --");
		try {
			driver.findElement(By.xpath("/html/body/header/div/nav/div/div/a[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/section/div/div/div[1]/a")).click();
			Thread.sleep(2000);
			ActualResult = driver.getCurrentUrl();
			Assert.assertEquals(ActualResult,ExpectedResult,"TestCase2: Failed");
			System.out.println("TestCase2: Passed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-- Stop testcase 2 --");
	}
	
	/**
	 * Kiểm tra chuyển sang trang đăng nhập
	 * Kết quả mong đợi: hiển thị trang đăng nhập
	 */
	@Test
	public void testCase03() {
		String ExpectedResult = new String("http://localhost:8080/Forum/dang-nhap");
		String ActualResult = "";
		System.out.println("-- Start testcase 3 --");
		try {
			driver.findElement(By.xpath("/html/body/header/div/nav/div/div/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/section/div/div/div[2]/a")).click();
			Thread.sleep(2000);
			ActualResult = driver.getCurrentUrl();
			Assert.assertEquals(ActualResult,ExpectedResult,"TestCase3: Failed");
			System.out.println("TestCase3: Passed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-- Stop testcase 3 --");
	}
	
	/**
	 * Kiểm tra đăng ký với thông tin đúng và hợp lệ
	 * Kết quả mong đợi: hiển thị trang đăng nhập
	 */
	@Test
	public void testCase04() {
		String ExpectedResult = new String("http://localhost:8080/Forum/dang-nhap");
		String ActualResult = "";
		System.out.println("-- Start testcase 4 --");
		try {
			driver.findElement(By.xpath("/html/body/header/div/nav/div/div/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("username");
			driver.findElement(By.id("email")).sendKeys("email@gmail.com");
			driver.findElement(By.id("fullName")).sendKeys("name");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.id("re_pass")).sendKeys("password");
			Thread.sleep(2000);
			driver.findElement(By.id("signup")).click();
			Thread.sleep(2000);
			ActualResult = driver.getCurrentUrl();
			Assert.assertEquals(ActualResult,ExpectedResult,"TestCase4: Falied");
			System.out.println("TestCase4: Passed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-- Stop testcase 4 --");
	}
	
	/**
	 * Kiểm tra đăng ký không nhập tên tài khoản và các thông tin còn lại đúng
	 * Kết quả mong đợi: Báo lỗi "Tài khoản không được để trống" ở dưới textbox tên tài khoản
	 */
	@Test
	public void testCase05() {
		String ExpectedResult = new String("Tài khoản không được để trống");
		String ActualResult = "";
		System.out.println("-- Start testcase 5 --");
		try {
			driver.findElement(By.xpath("/html/body/header/div/nav/div/div/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("");
			driver.findElement(By.id("email")).sendKeys("email@gmail.com");
			driver.findElement(By.id("fullName")).sendKeys("name");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.id("re_pass")).sendKeys("password");
			Thread.sleep(2000);
			driver.findElement(By.id("signup")).click();
			Thread.sleep(2000);
			ActualResult = driver.findElement(By.id("error_username")).getText();
			Assert.assertEquals(ActualResult,ExpectedResult,"TestCase5: Falied");
			System.out.println("TestCase5: Passed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-- Stop testcase 5 --");
	}
	
	/**
	 * Kiểm tra đăng ký không nhập email và các thông tin còn lại đúng
	 * Kết quả mong đợi: Báo lỗi "Email không được để trống" ở dưới textbox email
	 */
	@Test
	public void testCase06() {
		String ExpectedResult = new String("Email không được để trống");
		String ActualResult = "";
		System.out.println("-- Start testcase 6 --");
		try {
			driver.findElement(By.xpath("/html/body/header/div/nav/div/div/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("username");
			driver.findElement(By.id("email")).sendKeys("");
			driver.findElement(By.id("fullName")).sendKeys("name");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.id("re_pass")).sendKeys("password");
			Thread.sleep(2000);
			driver.findElement(By.id("signup")).click();
			Thread.sleep(2000);
			ActualResult = driver.findElement(By.id("error_email")).getText();
			Assert.assertEquals(ActualResult,ExpectedResult,"TestCase6: Falied");
			System.out.println("TestCase6: Passed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-- Stop testcase 6 --");
	}
	
	/**
	 * Kiểm tra đăng với email sai và các thông tin còn lại đúng
	 * Kết quả mong đợi: Báo lỗi "Email không hợp lệ (Ex: abc@gmail.com)" ở dưới textbox email
	 */
	@Test
	public void testCase07() {
		String ExpectedResult = new String("Email không hợp lệ (Ex: abc@gmail.com)");
		String ActualResult = "";
		System.out.println("-- Start testcase 7 --");
		try {
			driver.findElement(By.xpath("/html/body/header/div/nav/div/div/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("username");
			driver.findElement(By.id("email")).sendKeys("email");
			driver.findElement(By.id("fullName")).sendKeys("name");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.id("re_pass")).sendKeys("password");
			Thread.sleep(2000);
			driver.findElement(By.id("signup")).click();
			Thread.sleep(2000);
			ActualResult = driver.findElement(By.id("error_email")).getText();
			Assert.assertEquals(ActualResult,ExpectedResult,"TestCase7: Falied");
			System.out.println("TestCase7: Passed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-- Stop testcase 7 --");
	}
	
	/**
	 * Kiểm tra đăng ký không nhập họ tên và các thông tin còn lại đúng
	 * Kết quả mong đợi: Báo lỗi "Họ tên không được để trống" ở dưới textbox họ tên
	 */
	@Test
	public void testCase08() {
		String ExpectedResult = new String("Họ tên không được để trống");
		String ActualResult = "";
		System.out.println("-- Start testcase 8 --");
		try {
			driver.findElement(By.xpath("/html/body/header/div/nav/div/div/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("username");
			driver.findElement(By.id("email")).sendKeys("email@gmail.com");
			driver.findElement(By.id("fullName")).sendKeys("");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.id("re_pass")).sendKeys("password");
			Thread.sleep(2000);
			driver.findElement(By.id("signup")).click();
			Thread.sleep(2000);
			ActualResult = driver.findElement(By.id("error_fullName")).getText();
			Assert.assertEquals(ActualResult,ExpectedResult,"TestCase8: Falied");
			System.out.println("TestCase8: Passed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-- Stop testcase 8 --");
	}
	
	/**
	 * Kiểm tra đăng ký không nhập mật khẩu và các thông tin còn lại đúng
	 * Kết quả mong đợi: Báo lỗi "Mật khẩu không được để trống" ở dưới textbox mật khẩu
	 */
	@Test
	public void testCase09() {
		String ExpectedResult = new String("Mật khẩu không được để trống");
		String ActualResult = "";
		System.out.println("-- Start testcase 9 --");
		try {
			driver.findElement(By.xpath("/html/body/header/div/nav/div/div/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("username");
			driver.findElement(By.id("email")).sendKeys("email@gmail.com");
			driver.findElement(By.id("fullName")).sendKeys("name");
			driver.findElement(By.id("password")).sendKeys("");
			driver.findElement(By.id("re_pass")).sendKeys("");
			Thread.sleep(2000);
			driver.findElement(By.id("signup")).click();
			Thread.sleep(2000);
			ActualResult = driver.findElement(By.id("error_password")).getText();
			Assert.assertEquals(ActualResult,ExpectedResult,"TestCase9: Falied");
			System.out.println("TestCase9: Passed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-- Stop testcase 9 --");
	}
	
	/**
	 * Kiểm tra đăng ký với xác nhận mật khẩu sai và các thông tin còn lại đúng
	 * Kết quả mong đợi: Báo lỗi "Mật khẩu nhập lại không đúng" ở dưới textbox nhập lại mật khẩu
	 */
	@Test
	public void testCase10() {
		String ExpectedResult = new String("Mật khẩu nhập lại không đúng");
		String ActualResult = "";
		System.out.println("-- Start testcase 10 --");
		try {
			driver.findElement(By.xpath("/html/body/header/div/nav/div/div/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("username");
			driver.findElement(By.id("email")).sendKeys("email@gmail.com");
			driver.findElement(By.id("fullName")).sendKeys("name");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.id("re_pass")).sendKeys("failword");
			Thread.sleep(2000);
			driver.findElement(By.id("signup")).click();
			Thread.sleep(2000);
			ActualResult = driver.findElement(By.id("error_re_pass")).getText();
			Assert.assertEquals(ActualResult,ExpectedResult,"TestCase10: Falied");
			System.out.println("TestCase10: Passed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-- Stop testcase 10 --");
	}
	
	
	/**
	 * Đóng driver khi khết thúc mỗi testcase
	 */
	@AfterMethod
    public void test_Cleaning(){
        System.out.println("-- Closing Browser --");
        driver.close();
    }
	
	/**
	 * Thoát driver khi kết thúc testscenario
	 */
	@AfterTest
	public void quitDriver() {
		driver.quit();
	}
	

	
}
