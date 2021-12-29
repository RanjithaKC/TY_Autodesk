package com.crm.Autodesk.ContactTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.ObjectRepository.ContactsInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
/**
 * 
 * @author Ranjitha
 *
 */
public class CreateContactwithOrgTest extends BaseClass {
	@Test(groups="RegressionSuit")
	public void  createContactwithOrgTest() throws Throwable{
		
		//get random num
		int ranDomNum=jLib.getRanDomNumber();
		
		//read data from excel file
		String orgname=eLib.getDataFromExcel("Sheet1",1,2)+ ranDomNum;
		String lastname2=eLib.getDataFromExcel("Sheet2",2,2)+ ranDomNum;
		
		//navigate to org
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		//click on org
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrg();
		
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrg(orgname);
		
		
		
		//wait for element
		WebElement headerWb = driver.findElement(By.className("dvHeaderText"));
		wLib.waitForElementToBeClickAble(driver,headerWb );
		
		//navigate to contact
		hp.clickOnContactsLink();
		
		
		//create contact
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateCog();		
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createConwithOrg(driver, lastname2, orgname);
		
		//verification
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		 String res = cip.getConInfo();
			//if(res.contains(lastname2))
		//	{
			//	System.out.println(res+" added successfully");
			//}else {
				//System.out.println("fail");
			//}
		
		//SoftAssert sa=new SoftAssert();
		//sa.assertTrue(res.equals(lastname2));
		//sa.assertAll();
		
		 Assert.assertTrue(res.contains(lastname2));
         System.out.println("contact created with org successfully");
	}
	}
	

	