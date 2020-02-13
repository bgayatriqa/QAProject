package wednesday;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceLoginPage {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//WebDriverManager.firefoxdriver().setup();
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.iedriver().setup();
		//driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
 driver.get("https://login.salesforce.com/");
// Thread.sleep(5000);
 WebElement userName = driver.findElement(By.id("username"));
 userName.sendKeys("gayatri@xo.com");
 WebElement password = driver.findElement(By.id("password"));
 password.sendKeys("MyTestTool123");
 WebElement logIn = driver.findElement(By.id("Login"));
 logIn.click();
 //Thread.sleep(1000);
 
 //driver.quit();
	}

}
