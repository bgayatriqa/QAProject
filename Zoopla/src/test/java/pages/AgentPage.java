package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentPage {
	WebDriver driver;
	public AgentPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	//find agent details
	@FindBy(xpath="//h1[@class='bottom-half']//b[1]")
	WebElement agentDetails;
	public String getDetailsfromAgentPage()
	{
		String agentName = agentDetails.getText();
		System.out.println("agentNameDetailsfrom agent page: "+agentName);
			
		return agentName;
	}
}
