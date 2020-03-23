package zeroproject;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.collections.Sets;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Xero extends ReusableCode{
	//@Test
	public static void navigatetoXERO() {
		logger = report.startTest("navigatetoXERO");
		//launch App
		openUrl("https://login.xero.com/");
		SoftAssert softAssert= new SoftAssert();
		String title ="Login | Xero Accounting Software";
		softAssert.assertEquals(driver.getTitle(),title);
		//Enter userName
		WebElement userName = driver.findElement(By.id("email"));
		click(userName,"userName");
		enterText(userName,"luckytomstar1@gmail.com","userName");
		 userName = driver.findElement(By.id("email"));
		softAssert.assertEquals(userName.getAttribute("value"), "luckytomstar1@gmail.com");
		//Enter Password
		WebElement password = driver.findElement(By.name("password"));
		enterText(password,"123456789","password");
		softAssert.assertEquals(password.getAttribute("value"), "123456789");
		//Click on Log in button
		WebElement login = driver.findElement(By.id("submitButton"));
		click(login,"login/submitButton");
		Assert.assertEquals(driver.getTitle(),"My Xero | Add your organisation");
		softAssert.assertAll();
		}
	//@Test
	public static void inCorrectPassword()
	{
		logger = report.startTest("inCorrectPassword");
		//launch App
		openUrl("https://login.xero.com/");
		SoftAssert softAssert= new SoftAssert();
		String title ="Login | Xero Accounting Software";
		softAssert.assertEquals(driver.getTitle(),title);
		//Enter userName
		WebElement userName = driver.findElement(By.id("email"));
		click(userName,"userName");
		enterText(userName,"luckytomstar1@gmail.com","userName");
		 userName = driver.findElement(By.id("email"));
		softAssert.assertEquals(userName.getAttribute("value"), "luckytomstar1@gmail.com");
		//Enter Incorrect Password
		WebElement password = driver.findElement(By.name("password"));
		enterText(password,"1234567","password");
		softAssert.assertEquals(password.getAttribute("value"), "1234567");
		//Click on Log in button
		WebElement login = driver.findElement(By.id("submitButton"));
		click(login,"login/submitButton");
		//Error message should be displayed
		String eMessage ="Your email or password is incorrect";
		WebElement errorMessage =driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"));
		Assert.assertEquals(errorMessage.getText(),eMessage);
		softAssert.assertAll();
	}
	//@Test
	public static void inCorrectEmail()
	{
		logger = report.startTest("inCorrectEmail");
		//launch App
		openUrl("https://login.xero.com/");
		SoftAssert softAssert= new SoftAssert();
		String title ="Login | Xero Accounting Software";
		softAssert.assertEquals(driver.getTitle(),title);
		//Enter IncorrectuserName
		WebElement userName = driver.findElement(By.id("email"));
		click(userName,"IncorrectuserName");
		enterText(userName,"luckytomstar1@gmail","IncorrectuserName");
		 userName = driver.findElement(By.id("email"));
		softAssert.assertEquals(userName.getAttribute("value"), "luckytomstar1@gmail");
		//Enter correct Password
		WebElement password = driver.findElement(By.name("password"));
		enterText(password,"123456789","password");
		softAssert.assertEquals(password.getAttribute("value"), "123456789");
		//Click on Log in button
		WebElement login = driver.findElement(By.id("submitButton"));
		click(login,"login/submitButton");
		//Error message should be displayed
		String eMessage ="Your email or password is incorrect";
		WebElement errorMessage =driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"));
		Assert.assertEquals(errorMessage.getText(),eMessage);
		softAssert.assertAll();
		
	}
	//@Test
	public static void navigateToXERO() {
		logger = report.startTest("navigateToXERO");
		//launch App
		openUrl("https://login.xero.com/");
		SoftAssert softAssert= new SoftAssert();
		String title ="Login | Xero Accounting Software";
		softAssert.assertEquals(driver.getTitle(),title);
		//Click on forgot password
		WebElement password = driver.findElement(By.xpath("//a[@class='forgot-password-advert']"));
    	click(password,"Click on forgot password link");
    	//Forgotten Password page should be displayed
		String forgotPswdpage ="Forgotten Password";
		softAssert.assertEquals(driver.getTitle(),forgotPswdpage);
		//Test forgot Password
		WebElement submit = driver.findElement(By.id("submitButton"));
    	click(submit,"Click on submit button");
    	//verifying the link sent to email message
    	List<WebElement> sentMessage = driver.findElements(By.tagName("p"));
    	System.out.println(sentMessage.get(0).getText());
    	Assert.assertTrue(sentMessage.get(0).getText().contains("A link will be emailed to this address which will let you reset your password"));
		softAssert.assertAll();
		
	}
	//@Test
	public static void signUptoXDC() {
		logger = report.startTest("signUptoXDC");
		openUrl("https://www.xero.com/us/");
		
		String title ="Accounting Software - Do Beautiful Business | Xero US";
		Assert.assertEquals(driver.getTitle(),title);
	//freeTrail Button click
		WebElement freeTrialButton = driver.findElement(By.linkText("Free trial"));
		click(freeTrialButton,"freeTrailButton");
		String freeTrialTitlePage="Signup for Xero - Free Trial | Xero US";
		Assert.assertEquals(driver.getTitle(),freeTrialTitlePage);
		SoftAssert softAssert= new SoftAssert();
	//form details begins
		//Enter firstName
		WebElement firstName = driver.findElement(By.name("FirstName"));
		enterText(firstName,"lucky","firstName");
		//Enter LastName
		softAssert.assertEquals(true,firstName.getText().equals("lucky"));
		WebElement lastName = driver.findElement(By.name("LastName"));
		enterText(lastName,"star","lastName");
		softAssert.assertEquals(true,lastName.getText().equals("star"));
		//Enter Email
		WebElement email = driver.findElement(By.name("EmailAddress"));
		enterText(email,"luckytomstar1@gmail.com","EmailAddress");
		softAssert.assertEquals(true,email.getText().equals("luckytomstar1@gmail.com"));
		//Enter phone number
		WebElement PhoneNumber = driver.findElement(By.name("PhoneNumber"));
		enterText(PhoneNumber,"9456812345","PhoneNumber");
		softAssert.assertEquals(true,PhoneNumber.getText().equals("9456812345"));
		//Select country from ListBox and verify it is displayed 
		Select locationCode = new Select(driver.findElement(By.name("LocationCode")));
		locationCode.selectByVisibleText("United States");
		softAssert.assertEquals(true,locationCode.getFirstSelectedOption().getText().equals("United States"));
        //Select Terms and policy in the check box
			WebElement acceptCheck = driver.findElement(By.name("TermsAccepted"));
		click(acceptCheck,"acceptCheck");
		softAssert.assertEquals(true,acceptCheck.isSelected());
		//Click Get started Button
		WebElement submitButton = driver.findElement(By.className("btn btn-primary"));
		click(submitButton,"submitButton");
		softAssert.assertAll();
	}
	//@Test
	public static void signUptoXDC02() {
		logger = report.startTest("signUptoXDC02");
		openUrl("https://www.xero.com/us/");
	
		String title ="Accounting Software - Do Beautiful Business | Xero US";
		Assert.assertEquals(driver.getTitle(),title);
	//freeTrail Button click
		WebElement freeTrialButton = driver.findElement(By.linkText("Free trial"));
		click(freeTrialButton,"freeTrailButton");
		String freeTrialTitlePage="Signup for Xero - Free Trial | Xero US";
		Assert.assertEquals(driver.getTitle(),freeTrialTitlePage);
		SoftAssert softAssert= new SoftAssert();
		//Click Get Started Button without fill any field
		WebElement submit = driver.findElement(By.xpath("//button[contains(@class,' btn-primary')]"));
		click(submit,"submit");
		System.out.println("clickig on submit");
		//Error Message for "First name can't be empty is dispalyed"
WebElement noFirstName = driver.findElement(By.id("signup-form-error-message-1"));
softAssert.assertTrue(noFirstName.getText().contains("First name can't be empty"),"Firstname error verified");
//Error Message for "Last name can't be empty is dispalyed"
WebElement noLastName = driver.findElement(By.id("signup-form-error-message-2"));
softAssert.assertTrue(noLastName.getText().contains("Last name can't be empty"),"LastName error verified");
//Error Message for "Email can't be empty is dispalyed"
WebElement email = driver.findElement(By.id("signup-form-error-message-3"));
softAssert.assertTrue(email.getText().contains("Email address can't be empty"),"Email error verified");
//Error Message for "Phone Number can't be empty is dispalyed"
WebElement phoneNumber = driver.findElement(By.id("signup-form-error-message-4"));
softAssert.assertTrue(phoneNumber.getText().contains("Phone number can't be empty"),"phoneNumber error verified");
//Enter wrong EmailID
WebElement wrongEmail = driver.findElement(By.name("EmailAddress"));
enterText(wrongEmail,"luckytomstar1@gmail","EmailAddress");
WebElement emailError = driver.findElement(By.id("signup-form-error-message-5"));
softAssert.assertEquals(emailError.getText(), "signup-form-error-message-5");
//Click the Get Started Button without select the term and policy checkbox
submit = driver.findElement(By.xpath("//button[contains(@class,' btn-primary')]"));
click(submit,"submit");
String color = driver.findElement(By.name("TermsAccepted")).getCssValue("color");
System.out.println("color"+color);
softAssert.assertAll();
}
	
	//@Test
public static void signUptoXDCTC02C() {
	logger = report.startTest("signUptoXDCTC02C");
	openUrl("https://www.xero.com/us/");
	SoftAssert softAssert= new SoftAssert();
	String title ="Accounting Software - Do Beautiful Business | Xero US";
	Assert.assertEquals(driver.getTitle(),title);
	
	//freeTrail Button click
			WebElement freeTrialButton = driver.findElement(By.linkText("Free trial"));
			click(freeTrialButton,"freeTrailButton");
			String freeTrialTitlePage="Signup for Xero - Free Trial | Xero US";
			Assert.assertEquals(driver.getTitle(),freeTrialTitlePage);
			String parentWindow =  driver.getWindowHandle();
			//Click the terms of use link
			WebElement terms = driver.findElement(By.xpath("//a[contains(text(),'terms')]"));
			click(terms," Terms link");
			Set<String> winHandles = driver.getWindowHandles();
	        // Loop through all handles
	        for(String handle: winHandles){
	            if(!handle.equals(parentWindow)){
	            driver.switchTo().window(handle);
			softAssert.assertEquals(driver.getTitle(),"Terms of Use | Xero US");
			driver.close();
	            }
	        }
	        driver.switchTo().window(parentWindow);
			//Click the privacy of use link
			WebElement privacy = driver.findElement(By.xpath("//a[contains(text(),'privacy')]"));
			click(privacy," privacy link");
			winHandles = driver.getWindowHandles();
	        // Loop through all handles
	        for(String handle: winHandles){
	            if(!handle.equals(parentWindow)){
	            driver.switchTo().window(handle);
			softAssert.assertEquals(driver.getTitle(),"Privacy Notice | Xero US");
			driver.close();
	            }
	        }
	        driver.switchTo().window(parentWindow);
			softAssert.assertAll();
}
	//@Test
	public static void signUptoXDCTC02D() {
		logger = report.startTest("signUptoXDCTC02D");
		openUrl("https://www.xero.com/us/");
		SoftAssert softAssert= new SoftAssert();
		String title ="Accounting Software - Do Beautiful Business | Xero US";
		Assert.assertEquals(driver.getTitle(),title);
		
		//freeTrail Button click
				WebElement freeTrialButton = driver.findElement(By.linkText("Free trial"));
				click(freeTrialButton,"freeTrailButton");
				String freeTrialTitlePage="Signup for Xero - Free Trial | Xero US";
				Assert.assertEquals(driver.getTitle(),freeTrialTitlePage);
				//Get ParentWindow handle
				String parentWindow =  driver.getWindowHandle();
				//click "See full Offer Details" link
				WebElement offerDetails = driver.findElement(By.xpath("//a[contains(text(),'offer details')]"));
				click(offerDetails," offerDetails link");
				Set<String> winHandles = driver.getWindowHandles();
		        // Loop through all handles
		        for(String handle: winHandles){
		            if(!handle.equals(parentWindow)){
		            driver.switchTo().window(handle);
				softAssert.assertEquals(driver.getTitle(),"Offer details | Xero US");
				driver.close();
		            }
		        }
		        driver.switchTo().window(parentWindow);
				softAssert.assertAll();
		}
	//@Test
	public static void signUptoXDCTC02E() {
		logger = report.startTest("signUptoXDCTC02E");
		openUrl("https://www.xero.com/us/");
		SoftAssert softAssert= new SoftAssert();
		String title ="Accounting Software - Do Beautiful Business | Xero US";
		Assert.assertEquals(driver.getTitle(),title);
		
		//freeTrail Button click
				WebElement freeTrialButton = driver.findElement(By.linkText("Free trial"));
				click(freeTrialButton,"freeTrailButton");
				String freeTrialTitlePage="Signup for Xero - Free Trial | Xero US";
				Assert.assertEquals(driver.getTitle(),freeTrialTitlePage);
				//Click on accountant or bookkeeper link
				WebElement accountantOrBookkeeper = driver.findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"));
				click(accountantOrBookkeeper," accountantOrBookkeeper link");
				Assert.assertEquals(driver.getTitle(),"Sign up for the Xero Partner Program | Xero US");
					}
	//@Test
	public static void testAllTabsPageTC03()
	{
		logger = report.startTest("testAllTabsPageTC03");
		//launch App
		openUrl("https://login.xero.com/");
		SoftAssert softAssert= new SoftAssert();
		String title ="Login | Xero Accounting Software";
		softAssert.assertEquals(driver.getTitle(),title);
		//Enter userName
		WebElement userName = driver.findElement(By.id("email"));
		click(userName,"userName");
		enterText(userName,"luckytomstar1@gmail.com","userName");
		 userName = driver.findElement(By.id("email"));
		softAssert.assertEquals(userName.getAttribute("value"), "luckytomstar1@gmail.com");
		//Enter Password
		WebElement password = driver.findElement(By.name("password"));
		enterText(password,"123456789","password");
		softAssert.assertEquals(password.getAttribute("value"), "123456789");
		//Click on Log in button
		WebElement login = driver.findElement(By.id("submitButton"));
		click(login,"login/submitButton");
		softAssert.assertEquals(driver.getTitle(),"My Xero | Home");
		//click on go to xo page
		WebElement gotoXo =driver.findElement(By.xpath("//span[contains(text(),'Go back to xo')]"));
		click(gotoXo,"gotoXo");
		//click on dashboard of xero
		WebElement dashboard = driver.findElement(By.xpath("//a[@name='navigation-menu/dashboard']"));
		click(dashboard,"dashboard");
		softAssert.assertEquals(driver.getTitle(),"Xero | Dashboard | xo ");
		//click on accounts of xero
		WebElement accounts = driver.findElement(By.xpath("//button[@name='navigation-menu/accounting']"));
		click(accounts,"accounts");
		//verifying the dropdown
		WebElement bankaccount = driver.findElement(By.xpath("//a[contains(text(),'Bank accounts')]"));
		softAssert.assertTrue(bankaccount.isDisplayed(), "bankaccount is displayed");
		//click on report of xero
		WebElement report = driver.findElement(By.xpath("//a[contains(text(),'Reports')]"));
		click(report,"report");
		softAssert.assertEquals(driver.getTitle(),"Xero | Reports | xo");
		//click on contact of xero
		WebElement contact = driver.findElement(By.xpath("//button[@name='navigation-menu/contacts']"));
		click(contact,"contact");
		//verifying the dropdown for contact button 
		WebElement allcontacts = driver.findElement(By.xpath("//a[contains(text(),'All contacts')]"));
		softAssert.assertTrue(allcontacts.isDisplayed(), "allcontacts is displayed");
		//Getting all the tabs
		List <WebElement> icons = driver.findElements(By.className("xrh-addon"));
		//click on "+" /(new)tab of xero
		icons.get(0).click();
		//verifying the dropdown
		WebElement invoice = driver.findElement(By.linkText("Invoice"));
		softAssert.assertTrue(invoice.isDisplayed(), "invoice is displayed");
		WebElement Bill = driver.findElement(By.linkText("Bill"));
		softAssert.assertTrue(Bill.isDisplayed(), "Bill is displayed");
		//click on notification
		softAssert.assertTrue(icons.get(1).isDisplayed(), "notificationDropdown is displayed");
	//click on search tab
		WebElement searchText = driver.findElement(By.xpath("//input[@id='reportcenter-search-field']"));
		softAssert.assertTrue(searchText.isDisplayed(), "searchText is displayed");
		//click on help tab
		icons.get(2).click();
		WebElement helpsearchText = driver.findElement(By.xpath("//input[@id='menu_help']"));
		System.out.println(helpsearchText.getText());
		softAssert.assertTrue(helpsearchText.getAttribute("placeholder").contains("What do you need help with?"),"help meassage");
		softAssert.assertAll();
		
	}
	//@Test
	public static void testLogoutFunctionalityTC04() {
		logger = report.startTest("testLogoutFunctionalityTC04");
		//launch App
		openUrl("https://login.xero.com/");
		SoftAssert softAssert= new SoftAssert();
		String title ="Login | Xero Accounting Software";
		softAssert.assertEquals(driver.getTitle(),title);
		//Enter userName
		WebElement userName = driver.findElement(By.id("email"));
		click(userName,"userName");
		enterText(userName,"luckytomstar1@gmail.com","userName");
		 userName = driver.findElement(By.id("email"));
		softAssert.assertEquals(userName.getAttribute("value"), "luckytomstar1@gmail.com");
		//Enter Password
		WebElement password = driver.findElement(By.name("password"));
		enterText(password,"123456789","password");
		softAssert.assertEquals(password.getAttribute("value"), "123456789");
		//Click on Log in button
		WebElement login = driver.findElement(By.id("submitButton"));
		click(login,"login/submitButton");
		softAssert.assertEquals(driver.getTitle(),"My Xero | Home");


		//click on userinfo of xero
			WebElement usernamedisplayed =driver.findElement(By.className("username"));
			click(usernamedisplayed,"usernamedisplayed");
		Assert.assertTrue(usernamedisplayed.getText().contains("Lucky"));
		//click on logout
		WebElement logouticon =driver.findElement(By.linkText("Logout"));
		click(logouticon,"logouticon");
		WebDriverWait wait = new WebDriverWait(driver,5,1000);
		wait.until(ExpectedConditions.titleContains("Login | Xero Accounting Software"));
				
		Assert.assertEquals(driver.getTitle(),"Login | Xero Accounting Software");
	}
	//@Test
	public static void testUploadProfileImage() throws Exception {
		logger = report.startTest("testUploadProfileImage");
		//launch App
		openUrl("https://login.xero.com/");
		SoftAssert softAssert= new SoftAssert();
		String title ="Login | Xero Accounting Software";
		softAssert.assertEquals(driver.getTitle(),title);
		//Enter userName
		WebElement userName = driver.findElement(By.id("email"));
		click(userName,"userName");
		enterText(userName,"luckytomstar1@gmail.com","userName");
		 userName = driver.findElement(By.id("email"));
		softAssert.assertEquals(userName.getAttribute("value"), "luckytomstar1@gmail.com");
		//Enter Password
		WebElement password = driver.findElement(By.name("password"));
		enterText(password,"123456789","password");
		softAssert.assertEquals(password.getAttribute("value"), "123456789");
		//Click on Log in button
		WebElement login = driver.findElement(By.id("submitButton"));
		click(login,"login/submitButton");
		softAssert.assertEquals(driver.getTitle(),"My Xero | Home");
		//Clicking on username
		WebElement usernamedisplayed =driver.findElement(By.className("username"));
		click(usernamedisplayed,"usernamedisplayed");
	Assert.assertTrue(usernamedisplayed.getText().contains("Lucky"));
	//clicking on profile
	WebElement profile =driver.findElement(By.linkText("Profile"));
	click(profile,"profile");
	Assert.assertEquals(driver.getTitle(),"My Xero | Profile Settings");
	Actions action = new Actions(driver);
	//click to remove previousupload
	
	List<WebElement> remove = driver.findElements(By.xpath("//div[@data-automationid='removeImageButton']"));
	if(remove.size()>0)
	{
		action.moveToElement(remove.get(0)).click().perform();
	}
	//click on upload button
	WebElement upload =driver.findElement(By.xpath("//div[@data-automationid='uploadImageButton']"));
		action.moveToElement(upload).click().perform();
	//click(upload,"upload button");
	//click on browse button C:\Users\vamsi\Pictures\Screenshots
	WebElement browse =driver.findElement(By.name("file"));
	//enterText(browse,"C:\\Users\\vamsi\\Pictures\\Screenshots\\pic.png","uploading picture");
	browse.sendKeys("C:\\Users\\vamsi\\Pictures\\Screenshots\\pic.png");
	Thread.sleep(5000);
WebElement clickUpload = driver.findElement(By.xpath("//span[@id='button-1178-btnInnerEl']"));
	click(clickUpload,"clickUpload");
	WebElement img =driver.findElement(By.xpath("//img[@class='your-logo']"));
		//verifying the img is uploaded
	//WebElement img = driver.findElement(By.xpath("//img[@class='xn-h-profile-card-avatar']"));
	Assert.assertTrue(img.isDisplayed());
	}
	
	@Test
	public  void addorganizationTrailVersion01() throws InterruptedException {
		logger = report.startTest("addorganizationTrailVersion01");
		//calling loggingIn method
		logInMethod(driver,logger);
		//clicking on add new organization button
		WebElement addOrg=driver.findElement(By.xpath("//a[contains(text(),'Add an organization')] "));
		click(addOrg,"Add new Organization");
		System.out.println("clicked button");
		Assert.assertEquals(driver.getTitle(),"My Xero | Add your organisation");
		//Enter the organization name
		WebElement orgName = driver.findElement(By.xpath("//input[@data-automationid='organisation-name--input']"));
		enterText(orgName,"self","orgName");
		WebElement industry = driver.findElement(By.xpath("//input[@data-automationid='industry-autocompleter--input']"));
		enterText(industry,"Accounting Practise","industry");
		//click on timeZone
		WebElement timezonelist = driver.findElement(By.xpath("//div[@data-automationid='timezone-autocompleter--trigger']"));
		click(timezonelist,"timezonelist");
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='TIMEZONE/PACIFICSTANDARDTIME']"))).click();
		WebElement pacificTime = driver.findElement(By.xpath("//li[@id='TIMEZONE/PACIFICSTANDARDTIME']"));
		Actions action = new Actions(driver);
		action.moveToElement(pacificTime).perform();
		action.click(pacificTime).perform();
				//click(pacificTime,"pacificTime");
		List<WebElement> radiobutton = driver.findElements(By.className("xui-styledcheckboxradio--radio"));
		radiobutton.get(1).click();
		//Click on start Trial
		WebElement startTrial =driver.findElement(By.xpath("//button[contains(text(),'Start trial')]"));
		click(startTrial,"startTrial");
		
		
	}
	 public void logInMethod(WebDriver driver,ExtentTest report) {
		 openUrl("https://login.xero.com/");
			SoftAssert softAssert= new SoftAssert();
			String title ="Login | Xero Accounting Software";
			softAssert.assertEquals(driver.getTitle(),title);
			//Enter userName
			WebElement userName = driver.findElement(By.id("email"));
			click(userName,"userName");
			enterText(userName,"luckytomstar1@gmail.com","userName");
			 userName = driver.findElement(By.id("email"));
			softAssert.assertEquals(userName.getAttribute("value"), "luckytomstar1@gmail.com");
			//Enter Password
			WebElement password = driver.findElement(By.name("password"));
			enterText(password,"123456789","password");
			softAssert.assertEquals(password.getAttribute("value"), "123456789");
			//Click on Log in button
			WebElement login = driver.findElement(By.id("submitButton"));
			click(login,"login/submitButton");
			Assert.assertEquals(driver.getTitle(),"My Xero | Home");
			
	}
}
