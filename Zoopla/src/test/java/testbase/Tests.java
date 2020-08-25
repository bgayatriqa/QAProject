package testbase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pages.AgentPage;
import pages.HomePage;
import pages.ListingsPage;
import pages.PropertyDetailsPage;

public class Tests  {
	WebDriver driver;
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void TearDown()
	{
		driver.close();
		driver.quit();
	}
//	public void openUrl() throws InterruptedException
//	{
//		driver.get("https://www.zoopla.co.uk/");
//		Thread.sleep(8000);
//		
//		String expectedTitle ="Search Property to Buy, Rent, House Prices, Estate Agents";
//		String actualTitle= driver.getTitle();
//		System.out.println(actualTitle);
//		Assert.assertTrue(actualTitle.contains(expectedTitle));
//	}
@Test
	public void inputLocationAndClickSubmit() throws InterruptedException, IOException
	{
		//setUp();
		HomePage homePage = new HomePage(driver);
		ListingsPage listingsPage;
		AgentPage agentPage;
		PropertyDetailsPage propertydetailsPage;
		driver.get("https://www.zoopla.co.uk/");
		Thread.sleep(3000);
		homePage.preferedButtonClick();
		String expectedTitle ="Search Property to Buy, Rent, House Prices, Estate Agents";
		String actualTitle= driver.getTitle();
		System.out.println(actualTitle);
	Assert.assertTrue(actualTitle.contains(expectedTitle));
		
		homePage.enterCityName("london");
		listingsPage=homePage.clickOnSearch();
		listingsPage.mostRecentArrow();
		listingsPage.getAllTheListings();
		 propertydetailsPage =listingsPage.pickingFifthListing();
		 String agentfromPropertyPage =propertydetailsPage.getAgentName();
		 agentPage=propertydetailsPage.clickOnAgentName();
		 Thread.sleep(2000);
		 String agentFromAgentPage=agentPage.getDetailsfromAgentPage();
		 Assert.assertTrue(agentfromPropertyPage.contains(agentFromAgentPage));
		 
	}
	
	

}
