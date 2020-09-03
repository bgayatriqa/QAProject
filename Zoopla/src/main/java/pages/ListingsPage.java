package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ListingsPage {
		WebDriver driver;
		public ListingsPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
		//click on mostRecent
		@FindBy(xpath="//select[@name='results_sort']")
		WebElement mostRecent;
		
		//selecting the listings
		@FindBy(xpath="//ul[@class='listing-results clearfix js-gtm-list']/li[@class='srp clearfix   ']//a[@class='listing-results-price text-price']")
		List<WebElement> listings;//a[@class='listing-results-price text-price']
		public void mostRecentArrow() throws InterruptedException
		{
			Select sort= new Select(mostRecent);
			//mostRecent.findElement(By.xpath("//option[contains(text(),'Highest price')]")).click();
			sort.selectByVisibleText("Highest price");
			Thread.sleep(2000);
			
		}
		public void getAllTheListings()
		{
			System.out.println("All the listings in the page are: "+listings.size());
			
			for(int i=0;i<listings.size();i++) {
			System.out.println("The propery : "+listings.get(i).getText());
				//System.out.println("The propery : "+listings.get(i).findElement(By.xpath("//a[@class='listing-results-price text-price']")).getText());
			}
		}
		public PropertyDetailsPage pickingFifthListing() throws InterruptedException
		{
			Thread.sleep(2000);
			WebElement fifthListing=listings.get(4).findElement(By.xpath("./..//h2[@class='listing-results-attr']//a"));
			System.out.println("The fifth listing is : "+fifthListing.getText());
			fifthListing.click();
			System.out.println("The fifth listing is clicked: ");
					
			//listings.get(4).findElement(By.xpath("./..//h2[@class='listing-results-attr']//a")).click();
			System.out.println("");
			return new PropertyDetailsPage(driver);
		}
		
	}
//a[@class='listing-results-price text-price']

