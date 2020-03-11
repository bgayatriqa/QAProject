package sfdc_Testcases;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase01 {
	
		 WebDriver driver;
		 @Test
		public void loginErrorMessage() throws InterruptedException
		{
		 //WebDriver driver;

			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			 driver.get("https://login.salesforce.com/");
			//Thread.sleep(5000);
			WebElement userName = driver.findElement(By.id("username"));
			userName.sendKeys("gayatri@xo.com");
			WebElement password = driver.findElement(By.id("password"));
			password.clear();

			WebElement logIn = driver.findElement(By.id("Login"));
			logIn.click();
			 String errorMessage = driver.findElement(By.id("error")).getText();
			 System.out.println(errorMessage);
			 String message = "Please enter your password.";
			 if(errorMessage.matches(message))
			 {
				 System.out.println("Error message displayed");
				 			 
			 }
			 else
			 {
				 System.out.println("Error message is not displayed");
			 }
			 Thread.sleep(2000);
			 driver.quit();
			 
		}
	


 
}
