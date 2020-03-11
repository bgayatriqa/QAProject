package javaTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTesting {
	WebDriver driver;
	ExtentTest logger;
	ExtentReports report;
@BeforeClass
public void startUpDriver()
 {
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
 }
@BeforeTest
	public  void createReport()
	{
		
		
		String fileName = new SimpleDateFormat("'SFDCLoginReport_'YYYYMMddHHmm'.html'").format(new Date());
		String path = "C:\\Users\\vamsi\\Desktop\\Git_projects\\QAProject\\javaTest\\src\\LoginReports\\" + fileName;
		report = new ExtentReports(path);
		
	}
@AfterClass
public void closeDriver()
{
	driver.quit();
	
}
@AfterTest
public void closeReport()
{
	report.flush();
}
	public  void clickElement(WebElement element, String objName)
	{
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Element is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Element is found");
			element.click();
		}
	}
	public  void enterText(WebElement element, String text, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Textbox is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Textbox is found");
			element.sendKeys(text);
		}
	}

	//@Test(dataProvider = "PassData")
	@Test(dataProvider ="ReadfromExcel")
 public void loginForm(String username,String password) throws Exception
 {
		logger=report.startTest("loginForm");
		driver.get("https://qa01-tekarch-accmanager.web.app/");

		Thread.sleep(2000);
		System.out.println("login page is displaying "+driver.getCurrentUrl());
		List<WebElement> tagname = driver.findElements(By.tagName("input"));
	enterText(tagname.get(0),username,username);
	enterText(tagname.get(1),password,password);
		WebElement login = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		clickElement(login,"loginButton");
		Thread.sleep(2000);
		String homeTitle ="https://qa01-tekarch-accmanager.web.app/dashboard";
		AssertJUnit.assertTrue(driver.getCurrentUrl().contentEquals(homeTitle));
		{
			logger.log(LogStatus.PASS, "Homepage launched succesfully");
		}
		
 }
	//@DataProvider(name = "PassData")
	public static String[][] loginFormData()
	{
		String[][]  data = {{"mithun@ta.com","mithun"},{"gayathri@ta.com","gayathri"},{"gayatri","123"}};
		
		return  data;
	}
	@DataProvider(name="ReadfromExcel")
public static String[][] readExcelFile() throws FileNotFoundException, IOException
{
	String file="C:\\Users\\vamsi\\Documents\\Exceldocs\\loginData.xls";
	HSSFWorkbook hsf = new HSSFWorkbook(new FileInputStream(file));
	HSSFSheet sheet = hsf.getSheet("Sheet1");
	 HSSFRow row = sheet.getRow(0);
	 int RowNum = sheet.getPhysicalNumberOfRows();// count my number of Rows
     int ColNum= row.getLastCellNum(); // get last ColNum 
     String data[][]= new String[RowNum-1][ColNum]; // pass my  count data in array
     
     for(int i=0; i<RowNum-1; i++) //Loop work for Rows
     {  
          row= sheet.getRow(i+1);
          
         for (int j=0; j<ColNum; j++) //Loop work for colNum
         {
             if(row==null)
                 data[i][j]= "";
             else
             {
                 HSSFCell cell= row.getCell(j);
                 if(cell==null)
                     data[i][j]= ""; //if it get Null value it pass no data 
                 else
                 {
                  DataFormatter formatter = new  DataFormatter()  ;
					String value=formatter.formatCellValue(cell);
                     data[i][j]=value;
                 }

             }
         }
     }
     return data;
              
}
	}


