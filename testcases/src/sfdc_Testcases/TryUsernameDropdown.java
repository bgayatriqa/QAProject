package sfdc_Testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TryUsernameDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		userDropdown();
	}
		public static void userDropdown() throws InterruptedException {
		{
		 WebDriver driver;

			/*
			 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
			 */
		 
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 driver.get("https://login.salesforce.com/");
			//Thread.sleep(5000);
			WebElement userName = driver.findElement(By.id("username"));
			userName.sendKeys("gayatri@xo.com");
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys("MyTestTool123");
			WebElement rememberMe =driver.findElement(By.id("rememberUn"));
			rememberMe.click();
			WebElement logIn = driver.findElement(By.id("Login"));
			logIn.click();
			driver.manage().window().maximize();
			
			WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
			plusIcon.click();
		String accountPageWindow = driver.getWindowHandle();
			WebElement accountLink = driver.findElement(By.className("relatedListIcon"));
			accountLink.click();
			WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
			lexNoThanks.click();
			String value;
			List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
			checkbox.get(0).click();
			
			WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
			lexSubmit.click();
			System.out.println("submit is working");
			
			
			  WebElement newButton = driver.findElement(By.name("new")); newButton.click();
			  System.out.println("button is clicking"); 
			  WebElement accountName =
			  driver.findElement(By.id("acc2"));
			  String name ="gayatri";
			  accountName.sendKeys(name);
			  Select type = new
			  Select(driver.findElement(By.id("acc6")));
			  type.selectByValue("Technology Partner");
			  Select customerProirity= new
			  Select(driver.findElement(By.id("00N6g00000Mu55n")));
			  customerProirity.selectByValue("High"); 
			  WebElement save =
			  driver.findElement(By.name("save")); save.click();
			 	WebElement createNewView = driver.findElement(By.linkText("Create New View"));
				createNewView.click();
			
				WebElement fname = driver.findElement(By.name("fname"));
				fname.sendKeys("MyName");;
				WebElement devname = driver.findElement(By.name("devname"));
				devname.sendKeys("myUniqueName");
			
				WebElement saveBtn = driver.findElement(By.name("save"));
				saveBtn.click();
			



				
				
			//driver.quit();
	}


}
}