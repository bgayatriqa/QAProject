package zeroproject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableCode {
	static ExtentTest logger;
	static ExtentReports report;
	static WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public static void initializeDriver(String browser) {
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		else
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		}

	public static void openUrl(String url) {
		driver.get(url);
		 driver.manage().window().maximize();
	}
@AfterMethod
	public static void closeBrowser() {
	//report.flush();
		driver.quit();
		
	}

public static void close()
{
	driver.close();
}
@AfterTest
	public static void closeReport() {
	
		report.flush();
		//driver.close();
	}
@BeforeTest
	public static void createReport() {
		String fileName = new SimpleDateFormat("'XEROReport_'YYYYMMddHHmm'.html'").format(new Date());
		String path = "C:\\Users\\vamsi\\Desktop\\Git_projects\\QAProject\\zeroproject\\xeroReports\\" + fileName;
		report = new ExtentReports(path);
	}

public static void enterText(WebElement element, String text, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Textbox is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Textbox is found");
			element.sendKeys(text);
		}
	}

	public static void click(WebElement element, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Element is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Element is found");
			element.click();
		}
	}
}


