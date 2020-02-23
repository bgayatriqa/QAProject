package sfdc_Testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

//import org.testng.Assert;
//import org.testng.annotations.Test;
import org.junit.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase02 {
	
	// WebDriver driver;
	 @Test
	public void LogintoSFDC() throws InterruptedException
	{
	 WebDriver driver;

		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		 driver.get("https://login.salesforce.com/");
		//Thread.sleep(5000);
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("gayatri@xo.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("MyTestTool123");
		WebElement logIn = driver.findElement(By.id("Login"));
		logIn.click();
		Thread.sleep(3000);
		String actualPage= driver.getCurrentUrl();
        System.out.println(actualPage);
		//String home = driver.findElement(By.className("title slds-truncate")).getTagName();
	String expectedPage = "https://na174.salesforce.com/setup/forcecomHomepage.apexp?setupid=ForceCom";
	//Assert.assertEquals(expectedPage, actualPage);
		
	 if(actualPage.contentEquals(expectedPage)) {
		  System.out.println("page loaded successfully"); } else {
		  System.out.println("page not loaded"); }
		 
// Thread.sleep(2000);
		driver.close(); 
		 
	}
}
