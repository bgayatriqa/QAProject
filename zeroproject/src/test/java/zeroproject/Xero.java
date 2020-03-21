package zeroproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class Xero extends ReusableCode{
	@Test
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
		//firstName
		WebElement firstName = driver.findElement(By.name("FirstName"));
		enterText(firstName,"lucky","firstName");
		softAssert.assertEquals(true,firstName.getText().equals("lucky"));
		WebElement lastName = driver.findElement(By.name("LastName"));
		enterText(lastName,"star","lastName");
		softAssert.assertEquals(true,lastName.getText().equals("star"));
		WebElement email = driver.findElement(By.name("EmailAddress"));
		enterText(email,"luckytomstar1@gmail.com","EmailAddress");
		softAssert.assertEquals(true,email.getText().equals("luckytomstar1@gmail.com"));
		WebElement PhoneNumber = driver.findElement(By.name("PhoneNumber"));
		enterText(PhoneNumber,"9456812345","PhoneNumber");
		softAssert.assertEquals(true,PhoneNumber.getText().equals("9456812345"));
		Select locationCode = new Select(driver.findElement(By.name("LocationCode")));
		locationCode.selectByVisibleText("United States");
		softAssert.assertEquals(true,locationCode.getFirstSelectedOption().getText().equals("United States"));
		WebElement captchaCheck = driver.findElement(By.className("recaptcha-checkbox-border"));
		click(captchaCheck,"captchaCheck");
			WebElement acceptCheck = driver.findElement(By.name("TermsAccepted"));
		click(acceptCheck,"acceptCheck");
		softAssert.assertEquals(true,acceptCheck.isSelected());
		WebElement submitButton = driver.findElement(By.className("btn btn-primary"));
		click(submitButton,"submitButton");
		softAssert.assertAll();
		
	}




}
