package sfdc_Testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.Objects;
import com.relevantcodes.extentreports.LogStatus;

public class SFDC_TestCases extends ReuseFunctionsSFDC {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		CreateReport();
		
		//TC_2_LoginToSalesForce();
		// TC_5();
		// TC06();
	//TC07();
	//tc08();
		//tc09();
		//tC11Createnewview();
		//tC12Editview();
		//tC13MergeAccounts();
		//tC14();
		//tc15();
		//tC16();
		//tC17();
		//testStuckOpportunitiesReport();
		//testQuarterlySummaryReport();
		//tC20leadsTab();
		//tC21leadsSelectView();
		//tC22defaultView();
		//tC23();
		//tC24();
		//createNewContactTC25();
		//createNewViewTC26();
		//tC27();
		//checkMyContactsViewTC28();
		//viewContactInContactPageTC29();
		//tC30();
		//cancelButtonInCreateNewViewTC31();
		//checkSaveAndNewButtonTC32();
		//tC33();
		//tC34();
		//verifyTabCustomizationTC35();
		//blockingAnEventInCalenderTC36();
		blockAnEventCalendarReccuranceTC37();

		// CloseBrowser();
		CloseReport();
	}

	public static void TC_2_LoginToSalesForce() {
		logger = report.startTest("TC_2_LoginToSalesForce");

		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");

		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			logger.log(LogStatus.PASS, "User is on home page");
		// System.out.println("User is on home page");
		else
			logger.log(LogStatus.FAIL, "home page is not Lunched");
		// System.out.println("home page is not Lunched");
	}

	public static void TC_5() {
		logger = report.startTest("TC_5");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		Click(userMenu, "UserMenuDropdown");
		WebElement myProfile = driver.findElement(By.linkText("My Profile"));
		if (myProfile.isDisplayed()) {
			System.out.println("myProfile is verified");
		} else {
			System.out.println("myProfile failed");
		}

		WebElement mySettings = driver.findElement(By.linkText("My Settings"));
		if (mySettings.isDisplayed()) {
			System.out.println("mySettings is verified");
		} else {
			System.out.println("mySettings failed");
		}

		WebElement switchtoLightningExperience = driver.findElement(By.linkText("Switch to Lightning Experience"));
		if (switchtoLightningExperience.isDisplayed()) {
			System.out.println("switchtoLightningExperience is verified");
		} else {
			System.out.println("switchtoLightningExperience failed");
		}

		WebElement developerConsole = driver.findElement(By.linkText("Developer Console"));
		if (developerConsole.isDisplayed()) {
			System.out.println("developerConsole is verified");
		} else {
			System.out.println("developerConsole failed");
		}

		WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));

		if (logOut.isDisplayed()) {
			System.out.println("logOut is verified");
		} else {
			System.out.println("logOut failed");
		}

	}

	public static void TC06() throws InterruptedException {
		logger = report.startTest("TC06");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		Click(userMenu, "UserMenuDropdown");
		WebElement myProfile = driver.findElement(By.linkText("My Profile"));
		Click(myProfile, "MyProfile");
		Thread.sleep(3000);
		String myProfilTitle = "User: gayatri Balumuri ~ Salesforce - Developer Edition";
		if (driver.getTitle().contains(myProfilTitle)) {
			System.out.println("myProfileUrl is valid");
		} else {
			System.out.println("myProfileUrl not valid");
		}
	Thread.sleep(5000);
		WebElement editIcon = driver.findElement(By.cssSelector(".contactInfoLaunch > img:nth-child(1)"));
		Click(editIcon, "Edit Icon ");
		WebElement editProfilePage = driver.findElement(By.id("contactInfoX"));
		if (editProfilePage.isDisplayed()) {
			System.out.println("EditProfilePage is displayed");
		} else {
			System.out.println("EditProfilePage is not displayed");
		}
		//Thread.sleep(2000);
		driver.switchTo().frame("contactInfoContentId");
		WebElement about = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		Click(about, "About tab ");
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.clear();
		EnterText(lastName, "Balumuri", "Lastname");
		WebElement save1 = driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
		Click(save1, "save Button ");
				driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		WebElement post = driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]"));
	Click(post, "Post link ");
		//driver.navigate().refresh();
	//	Thread.sleep(3000);
		WebElement iframeText = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframeText);
		//iframeText.click();
		//iframeText.findElement(by)
		Thread.sleep(3000);
		WebElement postBody = driver.findElement(By.tagName("body"));
		Click(postBody, "Post link ");
		EnterText(postBody, "Iframe text field is working and can post text messages", "Iframe text field");
	
		driver.switchTo().defaultContent();
		WebElement shareButton = driver.findElement(By.id("publishersharebutton"));
		Click(shareButton, "shareButton ");
		//driver.switchTo().defaultContent();

WebElement FileLink = driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]"));
Click(FileLink, "FileLink");
WebElement UploadFile = driver.findElement(By.id("chatterUploadFileAction"));
Click(UploadFile, "UploadFile");

//Thread.sleep(5000);
WebElement choosefile = driver.findElement(By.xpath("//input[@id='chatterFile']"));
//EnterText(choosefile, "C:\\Users\\admin\\Desktop\\SFDC 37 Testcases.xlsx", "choosefile");
EnterText(choosefile, "C:\\Users\\vamsi\\Desktop\\tc22.txt", "choosefile");

WebElement Share = driver.findElement(By.id("publishersharebutton"));
Click(Share, "ShareButton");
Thread.sleep(10000);
Actions action=new Actions(driver);
WebElement onPhoto = driver.findElement(By.xpath("//a[@id='uploadLink']"));
action.moveToElement(onPhoto).build().perform();
onPhoto.click();
driver.switchTo().frame("uploadPhotoContentId");
Thread.sleep(3000);/*
WebElement browsePhoto = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
EnterText(browsePhoto,"C:\\Users\\vamsi\\Pictures\\Screenshots\\pic.png","browsePhoto");
WebElement savePhoto = driver.findElement(By.id("j_id0:uploadFileForm:save"));
Click(savePhoto,"savePhoto");
Thread.sleep(5000);
WebElement savePic = driver.findElement(By.id("j_id0:j_id7:save"));
Click(savePic,"SavePic");
Thread.sleep(15000);*/

WebElement choosefileoption = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
EnterText(choosefileoption, "C:\\Users\\vamsi\\Pictures\\Screenshots\\pic.png", "choosefileoption");
WebElement save = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
Click(save, "save");
System.out.println("TC06_MyProfile completed successfully");
Thread.sleep(3000);
WebElement save2 = driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']"));
Click(save2,"Save Crop");

