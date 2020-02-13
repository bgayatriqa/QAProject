package wednesday;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDemo {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
 driver.get("https://qa-tekarch.firebaseapp.com/");
 Thread.sleep(3000);
 WebElement userName = driver.findElement(By.id("email_field"));
 userName.sendKeys("admin123@gmail.com");
 WebElement password = driver.findElement(By.id("password_field"));
 password.sendKeys("admin123");
 WebElement logIn = driver.findElement(By.xpath("/html/body/div[1]/button"));
 logIn.click();
 Thread.sleep(3000);
 WebElement home = driver.findElement(By.xpath("/html/body/div[2]/div[1]/a[1]"));
 home.click();
 WebElement name = driver.findElement(By.id("name"));
 name.sendKeys("Adam");
 WebElement fName = driver.findElement(By.id("lname"));
 fName.sendKeys("David");
  WebElement postalAdd = driver.findElement(By.id("postaladdress"));
 postalAdd.sendKeys("345 lawrence exp way, sunnyvale");
 WebElement personalAdd = driver.findElement(By.id("personaladdress"));
 personalAdd.sendKeys("345 lawrence exp way, sunnyvale");
 List<WebElement> gender = driver.findElements(By.id("radiobut"));
// List GenderList = driver.findElements(By.name("sex"));
 String Value;
 for(int i=0;i<gender.size();i++){
   Value = gender.get(i).getAttribute("value");
   if(Value.equals("male"))
     gender.get(i).click();
 }
 
// gender.click();
 System.out.println("executed");
 Select city = new Select(driver.findElement(By.id("city")));
 city.selectByValue("mumbai");
 Select course = new Select(driver.findElement(By.id("course")));
 course.selectByValue("mba");
 Select district = new Select(driver.findElement(By.id("district")));
 district.selectByValue("goa");
 Select state = new Select(driver.findElement(By.id("state")));
 state.selectByValue("mca");
 WebElement pincode = driver.findElement(By.id("pincode"));
 pincode.sendKeys("94563");
 WebElement email = driver.findElement(By.id("emailid"));
 email.sendKeys("adam@gmail.com");
 WebElement submit = driver.findElement(By.className("bootbutton"));
 submit.click();
  Thread.sleep(3000);
 
// driver.close();
 
	
	
	}

}
