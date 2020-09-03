


package testbase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pages.AgentPage;
import pages.HomePage;
import pages.ListingsPage;
import pages.PropertyDetailsPage;

public class Tests  {
WebDriver driver;
ExtentReports report;
ExtentTest logger;

public  void CreateReport() {
	String fileName = new SimpleDateFormat("'Zoopla'YYYYMMddHHmm'.html'").format(new Date());
	String path = "C:\\Users\\vamsi\\Desktop\\Git_projects\\QAProject\\Zoopla\\src\\main\\java\\reports\\" + fileName;
	report = new ExtentReports(path);
}


	@BeforeMethod
	@Parameters("browser")
		public  void setup(String browser) {
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
//	@BeforeTest
//	public void setUp() throws InterruptedException
//	{
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		
//	}
	@AfterClass
	public void TearDown()
	{
		driver.close();
		//driver.quit();
	}

@Test
	public  void inputLocationAndClickSubmit() throws InterruptedException, IOException
	{
		
		HomePage homePage = new HomePage(driver);
		ListingsPage listingsPage;
		AgentPage agentPage;
		PropertyDetailsPage propertydetailsPage;
		//opening the page
		driver.get("https://www.zoopla.co.uk/");
		Thread.sleep(2000);
		//clicking on the popup
		homePage.preferedButtonClick();
		
		//Asserting the Title
		String expectedTitle ="Search Property to Buy, Rent, House Prices, Estate Agents";
		String actualTitle= driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle));
		
		//Input location London and click submit
		homePage.enterCityName("london");
		listingsPage=homePage.clickOnSearch();
		
		//clicked on low to highprice
		listingsPage.mostRecentArrow();
		
		//You will get a list of properties on that page.
		listingsPage.getAllTheListings();
		
		//Selecting the fifth property
		 propertydetailsPage =listingsPage.pickingFifthListing();
		 
		 //getting Agent details on next page
		 String agentfromPropertyPage =propertydetailsPage.getAgentName();
		 
		 //click on the name link to get into the agent’s page.
		 agentPage=propertydetailsPage.clickOnAgentName();
		 Thread.sleep(2000);
		 
		 //check that the the properties listed there belong to the same agent selected
		 String agentFromAgentPage=agentPage.getDetailsfromAgentPage();
		 Assert.assertTrue(agentfromPropertyPage.contains(agentFromAgentPage));
		 
	}
	
	

}