Thread.sleep(15000);

	}

	public static void TC07() throws InterruptedException {
		logger = report.startTest("TC07");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		Click(userMenu, "UserMenuDropdown");
		WebElement mySettings = driver.findElement(By.linkText("My Settings"));
		Click(mySettings, "Settings menuItem");
		Thread.sleep(1000);

		String settingUrl = "Hello, gayatri Balumuri! ~ Salesforce - Developer Edition";
		if (driver.getTitle().contains(settingUrl)) {
			System.out.println("mySettings is verified");
		} else {
			System.out.println("mySettings failed");
		}

		WebElement personalTab = driver.findElement(By.xpath("//span[@id='PersonalInfo_font']"));
		Click(personalTab, "Personal Tab");

		WebElement loginHistory = driver.findElement(By.id("LoginHistory_font"));
		Click(loginHistory, "loginHistory Tab");
		WebElement verifyCSVFile = driver
				.findElement(By.partialLinkText("Download login history for last six months,"));
		if (verifyCSVFile.isDisplayed()) {
			System.out.println("Link is present");
		} else {
			System.out.println("link not present");
		}
		verifyCSVFile.click();
		WebElement displayAndLayout = driver.findElement(By.id("DisplayAndLayout_font"));
		Click(displayAndLayout, "DisplayAndLayout Tab");
		WebElement customizeTabs = driver.findElement(By.id("CustomizeTabs_font"));
		Click(customizeTabs, "Customize Tab");
		Select customApp = new Select(driver.findElement(By.id("p4")));
		customApp.selectByValue("02u6g000001dnMl");
		Select availableTabs = new Select(driver.findElement(By.id("duel_select_0")));
		availableTabs.selectByValue("report");
		WebElement nextArrow = driver.findElement(By.id("duel_select_0_right"));
		Click(nextArrow, "Next Arrow button");
		Thread.sleep(5000);
		WebElement saveButton = driver.findElement(By.xpath("//input[@name='save']"));
		Click(saveButton, "Save button");
		WebElement reportTab = driver.findElement(By.xpath("//*[@id=\"report_Tab\"]"));
		if (reportTab.isDisplayed()) {
			System.out.println("verified Report Tab");
		} else {
			System.out.println("Report Tab not present");
		}
		WebElement emailTab = driver.findElement(By.id("EmailSetup"));
		Click(emailTab, "Email button");
		WebElement emailSettings = driver.findElement(By.xpath("//*[@id=\"EmailSettings_font\"]"));
		Click(emailSettings, "Email Settings");
		WebElement emailName = driver.findElement(By.id("sender_name"));
		emailName.clear();
		EnterText(emailName, "gayatri", "Email Name");
		WebElement emailAddress = driver.findElement(By.id("sender_email"));
		emailAddress.clear();
		EnterText(emailAddress, "gayatri@gmail.com", "Email Address");

		WebElement auto_bcc = driver.findElement(By.id("auto_bcc1"));
		Click(auto_bcc, "Auto BCC");
		WebElement saveBtn = driver.findElement(By.name("save"));
		Click(saveBtn, "save button Emailtab");
		driver.switchTo().alert().accept();
		WebElement messageText = driver.findElement(By.className("messageText"));
		String expectedmessageText = "Given details are saved as default mail options and My settings page is displayed.";
		if (messageText.getText().contains(expectedmessageText)) {
			System.out.println("Email details are saved succesfully");
		} else {
			System.out.println("Email details are noot Saved");
		}

		WebElement calendarAndReminders = driver.findElement(By.id("CalendarAndReminders_font"));
		Click(calendarAndReminders, "CalendarAndReminders Tab");
		WebElement reminders = driver.findElement(By.id("Reminders_font"));
		Click(reminders, "Reminders Tab");
		String calendarOriginalWindow = driver.getWindowHandle();
		WebElement testButton = driver.findElement(By.id("testbtn"));
		Click(testButton, "TestButton tab");
		Thread.sleep(3000);
		List<String> windowHandles = new LinkedList<String>();
		windowHandles.addAll(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		String popUpWindowUrl = driver.getCurrentUrl();
		String expectedpopUpWindowUrl = "https://na174.salesforce.com/ui/core/activity/ActivityReminderPage";
		if (popUpWindowUrl.contains(expectedpopUpWindowUrl)) {
			System.out.println("popup window verified");
		} else {
			System.out.println("popup window not verified");
		}

	}
	public static void tc08() throws InterruptedException {
		logger = report.startTest("tc08");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		String homeWindow = driver.getWindowHandle();
		WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		Click(userMenu, "UserMenuDropdown");
		WebElement myProfile = driver.findElement(By.linkText("My Profile"));
		if (myProfile.isDisplayed()) {
			System.out.println("myProfile is verified");
		} else {
			System.out.println("myProfile failed");
		}

		WebElement mySettings = driver.findElement(By.linkText("My Settings"));
		if (mySettings.isDisplayed()) {
			System.out.println("mySettings is verified");
		} else {
			System.out.println("mySettings failed");
		}

		WebElement switchtoLightningExperience = driver.findElement(By.linkText("Switch to Lightning Experience"));
		if (switchtoLightningExperience.isDisplayed()) {
			System.out.println("switchtoLightningExperience is verified");
		} else {
			System.out.println("switchtoLightningExperience failed");
		}

		WebElement developerConsole = driver.findElement(By.linkText("Developer Console"));
		if (developerConsole.isDisplayed()) {
			System.out.println("developerConsole is verified");
		} else {
			System.out.println("developerConsole failed");
		}

		WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));

		if (logOut.isDisplayed()) {
			System.out.println("logOut is verified");
		} else {
			System.out.println("logOut failed");
		}
Click(developerConsole,"developer console");
List<String> windowHandles = new LinkedList<String>();
windowHandles.addAll(driver.getWindowHandles());
driver.switchTo().window(windowHandles.get(1));
driver.close();
driver.switchTo().window(homeWindow);
String actualUrl=driver.getTitle();
String expextedUrl ="Home Page ~ Salesforce - Developer Edition";
if(actualUrl.equalsIgnoreCase(expextedUrl))
		{
	System.out.println("developer console window is closed");
		}
