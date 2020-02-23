package sfdc_Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowhandle {

		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
	 driver.get("https://qa-tekarch.firebaseapp.com/");
	}

}
