package com.crm.Autodesk.OrgTest;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class SearchOrganizationbyOrgname {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		/* create object to libraries*/
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		//read data from property file
		
		//FileInputStream fis=new FileInputStream("./data/commondata.properties");
		//Properties p=new Properties();
		//p.load(fis);
		//String URL = p.getProperty("url");
		//String name = p.getProperty("username");
		//String pass = p.getProperty("password");
		//String BROWSER = p.getProperty("brow");
		//String phno = p.getProperty("phoneno");
		
		String URL=fLib.getPropertyKeyValue("url");
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");
		String BROWSER=fLib.getPropertyKeyValue("browser");
		//String phno=fLib.getPropertyKeyValue("phoneno");
		
		//random
		//Random ran=new Random();
		//int rannum = ran.nextInt(5000);
		
		int randomnum=jLib.getRanDomNumber();
		
		//read data from excel sheet
		
		//FileInputStream fis1=new FileInputStream("./data/Book1.xlsx");
		//Workbook wb = WorkbookFactory.create(fis1);
		//Sheet sh3 = wb.getSheet("Sheet3");
		//Row row = sh3.getRow(1);
		//String orgname = row.getCell(1).getStringCellValue()+rannum;
		// String mobileno = row.getCell(3).getStringCellValue();
		
		//String searchorg = row.getCell(4).getStringCellValue();
		
		 String orgname = eLib.getDataFromExcel("Sheet3", 1, 1)+randomnum;
		 System.out.println(orgname);
		// String mobileno = eLib.getDataFromExcel("Sheet3", 1, 3);
		  String searchorg = eLib.getDataFromExcel("Sheet3", 1, 4);
		  System.out.println(searchorg);
		 
		//browser
		WebDriver driver;
		//System.out.println("XYZ"+BROWSER);
		if(BROWSER.equals("chrome")) {
			
			driver=new ChromeDriver();
		}else {
			driver=new FirefoxDriver();
		}
		
		/* implicit*/
		wLib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(URL);
		
		//login
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(name);
		//driver.findElement(By.name("user_password")).sendKeys(pass);
		//driver.findElement(By.id("submitButton")).click();
		
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		
		//navigate to organization module
		//driver.findElement(By.linkText("Organizations")).click();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//driver.findElement(By.name("accountname")).sendKeys(orgname);
		//String mobilenoStr=String.valueOf(mobileno);  
		//driver.findElement(By.id("phone")).sendKeys(phno);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrg();
		
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrg(orgname);
		
		//explicit wait till element is active
				//WebDriverWait wait=new WebDriverWait(driver,20);
				//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));
		
		WebElement headerWb = driver.findElement(By.className("dvHeaderText"));
		wLib.waitForElementToBeClickAble(driver,headerWb );
		
		//Thread.sleep(10000);
		
		HomePage hp1=new HomePage(driver);
		hp1.clickOnOrganizationsLink();
		
		
		//for searching
		//driver.findElement(By.linkText("Organizations")).click();
		//Thread.sleep(10000);
		
		
		
		//OrganizationsPage op1=new OrganizationsPage(driver);
	   // op1.clickOnCreateOrg();
	 // System.out.println(op1);
	    
	    OrganizationsPage op2=new OrganizationsPage(driver);
	    op2.searchwithOrg(orgname);
		
		
		//driver.findElement(By.name("search_text")).sendKeys(orgname);
		
		//dropdown
		//WebElement drop = driver.findElement(By.id("bas_searchfield"));
			
		//Select s=new Select(drop);
		//System.out.println("xyz"+searchorg);
		//s.selectByVisibleText(searchorg);
		//wLib.select(drop, searchorg);
		
		OrganizationsPage op3=new OrganizationsPage(driver);
		op3.clickOnDropDown();
		op3.searchOrgName(searchorg);
		System.out.println(searchorg+ "in Dropdown");
		
		
		
		
		//search
		//driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		OrganizationsPage op4=new OrganizationsPage(driver);
		op4.clickOnSearchNow();
		
		
		//verification
		// String res = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		// System.out.println("xyz"+res);
		// System.out.println("abc"+orgname);
		// if(res.equals(orgname)) {
			// System.out.println("searched for organization name");
		// }else {
			// System.out.println("fail");
		// }
		
		//logout
		// Actions a = new Actions(driver);
			//a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		//wLib.mouseOverOnElemnet(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
			//driver.findElement(By.linkText("Sign Out")).click();
			//driver.quit();
		
		hp.logout(driver);
		driver.quit();
		
		
	
	}

}
