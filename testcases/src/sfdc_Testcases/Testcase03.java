package sfdc_Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.junit.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase03 {
	 WebDriver driver;
	 @Test
	public void CheckRemeberMe_3() throws InterruptedException
	{
	 //WebDriver driver;
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
		 //driver = new FirefoxDriver();
		 driver.get("https://login.salesforce.com/");
		//Thread.sleep(5000);
		 String name = "gayatri@xo.com";
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(name);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("MyTestTool123");
		WebElement rememberMe =driver.findElement(By.id("rememberUn"));
		rememberMe.click();
		WebElement logIn = driver.findElement(By.id("Login"));
		logIn.click();
		WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		userMenu.click();
		WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logOut.click();
		//
		System.out.println("before");
		Thread.sleep(5000);
		  WebElement userNameVerify = driver.findElement(By.id("idcard-identity"));
		 // System.out.println("after");
		 String usernameExpected = userNameVerify.getText();
		
		  if(usernameExpected.contentEquals(name))
		  { System.out.println("Remember me works"); }
		  else { System.out.println("fails"); }
		 
		 		driver.quit();
		}
}
