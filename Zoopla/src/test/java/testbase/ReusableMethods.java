package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethods {
	 static WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
		public  void setUp(String browser) {
		if(browser.contentEquals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    }
		else if(browser.contentEquals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
	}
	@AfterClass
	public void TearDown()
	{
		driver.close();
		//driver.quit();
	}
}