else
{
	System.out.println("developer console window is not closed");
}
	}
	public static void tc09() throws InterruptedException {
		
		logger = report.startTest("tc08");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		String homeWindow = driver.getWindowHandle();
		WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		Click(userMenu, "UserMenuDropdown");
		WebElement myProfile = driver.findElement(By.linkText("My Profile"));
		if (myProfile.isDisplayed()) {
			System.out.println("myProfile is verified");
		} else {
			System.out.println("myProfile failed");
		}

		WebElement mySettings = driver.findElement(By.linkText("My Settings"));
		if (mySettings.isDisplayed()) {
			System.out.println("mySettings is verified");
		} else {
			System.out.println("mySettings failed");
		}

		WebElement switchtoLightningExperience = driver.findElement(By.linkText("Switch to Lightning Experience"));
		if (switchtoLightningExperience.isDisplayed()) {
			System.out.println("switchtoLightningExperience is verified");
		} else {
			System.out.println("switchtoLightningExperience failed");
		}

		WebElement developerConsole = driver.findElement(By.linkText("Developer Console"));
		if (developerConsole.isDisplayed()) {
			System.out.println("developerConsole is verified");
		} else {
			System.out.println("developerConsole failed");
		}

		WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));

		if (logOut.isDisplayed()) {
			System.out.println("logOut is verified");
		} else {
			System.out.println("logOut failed");
		}
		Click(logOut,"logout");
		Thread.sleep(3000);
		String actualurl=driver.getTitle();
		String expectedurl = "Login | Salesforce";
		if(actualurl.equalsIgnoreCase(expectedurl))
				{
			System.out.println("logout success");
				}
		else
		{
			System.out.println("logout failed");
		}
	}
	public static void tC10CreateAccount() throws InterruptedException {
		logger = report.startTest("tc08");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		OpenUrl("https://login.salesforce.com");
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		String accountPageWindow = driver.getWindowHandle();
		WebElement accountLink = driver.findElement(By.className("relatedListIcon"));
		Click(accountLink,"Account Link");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		 WebElement newButton = driver.findElement(By.name("new")); newButton.click();
		  System.out.println("button is clicking"); 
		  WebElement accountName = driver.findElement(By.id("acc2"));
		  String name ="gayatrii";
		 EnterText(accountName,name,"Account Name");
		  Select type = new Select(driver.findElement(By.id("acc6")));
		  type.selectByValue("Technology Partner");
		  Select customerProirity= new Select(driver.findElement(By.id("00N6g00000Mu55n")));
		  customerProirity.selectByValue("High"); 
		  WebElement save = driver.findElement(By.name("save")); 
		  Click(save,"Save Button");
		  WebElement displayName = driver.findElement(By.className("topName"));
		  String expectedName = displayName.getText();
		  if(expectedName.contentEquals(name)) {
			  System.out.println("Account details created succesfully");
		  }
		  else
		  {
			  System.out.println("Account details not saved");
		  }
	}
	public static void tC11Createnewview() throws InterruptedException
	{
		logger = report.startTest("tC11Createnewview");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		Thread.sleep(3000);
		WebElement accountLink = driver.findElement(By.className("relatedListIcon"));
		Click(accountLink,"Account Link");
		Thread.sleep(3000);
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		
		WebElement createNewView = driver.findElement(By.linkText("Create New View"));
		createNewView.click();
	Thread.sleep(3000);
		WebElement fname = driver.findElement(By.name("fname"));
		String viewName ="MyName1";
		EnterText(fname,viewName,"ViewName");
		WebElement devname = driver.findElement(By.name("devname"));
		EnterText(devname,"myUniqueName1","MyUniqueName");
	
		WebElement saveBtn = driver.findElement(By.name("save"));
		Click(saveBtn,"SaveButton");
		Select newlyCreatedViewName =new Select(driver.findElement(By.id("00B6g00000BqipT_listSelect")));
		newlyCreatedViewName.selectByVisibleText(viewName);
		


	}
	public static void tC12Editview() throws InterruptedException {
		logger = report.startTest("tC12Createnewview");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		Thread.sleep(3000);
		WebElement accountLink = driver.findElement(By.className("relatedListIcon"));
		Click(accountLink,"Account Link");
		Thread.sleep(3000);
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		WebElement editButton = driver.findElement(By.linkText("Edit"));
		Click(editButton,"EditButton");
		WebElement fname = driver.findElement(By.name("fname"));
		fname.clear();
		String viewName ="newViewName1";
		EnterText(fname,viewName,"ViewName");
		Thread.sleep(3000);
		Select  field = new Select(driver.findElement(By.id("fcol1")));
		field.selectByValue("ACCOUNT.NAME");
		Select  operator = new Select(driver.findElement(By.className("operator")));
		operator.selectByValue("c");
		WebElement value = driver.findElement(By.id("fval1"));
		EnterText(value, "a", "Value Text");
		  Select lastActivityAccount = new Select(driver.findElement(By.id("colselector_select_0")));
			lastActivityAccount.selectByValue("ACCOUNT.LAST_ACTIVITY");
			WebElement rigthArrow = driver.findElement(By.className("rightArrowIcon"));
			Click(rigthArrow,"Rigth arrow");
			Thread.sleep(3000);
		WebElement saveButton = driver.findElement(By.xpath("//input[@value=' Save ']"));
		Click(saveButton,"Save Button in EditTab");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		WebElement lastActivityColumn = driver.findElement(By.xpath("//div[@title='Last Activity']"));
if(lastActivityColumn.isDisplayed())
{
	System.out.println("lastActivityColumn is present");
	
}
else
{
	System.out.println("lastActivityColumn not present");
}
}
	public static void tC13MergeAccounts() throws InterruptedException
	{
		logger = report.startTest("tC13MergeAccount");
		
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		Thread.sleep(3000);
		WebElement accountLink = driver.findElement(By.className("relatedListIcon"));
		Click(accountLink,"Account Link");
		Thread.sleep(3000);
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		WebElement mergeAccountLink =driver.findElement(By.linkText("Merge Accounts"));
		Click(mergeAccountLink,"MergeAccount Link");
		WebElement mergeAccountSearch = driver.findElement(By.id("srch"));
		EnterText(mergeAccountSearch, "gayatri", "Account Name");
		WebElement mergeAccounSearchButton =driver.findElement(By.name("srchbutton"));
		Click(mergeAccounSearchButton,"MergeAccount Search Button");
		List<WebElement> checkboxList = driver.findElements(By.name("cid"));
		for(int i=2;i<checkboxList.size();i++)
		{
					if(checkboxList.get(i).isSelected())
		{
			checkboxList.get(i).click();
		}
		}
		WebElement nextButton =driver.findElement(By.name("goNext"));
		Click(nextButton,"next Button");
		WebElement mergeButton =driver.findElement(By.name("save"));
		Click(mergeButton,"next Button");
	 Alert alert=driver.switchTo().alert();
	 String alertText= alert.getText();
	 System.out.println("Alert window is present"+alertText);
	 alert.accept();
	 
	}
	public static void tC14() throws InterruptedException
	{
          logger = report.startTest("tC14");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		Thread.sleep(3000);
		WebElement accountLink = driver.findElement(By.className("relatedListIcon"));
		Click(accountLink,"Account Link");
		Thread.sleep(3000);
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		if(userMenu.isDisplayed())
		{
			System.out.println("Username in the account page is displayed");
		}
		else
		{
			System.out.println("Username in the account page is not displayed");
		}
		WebElement accountLastActivityLink = driver.findElement(By.linkText("Accounts with last activity > 30 days"));
		Click(accountLastActivityLink,"Accounts with last activity > 30 days");
		WebElement lastActivityDropdown = driver.findElement(By.className("dateColumn"));
		Click(lastActivityDropdown,"lastActivity Dropdown");
		List<WebElement> dropDownlist = driver.findElements(By.className("x-combo-list-item"));
		dropDownlist.get(1).click();
		WebElement startDate = driver.findElement(By.xpath("//img[@id='ext-gen152']"));
		Click(startDate,"startDate calender");
		WebElement saveReportBtn = driver.findElement(By.id("saveReportBtn"));
		Click(saveReportBtn,"SaveReportButton");
		Thread.sleep(3000);
		WebElement reportName = driver.findElement(By.id("saveReportDlg_reportNameField"));
		EnterText(reportName,"MyreportName", "ReportName");
		WebElement reportUniqueName = driver.findElement(By.id("saveReportDlg_DeveloperName"));
		EnterText(reportUniqueName, "MyreportUName", "ReportUniqueName");
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		for(WebElement saveAndRunbtn : buttons)
		{
			String buttonText =saveAndRunbtn.getText();
			if(buttonText.equalsIgnoreCase("Save and Run Report"))
			{
		         saveAndRunbtn.click();
			}
		}
		
		Thread.sleep(3000);
		WebElement nameOnReport = driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']"));
		if(nameOnReport.isDisplayed())
		{
			System.out.println("Name on the report is verified");
		}
		else
		{
			System.out.println("Name on the report is not verified");	
		}
		
	}
	public static void tc15() throws InterruptedException
	{
		 logger = report.startTest("tc15");
			OpenUrl("https://login.salesforce.com");
			logger.log(LogStatus.INFO, "URL opened successfully");
			WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
			EnterText(Uname, "gayatri@xo.com", "Username");
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			EnterText(pwd, "MyTestTool123", "Password");
			WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
			Click(loginBtn, "Login Button");
			Thread.sleep(3000);
			WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
			Click(plusIcon,"Plus Icon on home");
			Thread.sleep(3000);
			WebElement oppurtunityLink = driver.findElement(By.linkText("Opportunities"));
			Click(oppurtunityLink,"oppurtunity Link");
			WebElement oppurtunityHome = driver.findElement(By.className("pageType"));
			if(oppurtunityHome.isDisplayed())
			{
				System.out.println("Oppurtunity Home page is displayed");
			}
			else
			{
				System.out.println("Oppurtunity Home page is not displayed");
			}
		WebElement oppurtunityDropdown = (driver.findElement(By.name("fcf")));
			
			for(WebElement optny : oppurtunityDropdown.findElements(By.tagName("option")))
			{
				if(optny.isDisplayed())
					
				{
					System.out.println(optny.getText()+" is displayed");
					
				}
			}
			
	}
	public static void tC16() throws InterruptedException {
		logger = report.startTest("tC16");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		Thread.sleep(3000);
		WebElement oppurtunityLink = driver.findElement(By.linkText("Opportunities"));
		Click(oppurtunityLink,"oppurtunity Link");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		WebElement oppurtunityHome = driver.findElement(By.className("pageType"));
		if(oppurtunityHome.isDisplayed())
		{
			System.out.println("Oppurtunity Home page is displayed");
		}
		else
		{
			System.out.println("Oppurtunity Home page is not displayed");
		}
		
		WebElement newButton = driver.findElement(By.name("new"));
		Click(newButton,"New Button");
		
		WebElement oppurtunityName = driver.findElement(By.name("opp3"));
		String name = "Adam";
		EnterText(oppurtunityName,name, "OppurtunityName");
		WebElement accountName = driver.findElement(By.name("opp4"));
		EnterText(accountName, "gayatri", "AccountName");
		WebElement closeDate = driver.findElement(By.name("opp9"));
		EnterText(closeDate, "08/05/20", "closeDate");
		Select stage = new Select(driver.findElement(By.name("opp11")));
		stage.selectByValue("Prospecting");
		WebElement probability = driver.findElement(By.name("opp12"));
		probability.clear();
		EnterText(probability, "20", "Probability");
		Select leadSource = new Select(driver.findElement(By.name("opp6")));
		leadSource.selectByValue("Phone Inquiry");
		WebElement primaryCampSource = driver.findElement(By.name("opp17"));
		EnterText(primaryCampSource, "Adamsource", "Primary Campaign Source ");
		WebElement saveButton = driver.findElement(By.name("save"));
		Click(saveButton,"Save Button");
		WebElement displayName = driver.findElement(By.className("pageDescription"));
		if(displayName.getText().contains(name))
		{
			System.out.println("Name Verified");
		}
		else
		{
			System.out.println("name not verified");
		}
			
			}
	public static void tC17() throws InterruptedException {
		logger = report.startTest("tC17");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		Thread.sleep(3000);
		WebElement oppurtunityLink = driver.findElement(By.linkText("Opportunities"));
		Click(oppurtunityLink,"oppurtunity Link");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		WebElement oppurtunityHome = driver.findElement(By.className("pageType"));
		if(oppurtunityHome.isDisplayed())
		{
			System.out.println("Oppurtunity Home page is displayed");
		}
		else
		{
			System.out.println("Oppurtunity Home page is not displayed");
		}
		
		WebElement optnyPipeline = driver.findElement(By.linkText("Opportunity Pipeline"));
		Click(optnyPipeline,"Opportunity Pipeline link");
		//WebElement optnyPipelinePage = driver.findElement(By.className("noSecondHeader pageType"));
		
		String url ="Opportunity Pipeline ~ Salesforce - Developer Edition";
		if(driver.getTitle().equalsIgnoreCase(url))
		{
			System.out.println("Opportunity Pipeline link page verified");
		}
		else
		{
			System.out.println("Opportunity Pipeline link page not verified");
		}
	}
	public static void testStuckOpportunitiesReport() throws InterruptedException {
		logger = report.startTest("testStuckOpportunitiesReport");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		Thread.sleep(3000);
		WebElement oppurtunityLink = driver.findElement(By.linkText("Opportunities"));
		Click(oppurtunityLink,"oppurtunity Link");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		WebElement oppurtunityHome = driver.findElement(By.className("pageType"));
		if(oppurtunityHome.isDisplayed())
		{
			System.out.println("Oppurtunity Home page is displayed");
		}
		else
		{
			System.out.println("Oppurtunity Home page is not displayed");
		}
		WebElement stuckoptnyPipelineLink = driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		Click(stuckoptnyPipelineLink,"stuckoptnyPipelineLink");
		System.out.println("stuckoptnyPipelineLink is working");
		String stuckoptnyPipelinePage ="Stuck Opportunities";
		if((driver.getTitle()).contains(stuckoptnyPipelinePage))
		{
			System.out.println("Stuck Opportunities link page verified");
		}
		else
		{
			System.out.println("Stuck Opportunities link page not verified");
		}
	}
	public static void testQuarterlySummaryReport() throws InterruptedException {
		logger = report.startTest("testQuarterlySummaryReport");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		Thread.sleep(3000);
		WebElement oppurtunityLink = driver.findElement(By.linkText("Opportunities"));
		Click(oppurtunityLink,"oppurtunity Link");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		
         List<String> intervals = new LinkedList<>();
         intervals.add("current");
         intervals.add("next1");
		 List<String> reports = new LinkedList<>();
		reports.add("open");
		reports.add("closed");
		reports.add("closedwon");
		for(int j=0;j<=1;j++) {
			
				for(int i=1;i<4;i++)
			{
					Select interval = new Select(driver.findElement(By.id("quarter_q")));
					interval.selectByIndex(j);
				Select closedOppurtunities = new Select(driver.findElement(By.id("open")));
				closedOppurtunities.selectByIndex(i);
				List<WebElement> runButton = driver.findElements(By.name("go"));
				runButton.get(1).click();
			
		String optyTitle ="Opportunity Report ~ Salesforce - Developer Edition";
		if((driver.getTitle().contains(optyTitle)))
				{
			Select currentFQInNextPage = new Select(driver.findElement(By.id("quarter_q")));
			WebElement option = currentFQInNextPage.getFirstSelectedOption();
			String text = option.getAttribute("value");
			Select openNextPage = new Select(driver.findElement(By.id("open")));
			WebElement option2= openNextPage.getFirstSelectedOption();
			String text2= option2.getAttribute("value");
			if(text.contains(intervals.get(j))&& text2.contains(reports.get(i-1))) 
			{
				
				System.out.println(intervals.get(j)+" and "+reports.get(i-1)+" open loaded succesfully in the display page ");
						
			}
			else
			{
				System.out.println(intervals.get(j)+" and "+reports.get(i-1)+" not found");
			}
			driver.navigate().back();
				}
			}
				
		}
		}
	
	public static void tC20leadsTab() throws InterruptedException
	{
		logger = report.startTest("tC20leadsTab");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		Thread.sleep(3000);
		WebElement leeds = driver.findElement(By.linkText("Leads"));
		Click(leeds,"Leeds link");
		String expectedleedsTitle="Leads: Home ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(expectedleedsTitle))
		{
			System.out.println("Leeds homepage is verified");
		}
		else
		{
			System.out.println("Leeds homepage is not verified");
		}
		WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		Click(logOut,"Logout working");
		}
	public static void tC21leadsSelectView() throws InterruptedException
	{
		logger = report.startTest("tC21leadsSelectView");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		Thread.sleep(3000);
		WebElement leeds = driver.findElement(By.linkText("Leads"));
		Click(leeds,"Leeds link");
		String expectedleedsTitle="Leads: Home ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(expectedleedsTitle))
		{
			System.out.println("Leeds homepage is verified");
		}
		else
		{
			System.out.println("Leeds homepage is not verified");
		}
		WebElement viewDropdown = driver.findElement(By.name("fcf"));
		for(WebElement dropdownListItem: viewDropdown.findElements(By.tagName("option"))) {
			if(dropdownListItem.isDisplayed())
			{
				System.out.println(dropdownListItem.getText()+" is Displayed");
			}
			else
			{
				System.out.println(dropdownListItem.getText()+" is not Displayed");
			}
		}		
	}
	public static void tC22defaultView() throws InterruptedException
	{
		logger = report.startTest("tC22defaultView");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		Thread.sleep(3000);
		
		WebElement leeds = driver.findElement(By.linkText("Leads"));
		Click(leeds,"Leeds link");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		String expectedleedsTitle="Leads: Home ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(expectedleedsTitle))
		{
			System.out.println("Leeds homepage is verified");
		}
		else
		{
			System.out.println("Leeds homepage is not verified");
		}
		Select myUnreadLeeds =new Select(driver.findElement(By.id("fcf")));
		myUnreadLeeds.selectByValue("00B6g00000BEcLz");
		WebElement userInfoButton = driver.findElement(By.id("userNavLabel"));
		userInfoButton.click();
		WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		Click(logOut,"Logout working");
		Thread.sleep(3000);
		String loginTitlePage ="Login | Salesforce";
		if(driver.getTitle().contains(loginTitlePage))
		{
			System.out.println("Login page Verified");
		}
		else
		{
			System.out.println("Login page not Verified");
		}

		WebElement Uname1 = driver.findElement(By.id("username"));
		EnterText(Uname1, "gayatri@xo.com", "Username");
		WebElement pwd1 = driver.findElement(By.id("password"));
		EnterText(pwd1, "MyTestTool123", "Password");
		WebElement loginBtn1 = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn1, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon1 = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon1,"Plus Icon on home");
		Thread.sleep(3000);
		WebElement leeds1 = driver.findElement(By.linkText("Leads"));
		Click(leeds1,"Leeds link");
		/*
		 * WebElement lexNoThanks1 = driver.findElement(By.id("lexNoThanks"));
		 * Click(lexNoThanks1,"lexNoThanks"); List<WebElement> checkbox1 =
		 * driver.findElements(By.className("checkbox")); checkbox1.get(0).click();
		 * WebElement lexSubmit1 = driver.findElement(By.id("lexSubmit"));
		 * Click(lexSubmit1,"Feedback submit"); System.out.println("submit is working");
		 */
		String expectedleedsTitle1="Leads: Home ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(expectedleedsTitle1))
		{
			System.out.println("Leeds homepage is verified");
		}
		else
		{
			System.out.println("Leeds homepage is not verified");
		}
		List<WebElement> goButton = driver.findElements(By.name("go"));
		goButton.get(0).click();
		
			Select leedviewDisplay = new Select(driver.findElement(By.id("00B6g00000BEcLz_listSelect")));
			WebElement element = leedviewDisplay.getFirstSelectedOption();
			String elementValue =element.getAttribute("value");
			if(elementValue.contains("00B6g00000BEcLz"))
			{
				System.out.println("Today's Leed is displayed");
			}
			else
			{
				System.out.println("Today's Leed is not displayed");
			}
	}
	public static void tC23() throws InterruptedException
	{
		logger = report.startTest("tC23");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		Thread.sleep(3000);
		
		WebElement leeds = driver.findElement(By.linkText("Leads"));
		Click(leeds,"Leeds link");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		String expectedleedsTitle="Leads: Home ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(expectedleedsTitle))
		{
			System.out.println("Leeds homepage is verified");
		}
		else
		{
			System.out.println("Leeds homepage is not verified");
		}
		Select myUnreadLeeds =new Select(driver.findElement(By.id("fcf")));
		myUnreadLeeds.selectByValue("00B6g00000BEcLz");
		List<WebElement> goButton = driver.findElements(By.name("go"));
		goButton.get(0).click();
		Select leedviewDisplay = new Select(driver.findElement(By.id("00B6g00000BEcLz_listSelect")));
		WebElement element = leedviewDisplay.getFirstSelectedOption();
		String elementValue =element.getAttribute("value");
		if(elementValue.contains("00B6g00000BEcLz"))
		{
			System.out.println("Today's Leed is displayed");
		}
		else
		{
			System.out.println("Today's Leed is not displayed");
		}
	}
	public static void tC24() throws InterruptedException
	{
		logger = report.startTest("tC24");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		Thread.sleep(3000);
		
		WebElement leeds = driver.findElement(By.linkText("Leads"));
		Click(leeds,"Leeds link");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		String expectedleedsTitle="Leads: Home ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(expectedleedsTitle))
		{
			System.out.println("Leeds homepage is verified");
		}
		else
		{
			System.out.println("Leeds homepage is not verified");
		}
		WebElement newButton = driver.findElement(By.name("new"));
		Click(newButton,"New Button");
		WebElement lastName= driver.findElement(By.id("name_lastlea2"));
		String lname="abcd";
		EnterText(lastName,lname, "Lastname");
		WebElement companyName= driver.findElement(By.id("lea3"));
		EnterText(companyName, "abcd", "Company Name");
		WebElement save = driver.findElement(By.name("save"));
		Click(save,"Save Button");
		WebElement savedNamePage = driver.findElement(By.className("topName"));
		String nameVerify = savedNamePage.getText();
		if(nameVerify.contains(lname))
		{
			System.out.println("Name is displayed on saved page");
		}
		else
		{
			System.out.println("Name is not displayed on saved page");
		}
		
	}
	public static void createNewContactTC25() throws InterruptedException
	{
		logger = report.startTest("createNewContactTC25");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		String actualPage= driver.getCurrentUrl();
        System.out.println(actualPage);
		String expectedPage = "https://na174.salesforce.com/setup/forcecomHomepage.apexp?setupid=ForceCom";
		
	 if(actualPage.contentEquals(expectedPage)) {
		  System.out.println("Login page loaded successfully"); } else {
		  System.out.println("Login page not loaded"); }
		 
	 WebElement contactsTab = driver.findElement(By.linkText("Contacts"));
		Click(contactsTab, "ContactsTab");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		String contactsTitle ="Contacts: Home ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(contactsTitle))
		{
			System.out.println("Contacts Page is Displayed");
		}
		else
		{
			System.out.println("Contacts Page is not Displayed");
		}
		 WebElement newButton = driver.findElement(By.name("new"));
			Click(newButton, "New Button");
			String newButtonTittlePage="Contact Edit: New Contact ~ Salesforce - Developer Edition";
			if(driver.getTitle().contains(newButtonTittlePage))
			{
			 System.out.println("NewButton next page is displayed");
			}
			else
			{
				System.out.println("NewButton next page is not displayed");
			}
			WebElement lastname = driver.findElement(By.id("name_lastcon2"));
			EnterText(lastname, "lastname", "lastname");
			WebElement accountName = driver.findElement(By.id("con4"));
			EnterText(accountName, "gayatri", "accountName");
			 WebElement saveButton = driver.findElement(By.name("save"));
				Click(saveButton, "Save Button");
				WebElement topName = driver.findElement(By.linkText("lastname"));
				System.out.println(topName.getText());
				if(topName.getText().contains("lastname"))
				{
					System.out.println("Saved Page is Displayed");
				}
				else
				{
					System.out.println("Saved Page is not Displayed");
				}
				
	}
	public static void createNewViewTC26() throws InterruptedException
	{
		logger = report.startTest("createNewViewTC26");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		String actualPage= driver.getCurrentUrl();
        System.out.println(actualPage);
		String expectedPage = "https://na174.salesforce.com/setup/forcecomHomepage.apexp?setupid=ForceCom";
		
	 if(actualPage.contentEquals(expectedPage)) {
		  System.out.println("Login page loaded successfully"); } else {
		  System.out.println("Login page not loaded"); }
		 
	 WebElement contactsTab = driver.findElement(By.linkText("Contacts"));
		Click(contactsTab, "ContactsTab");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		String contactsTitle ="Contacts: Home ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(contactsTitle))
		{
			System.out.println("Contacts Page is Displayed");
		}
		else
		{
			System.out.println("Contacts Page is not Displayed");
		}
		WebElement createNewView = driver.findElement(By.linkText("Create New View"));
		Click(createNewView,"CreateNewView link");
		String createNewViewPageTitle = "Contacts: Create New View ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(createNewViewPageTitle))
		{
			System.out.println("NewView Page is Displayed");
		}
		else
		{
			System.out.println("NewView Page is Displayed");
		}
		WebElement viewName = driver.findElement(By.id("fname"));
		EnterText(viewName, "MyTest", "ViewName");
		WebElement viewUniqueName = driver.findElement(By.id("devname"));
		EnterText(viewUniqueName, "MyTest1", "ViewUnique Name");
		WebElement saveButton = driver.findElement(By.name("save"));
		Click(saveButton,"Save Button");
		WebElement selectedName = driver.findElement(By.name("fcf"));
		if(selectedName.getText().contains("MyTest"))
		{
			System.out.println("Contacts Home page is opened. Created View name is displayed in drop down in that page by defalut. ");
		}
		else
		{
			System.out.println("Contacts Home page is opened. Created View name is not displayed");
		}
	}
	public static void tC27() throws InterruptedException
	{
		logger = report.startTest("tC27");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		String actualPage= driver.getCurrentUrl();
        System.out.println(actualPage);
		String expectedPage = "https://na174.salesforce.com/setup/forcecomHomepage.apexp?setupid=ForceCom";
		
	 if(actualPage.contentEquals(expectedPage)) {
		  System.out.println("Login page loaded successfully"); } else {
		  System.out.println("Login page not loaded"); }
		 
	 WebElement contactsTab = driver.findElement(By.linkText("Contacts"));
		Click(contactsTab, "ContactsTab");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		String contactsTitle ="Contacts: Home ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(contactsTitle))
		{
			System.out.println("Contacts Page is Displayed");
		}
		else
		{
			System.out.println("Contacts Page is not Displayed");
		}
		Thread.sleep(3000);
		
		WebElement recentList = driver.findElement(By.xpath("//tr[contains(@class,'dataRow even first')]//a[contains(text(),'lastname')]"));
		String recentListText=recentList.getText();
		Click(recentList,"RecentLink");
		
		WebElement nameAppear = driver.findElement(By.className("topName"));
	
		if(nameAppear.getText().contains(recentListText))
		{
			System.out.println("Recently created contacts is displayed");
		}
		else
		{
			System.out.println("Recently created contacts is not displayed");
		}
	}
	public static void checkMyContactsViewTC28() throws InterruptedException {
		logger = report.startTest("checkMyContactsViewTC28");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		String actualPage= driver.getCurrentUrl();
        System.out.println(actualPage);
		String expectedPage = "https://na174.salesforce.com/setup/forcecomHomepage.apexp?setupid=ForceCom";
		
	 if(actualPage.contentEquals(expectedPage)) {
		  System.out.println("Login page loaded successfully"); } else {
		  System.out.println("Login page not loaded"); }
		 
	 WebElement contactsTab = driver.findElement(By.linkText("Contacts"));
		Click(contactsTab, "ContactsTab");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		String contactsTitle ="Contacts: Home ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(contactsTitle))
		{
			System.out.println("Contacts Page is Displayed");
		}
		else
		{
			System.out.println("Contacts Page is not Displayed");
		}
		Select myContacts = new Select(driver.findElement(By.name("fcf")));
		myContacts.selectByValue("00B6g00000BEcMg");
		WebElement goButton = driver.findElement(By.className("go"));
		Click(goButton,"Go Button");
		WebElement displayName = driver.findElement(By.id("00B6g00000BEcMg_listSelect"));
		if(displayName.getAttribute("value").contentEquals("00B6g00000BEcMg"))
				{
			System.out.println("My contacts view is displayed");
				}
		else
		{
			System.out.println("My contacts view is not displayed");
		}
	}
	public static void viewContactInContactPageTC29() throws InterruptedException
	{
		logger = report.startTest("viewContactInContactPageTC29");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		String actualPage= driver.getCurrentUrl();
        System.out.println(actualPage);
		String expectedPage = "https://na174.salesforce.com/setup/forcecomHomepage.apexp?setupid=ForceCom";
		
	 if(actualPage.contentEquals(expectedPage)) {
		  System.out.println("Login page loaded successfully"); } else {
		  System.out.println("Login page not loaded"); }
		 
	 WebElement contactsTab = driver.findElement(By.linkText("Contacts"));
		Click(contactsTab, "ContactsTab");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		String contactsTitle ="Contacts: Home ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(contactsTitle))
		{
			System.out.println("Contacts Page is Displayed");
		}
		else
		{
			System.out.println("Contacts Page is not Displayed");
		}
		WebElement recentList = driver.findElement(By.xpath("//tr[contains(@class,'dataRow even first')]//a[contains(text(),'lastname')]"));
		String recentListText=recentList.getText();
		Click(recentList,"RecentLink");
		
		WebElement nameAppear = driver.findElement(By.className("topName"));
	
		if(nameAppear.getText().contains(recentListText))
		{
			System.out.println("Contact page related to the name clicked is displayed");
		}
		else
		{
			System.out.println("Contact page related to the name clicked is not displayed");
		}
	}
	public static void tC30() throws InterruptedException
	{
		logger = report.startTest("tC30");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		String actualPage= driver.getCurrentUrl();
        System.out.println(actualPage);
		String expectedPage = "https://na174.salesforce.com/setup/forcecomHomepage.apexp?setupid=ForceCom";
		
	 if(actualPage.contentEquals(expectedPage)) {
		  System.out.println("Login page loaded successfully"); } else {
		  System.out.println("Login page not loaded"); }
		 
	 WebElement contactsTab = driver.findElement(By.linkText("Contacts"));
		Click(contactsTab, "ContactsTab");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		String contactsTitle ="Contacts: Home ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(contactsTitle))
		{
			System.out.println("Contacts Page is Displayed");
		}
		else
		{
			System.out.println("Contacts Page is not Displayed");
		}
		WebElement createNewView = driver.findElement(By.linkText("Create New View"));
		Click(createNewView,"create NewView");
		String createNewViewHomePage="Contacts: Create New View ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(createNewViewHomePage)){
			System.out.println("Contacts: Create New View Home page displayed");
		}
		else
		{
			System.out.println("Contacts: Create New View Home page not displayed");
		}
		WebElement viewUniqueName = driver.findElement(By.id("devname"));
		EnterText(viewUniqueName,"EFGH","viewUniqueName");
	WebElement saveButton = driver.findElement(By.name("save"));
	Click(saveButton,"save Button");
	List<WebElement> errorMessage=driver.findElements(By.className("errorMsg"));
	if(errorMessage.get(0).getText().contains("Error: You must enter a value"))
	{
		System.out.println("Error message displayed");
	}
	else
	{
		System.out.println("Error message not displayed");
	}

	}
	public static void cancelButtonInCreateNewViewTC31() throws InterruptedException
	{
		logger = report.startTest("cancelButtonInCreateNewViewTC31");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		String actualPage= driver.getCurrentUrl();
        System.out.println(actualPage);
		String expectedPage = "https://na174.salesforce.com/setup/forcecomHomepage.apexp?setupid=ForceCom";
		
	 if(actualPage.contentEquals(expectedPage)) {
		  System.out.println("Login page loaded successfully"); } else {
		  System.out.println("Login page not loaded"); }
		 
	 WebElement contactsTab = driver.findElement(By.linkText("Contacts"));
		Click(contactsTab, "ContactsTab");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		String contactsTitle ="Contacts: Home ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(contactsTitle))
		{
			System.out.println("Contacts Page is Displayed");
		}
		else
		{
			System.out.println("Contacts Page is not Displayed");
		}
		WebElement createNewView = driver.findElement(By.linkText("Create New View"));
		Click(createNewView,"create NewView");
		String createNewViewHomePage="Contacts: Create New View ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(createNewViewHomePage)){
			System.out.println("Contacts: Create New View Home page displayed");
		}
		else
		{
			System.out.println("Contacts: Create New View Home page not displayed");
		}
		WebElement viewName = driver.findElement(By.id("fname"));
		EnterText(viewName,"abcd","viewName");
		WebElement viewUniqueName = driver.findElement(By.id("devname"));
		EnterText(viewUniqueName,"EFGH","viewUniqueName");
	WebElement cancelButton = driver.findElement(By.name("cancel"));
	Click(cancelButton,"Cancel Button");
	if(driver.getTitle().contains(contactsTitle))
	{
		System.out.println("Contacts Page is Displayed and details not saved");
	}
	else
	{
		System.out.println("Contacts Page is not Displayed and still in details page");
	}
	}
	public static void checkSaveAndNewButtonTC32() throws InterruptedException
	{
		logger = report.startTest("checkMyContactsViewTC28");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(3000);
		String actualPage= driver.getCurrentUrl();
        System.out.println(actualPage);
		String expectedPage = "https://na174.salesforce.com/setup/forcecomHomepage.apexp?setupid=ForceCom";
		
	 if(actualPage.contentEquals(expectedPage)) {
		  System.out.println("Login page loaded successfully"); } else {
		  System.out.println("Login page not loaded"); }
		 
	 WebElement contactsTab = driver.findElement(By.linkText("Contacts"));
		Click(contactsTab, "ContactsTab");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		String contactsTitle ="Contacts: Home ~ Salesforce - Developer Edition";
		if(driver.getTitle().contains(contactsTitle))
		{
			System.out.println("Contacts Page is Displayed");
		}
		else
		{
			System.out.println("Contacts Page is not Displayed");
		}
		WebElement newButton = driver.findElement(By.name("new"));
		Click(newButton,"New Button");
		if(driver.getTitle().contains("Contact Edit: New Contact ~ Salesforce - Developer Edition"))
		{
			System.out.println("New contact page Displayed");
		}
		else
		{
			System.out.println("New contact page not Displayed");
		}
		WebElement lastname = driver.findElement(By.name("name_lastcon2"));
		EnterText(lastname, "Indian", "lastname");
		WebElement accountName = driver.findElement(By.name("con4"));
		EnterText(accountName, "Global Media", "accountName");
		WebElement saveAndnewButton = driver.findElement(By.name("save_new"));
		Click(saveAndnewButton,"Save&New Button");
	}
	public static void tC33() throws InterruptedException
	{
		logger = report.startTest("tC33");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		String loginTitle ="Login | Salesforce";
		if(driver.getTitle().equals(loginTitle))
		{
			System.out.println("Login page Displayed");
		}
		else
		{
			System.out.println("Login page not dispalyed");
		}
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(2000);
		WebElement homePageTab = driver.findElement(By.linkText("Home"));
		Click(homePageTab,"Home");
		String homePageExpectedTitle ="Salesforce - Developer Edition";
		if(driver.getTitle().equalsIgnoreCase(homePageExpectedTitle))
		{
			System.out.println("Homepage is Displayed");
		}
		else
		{
			System.out.println("Homepage is not Displayed");
		}
		WebElement userNameLink = driver.findElement(By.linkText("gayatri Balumuri"));
		//WebElement userNameMenu = driver.findElement(By.id("userNavLabel"));
		
		if(userNameLink.getAttribute("href")==null)
		{
	System.out.println("First and LastName link is not displayed ");
		}
else
{
	System.out.println("First and LastName link is  displayed");
}
		Click(userNameLink,"userNameLink on homepage");
		String profilePageTitle ="User: gayatri Balumuri ~ Salesforce - Developer Edition";
		if(driver.getTitle().equalsIgnoreCase(profilePageTitle))
		{
			System.out.println("The page is same as ProfilePage");
		}
		else
		{
			System.out.println("The page is not same as ProfilePage");
		}
	}
	public static void tC34() throws InterruptedException
	{
		logger = report.startTest("tC34");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		String loginTitle ="Login | Salesforce";
		if(driver.getTitle().equals(loginTitle))
		{
			System.out.println("Login page Displayed");
		}
		else
		{
			System.out.println("Login page not dispalyed");
		}
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(2000);
		
		WebElement homePageTab = driver.findElement(By.linkText("Home"));
		Click(homePageTab,"Home");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		String homePageExpectedTitle ="Salesforce - Developer Edition";
		if(driver.getTitle().equalsIgnoreCase(homePageExpectedTitle))
		{
			System.out.println("Homepage is Displayed");
		}
		else
		{
			System.out.println("Homepage is not Displayed");
		}
		//Thread.sleep(3000);
		WebElement userNameLink = driver.findElement(By.partialLinkText("gayatri"));
		//WebElement userNameMenu = driver.findElement(By.id("userNavLabel"));
		if(userNameLink.getAttribute("href")==null)
				{
			System.out.println("First and LastName link is not displayed ");
				}
		else
		{
			System.out.println("First and LastName link is  displayed");
		}
		Click(userNameLink,"userNameLink on homepage");
		String profilePageTitle ="User: gayatri Balumuri ~ Salesforce - Developer Edition";
		WebElement profileTab = driver.findElement(By.linkText("Profile"));
		Click(profileTab,"ProfileTab");
		if(driver.getTitle().equalsIgnoreCase(profilePageTitle))
		{
			System.out.println("The page is same as ProfilePage");
		}
		else
		{
			System.out.println("The page is not same as ProfilePage");
		}
		
List <WebElement> editIcon = driver.findElements(By.className("vfButtonBarButton"));
editIcon.get(0).click();
//driver.switchTo().frame("contactInfoContentId");

driver.switchTo().frame("contactInfoContentId");
WebElement contactTab = driver.findElement(By.id("contactTab"));
//driver.switchTo().defaultContent();
System.out.println(driver.getTitle());
WebElement about = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
Click(about, "About tab ");
WebElement firstName = driver.findElement(By.id("firstName"));
firstName.click();
WebElement lastName = driver.findElement(By.id("lastName"));
lastName.clear();
String name="ABCD";
EnterText(lastName, name, "Lastname");
WebElement save1 = driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
Click(save1, "save Button ");
		driver.switchTo().defaultContent();
		try {
		WebElement pageCloseVerify =driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		if(pageCloseVerify.isDisplayed())
		{
			System.out.println("Edit Page not closed");
		}
		else
		{
			System.out.println("Edit Page is closed");
		}

		}
		catch(Exception e)
		{
			System.out.println("Edit Page is closed in exception");
		}
		Thread.sleep(3000);
		 userNameLink = driver.findElement(By.partialLinkText("ABCD"));
		 if(userNameLink.getText().contains(name))
		 {
			 System.out.println("The updated LastName of the account holder is displayed at the top left hand side of the page.");
		 }
		 else
		 {
			 System.out.println("Not updated LastName of the account holder is displayed at the top left hand side of the page.");
		 }
		 WebElement userInfoButton = driver.findElement(By.id("userNavLabel"));
		 if(userInfoButton.getText().equalsIgnoreCase(userNameLink.getText()))
		 {
			 System.out.println("Verified that the 'User menu for FirstName LastName' menu button shows the updated Last Name, at the top right hand side of the page.");
			 
		 }
		 else
		 {
			 System.out.println("Not Verified that the 'User menu for FirstName LastName' menu button shows the updated Last Name, at the top right hand side of the page.");
		 }
		 WebElement profilePageName =driver.findElement(By.id("tailBreadcrumbNode"));
		 if(profilePageName.getText().contains(name))
		 {
			 System.out.println("The 'User:FirstName LastName' page has the updated LastName.");
		 }
		 else
		 {
			 System.out.println("The 'User:FirstName LastName' page has not updated the LastName.");
			 
		 }
	}
	public static void verifyTabCustomizationTC35() throws InterruptedException
	{
		logger = report.startTest("verifyTabCustomizationTC35");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		String loginTitle ="Login | Salesforce";
		if(driver.getTitle().equals(loginTitle))
		{
			System.out.println("Login page Displayed");
		}
		else
		{
			System.out.println("Login page not dispalyed");
		}
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(2000);
		WebElement plusIcon = driver.findElement(By.className("allTabsArrow"));
		Click(plusIcon,"Plus Icon on home");
		Thread.sleep(3000);
		WebElement accountLink = driver.findElement(By.className("relatedListIcon"));
		Click(accountLink,"Account Link");
		Thread.sleep(3000);
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		WebElement customeTab = driver.findElement(By.className("customize"));
		Click(customeTab,"CustomeTab");
		Select selectedTab = new Select(driver.findElement(By.id("duel_select_1")));
		selectedTab.selectByVisibleText("Groups");
		WebElement leftArrow = driver.findElement(By.className("leftArrowIcon"));
		Click(leftArrow,"leftArrow");
		WebElement saveButton = driver.findElement(By.className("btn primary"));
		Click(saveButton,"saveButton");
		String allTabPageTitle ="All Tabs ~ Salesforce - Developer Edition";
		if(driver.getTitle().equalsIgnoreCase(allTabPageTitle))
		{
			System.out.println("All Tab page is displayed");
		}
		WebElement tabBar = driver.findElement(By.id("tabBar"));
		try{
		if(tabBar.getAttribute("title").equals("Groups Tab"))
		{
			System.out.println("Group Tab is still present");
		}
		else
		{
			System.out.println("Group Tab is not present");
		}
		}
		catch(Exception e) {
			System.out.println("Group Tab is not present.This is from exception");
		}
		
		WebElement userInfoButton = driver.findElement(By.id("userNavLabel"));
		userInfoButton.click();
		WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		Click(logOut,"Logout working");
		Thread.sleep(3000);
		String loginTitlePage ="Login | Salesforce";
		if(driver.getTitle().contains(loginTitlePage))
		{
			System.out.println("Login page Verified");
		}
		else
		{
			System.out.println("Login page not Verified");
		}
		Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		 pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
 loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		tabBar = driver.findElement(By.id("tabBar"));
		try{
		if(tabBar.getAttribute("title").equals("Groups Tab"))
		{
			System.out.println("Group Tab is still present");
		}
		else
		{
			System.out.println("Group Tab is not present");
		}
		}
		catch(Exception e) {
			System.out.println("Group Tab is not present.This is from exception");
		}
		
	}
	public static void blockingAnEventInCalenderTC36() throws InterruptedException
	{
		logger = report.startTest("blockingAnEventInCalenderTC36");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(2000);
		WebElement homePageTab = driver.findElement(By.linkText("Home"));
		Click(homePageTab,"Home");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		String HomeTitle ="Salesforce - Developer Edition";
		if(driver.getTitle().equals(HomeTitle))
		{
			System.out.println("Home page Displayed");
		}
		else
		{
			System.out.println("Home page not dispalyed");
		}
		Thread.sleep(3000);
		WebElement dateSpan = driver.findElement(By.className("pageDescription"));
		WebElement dateLink = dateSpan.findElement(By.tagName("a"));
		if(dateLink.getAttribute("href")==null)
		{
			System.out.println("Date link is not present");
		}
		else
		{
			System.out.println("Date link is present");
		}
		Click(dateLink,"Data Link");
		WebElement pageType = driver.findElement(By.className("pageType"));
		//String calenderPage =pageType.getText();
		if(pageType.isDisplayed())
		{
			System.out.println("The 'Calendar for FirstName LastName' page is displayed.");
		}
		else
		{
			System.out.println("The 'Calendar for FirstName LastName' page is not displayed.");
		}
		WebElement timeLink = driver.findElement(By.linkText("8:00 AM"));
		Click(timeLink,"TimeLink");
		WebElement subject = driver.findElement(By.id("evt5"));
		if(subject.isEnabled())
		{
			System.out.println("cursor is at subject text area ");
		}else
		{
			System.out.println("cursor is not at subject text area ");
		}
		WebElement comboboxIcon = driver.findElement(By.className("comboboxIcon"));
		Click(comboboxIcon,"comboboxIcon");
		String currentWindow =driver.getWindowHandle();
		Set<String>  newWindows = driver.getWindowHandles();
		for(String s: newWindows)
		{
			if(!currentWindow.contentEquals(s))
			{
				driver.switchTo().window(s);
				break;
			}
		}
		WebElement other = driver.findElement(By.linkText("Other"));
		Click(other,"other Link");
		driver.switchTo().window(currentWindow);
		 subject = driver.findElement(By.id("evt5"));
	if(subject.isDisplayed())
		{
			System.out.println("cursor is at subject text area ");
		}else
		{
			System.out.println("cursor is not at subject text area ");
		}
	WebElement EndDateTime_time = driver.findElement(By.id("EndDateTime_time"));
	Click(EndDateTime_time,"EndDateTime_time");
	if(EndDateTime_time.isDisplayed())
	{
		System.out.println("EndDateTime is Displayed");
	}
	else
	{
		System.out.println("EndDateTime is not Displayed");
	}
	WebElement pickTime = driver.findElement(By.id("timePickerItem_18"));
	Click(pickTime,"pick Time 9:00");
	Thread.sleep(3000);
	WebElement saveButton = driver.findElement(By.name("save"));
	Click(saveButton,"saveButton");
	WebElement eventLink = driver.findElement(By.xpath("//div[@class='multiLineEventBlock dragContentPointer']//a"));
	if(eventLink.isDisplayed()&& eventLink.getAttribute("href")!=null )
	{
		System.out.println("other link is present and visible");
	}
	else
	{
		System.out.println("other link is not present and visible");
	}
	
	}
	public static void blockAnEventCalendarReccuranceTC37() throws InterruptedException
	{
		logger = report.startTest("blockingAnEventInCalenderTC36");
		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "gayatri@xo.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "MyTestTool123", "Password");
WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		Thread.sleep(2000);
		WebElement homePageTab = driver.findElement(By.linkText("Home"));
		Click(homePageTab,"Home");
		WebElement lexNoThanks = driver.findElement(By.id("lexNoThanks"));
		Click(lexNoThanks,"lexNoThanks");
		List<WebElement> checkbox = driver.findElements(By.className("checkbox"));
		checkbox.get(0).click();
		WebElement lexSubmit = driver.findElement(By.id("lexSubmit"));
		Click(lexSubmit,"Feedback submit");
		System.out.println("submit is working");
		String HomeTitle ="Salesforce - Developer Edition";
		if(driver.getTitle().equals(HomeTitle))
		{
			System.out.println("Home page Displayed");
		}
		else
		{
			System.out.println("Home page not dispalyed");
		}
		Thread.sleep(3000);
		WebElement dateSpan = driver.findElement(By.className("pageDescription"));
		WebElement dateLink = dateSpan.findElement(By.tagName("a"));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMMM dd, yyyy");
		if(dateLink.getAttribute("href")!=null && dateLink.getText().contentEquals(sdf.format(date)))
		{
			System.out.println("Date link  and date format is verified");
		}
		else
		{
			System.out.println("Date link  and date format is not verified");
		}
		Click(dateLink,"Data Link");
		WebElement pageType = driver.findElement(By.className("pageType"));
		//String calenderPage =pageType.getText();
				//sdf.format(date)
		if(pageType.isDisplayed())
		{
			System.out.println("The 'Calendar for FirstName LastName' page is displayed.");
		}
		else
		{
			System.out.println("The 'Calendar for FirstName LastName' page is not displayed.");
		}
		WebElement timeLink = driver.findElement(By.linkText("4:00 PM"));
		Click(timeLink,"TimeLink");
		WebElement subject = driver.findElement(By.id("evt5"));
		if(subject.isEnabled())
		{
			System.out.println("cursor is at subject text area ");
		}else
		{
			System.out.println("cursor is not at subject text area ");
		}
		WebElement comboboxIcon = driver.findElement(By.className("comboboxIcon"));
		Click(comboboxIcon,"comboboxIcon");
		String currentWindow =driver.getWindowHandle();
		Set<String>  newWindows = driver.getWindowHandles();
		for(String s: newWindows)
		{
			if(!currentWindow.contentEquals(s))
			{
				driver.switchTo().window(s);
				break;
			}
		}
		WebElement other = driver.findElement(By.linkText("Other"));
		Click(other,"other Link");
		driver.switchTo().window(currentWindow);
		 subject = driver.findElement(By.id("evt5"));
	if(subject.isDisplayed())
		{
			System.out.println("cursor is at subject text area ");
		}else
		{
			System.out.println("cursor is not at subject text area ");
		}
	WebElement EndDateTime_time = driver.findElement(By.id("EndDateTime_time"));
	Click(EndDateTime_time,"EndDateTime_time");
	if(EndDateTime_time.isDisplayed())
	{
		System.out.println("EndDateTime is Displayed");
	}
	else
	{
		System.out.println("EndDateTime is not Displayed");
	}
	WebElement pickTime = driver.findElement(By.id("timePickerItem_38"));
	Click(pickTime,"pick Time 7:00");
	WebElement recurrence = driver.findElement(By.id("IsRecurrence"));
	Click(recurrence,"recurrence");
	Thread.sleep(3000);
	if(recurrence.isSelected())
	{
		System.out.println("Recurrence check box is verified");
	}
	else
	{
		System.out.println("Recurrence check box is not verified");
	}
List<WebElement> recurrenceStartEnd = driver.findElements(By.className("labelCol"));
	if(recurrenceStartEnd.get(13).isDisplayed())
	{
		System.out.println("Frequency is Displayed");
	}
	else
	{
		System.out.println("Frequency is not Displayed");
	}
	if(recurrenceStartEnd.get(14).isDisplayed())
	{
		System.out.println("Recurrence Start is Displayed");
	}
	else
	{
		System.out.println("Recurrence Start is not Displayed");
	}
	if(recurrenceStartEnd.get(15).isDisplayed())
	{
		System.out.println("Recurrence End is Displayed");
	}
	else
	{
		System.out.println("Recurrence End is not Displayed");
	}
	WebElement weekly = driver.findElement(By.id("rectypeftw"));
	Click(weekly,"weekly RadioButton");
	WebElement recursByOne = driver.findElement(By.id("wi"));
	//System.out.println(recursByOne.getAttribute("value"));
	if(recursByOne.getAttribute("value").contentEquals("1"))
	{
		System.out.println("'Recurs Every..' section is displayed with '1' entered in it.");
	}
	else
	{
		System.out.println("'Recurs Every..' section is not displayed with '1' entered in it.");
	}
	List<WebElement> daylist= driver.findElements(By.xpath("//div[@id='w']//label"));
	//System.out.println("day.text"+daylist.get(1).getTagName().);
	//System.out.println(daylist);
	for(WebElement day: daylist)
	{ 
		sdf= new SimpleDateFormat("EEEE");
		String daySelected =sdf.format(date);
		//System.out.println("TagName "+day.getTagName()+" Text "+day.getText());
		if(day.getText().contentEquals(daySelected))
		{
           if(!day.isSelected())
           {
        	   System.out.println(daySelected+"is selected");
           }
           else
           {
        	   System.out.println(daySelected+"is not selected");
           }

		}
	}
		WebElement endDate = driver.findElement(By.id("EndDateTime"));
		Click(endDate,"EndDateTime");
		/*endDate.clear();
		EnterText(endDate, "02/28/2020", "EndDate");*/
	Calendar c= Calendar.getInstance();
	
				c.add(Calendar.DATE,8);
			Date endDate1 =c.getTime();
			sdf= new SimpleDateFormat("MMMM");
			String month = sdf.format(endDate1);
			Select monthSelect = new Select(driver.findElement(By.id("calMonthPicker")));
			monthSelect.selectByVisibleText(month);
			sdf= new SimpleDateFormat("d");
			String dateInCalender = sdf.format(endDate1);
		WebElement endDatecalendar = driver.findElement(By.id("datePickerCalendar"));
		List<WebElement> rows = endDatecalendar.findElements(By.id("calRow1"));
		List<WebElement> columns = endDatecalendar.findElements(By.xpath("//td[(text()="+dateInCalender+")]"));
		for(WebElement dateFocused :columns)
		{
			System.out.println("dateFocused.getText()"+dateFocused.getText());
			
			if(dateFocused.getText().equals(dateInCalender))
			{
				dateFocused.click();
				break;
			}


		}
		System.out.println("required is "+dateInCalender);
		WebElement saveButton = driver.findElement(By.name("save"));
		Click(saveButton,"saveButton");
		 pageType = driver.findElement(By.className("pageType"));
		//String calenderPage =pageType.getText();
				//sdf.format(date)
		if(pageType.isDisplayed())
		{
			System.out.println("The 'Calendar for FirstName LastName' page is displayed.");
		}
		else
		{
			System.out.println("The 'Calendar for FirstName LastName' page is not displayed.");
		}

/*List<WebElement> otherLink = driver.findElements(By.className("event_00U6g000001RXJB"));
if(otherLink.get(0).getAttribute("href")==null)
{
	System.out.println("Other Link is not present");
}
else
{
	System.out.println("Other link is present");
}*/
WebElement monthViewIcon = driver.findElement(By.xpath("//img[@class='monthViewIcon']"));
Click(monthViewIcon,"monthViewIcon");
String monthviewCalenderPage = "Calendar for gayatri ABCD - Month View ~ Salesforce - Developer Edition";
if(driver.getTitle().contains(monthviewCalenderPage))
{
	System.out.println("Monthview  calendar page is displayed");
}
else
{
	System.out.println("Monthview  calendar page is not displayed");
}
sdf= new SimpleDateFormat("d");
String startDateInMonthlyCalendar = sdf.format(date);
WebElement column = driver.findElement(By.xpath("//a[(text()="+startDateInMonthlyCalendar+")]"));
System.out.println(columns);
int a =Integer.parseInt(startDateInMonthlyCalendar)+1;
for(int i=a;i<(a+7);i++)
	{
	column = driver.findElement(By.xpath("//a[(text()="+i+")]"));
	if(column.getText().contains("Other"))
	{
		System.out.println("OtherLink is present in "+i);
	}
	else
	{
		System.out.println("OtherLink is not present in "+i);
	}
	}
	}
}

