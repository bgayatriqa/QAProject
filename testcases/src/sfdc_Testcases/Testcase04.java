package sfdc_Testcases;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase04 {
	 WebDriver driver;
	 @Test
	/*
	 * public void Forgot_Password_4_A() throws InterruptedException { //WebDriver
	 * driver;
	 * 
	 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
	 * driver.get("https://login.salesforce.com/"); //Thread.sleep(5000);
	 * 
	 * WebElement forgotPassword =
	 * driver.findElement(By.id("forgot_password_link")); forgotPassword.click();
	 * String nextpageUrl= driver.getCurrentUrl(); System.out.println(nextpageUrl);
	 * String expectedUrl
	 * ="https://login.salesforce.com/secur/forgotpassword.jsp?locale=us";
	 * if(nextpageUrl.equalsIgnoreCase(expectedUrl)) {
	 * System.out.println("page valid"); } else {
	 * System.out.println("invalid Page"); } WebElement userName =
	 * driver.findElement(By.id("un")); userName.sendKeys("gayatri@xo.com");
	 * WebElement continueButton = driver.findElement(By.id("continue"));
	 * continueButton.click(); String displayMessage
	 * =driver.findElement(By.className("message")).getText();
	 * System.out.println(displayMessage); String expectedMessage =
	 * "We’ve sent you an email with a link to finish resetting your password.";
	 * Assert.assertTrue(displayMessage.contains(expectedMessage)); driver.quit(); }
	 */	 public void Forgot_Password_4B() throws InterruptedException
		{
		 //WebDriver driver;

			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			 driver.get("https://login.salesforce.com/");
			//Thread.sleep(5000);
			WebElement userName = driver.findElement(By.id("username"));
			userName.sendKeys("123");
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys("22131");
			WebElement logIn = driver.findElement(By.id("Login"));
			logIn.click();
			String actualError ="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
			String expectedError ="Error message should be displayed\r\n" + 
					"'Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. Please contact the administrator at your company for help'"; 
			if(actualError.equalsIgnoreCase(expectedError))
			{
				System.out.println("Message is verified");
				
			}
			else{
				System.out.println("Message is not verified");
				
			}
			driver.close();
				
			
			
}
}
