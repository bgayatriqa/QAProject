package pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import testbase.TestBase;

public class HomePage  {
	private WebDriver driver;
	public HomePage(WebDriver driver) throws IOException 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Preference button
	@FindBy(xpath="//button[@class='ui-button-secondary']")
	WebElement preferenceButton;
	//Enter CityNAme
	@FindBy(xpath ="//input[@id='search-input-location']")
	WebElement cityName;
	
	//Click on search
	@FindBy(xpath="//button[@id='search-submit']")
	WebElement searchButton;
	
	public void preferedButtonClick()
	{
		preferenceButton.click();
	}
	public void enterCityName(String city)
	{
		cityName.sendKeys(city);
		
	}
	public ListingsPage clickOnSearch()
	{
		searchButton.click();
		return new ListingsPage(driver);
	}

}
