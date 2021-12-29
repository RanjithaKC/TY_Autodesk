package com.crm.Autodesk.OrgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
@Listeners(com.crm.autodesk.genericutility.ListnerImplimentation.class)
public class CreateOrgwithIndustryandTypeScript extends BaseClass{
	
	@Test(groups="smokeSuit")
	public void createOrgwithIndustryandTypeScriptTest() throws Throwable{
		
		//get random num
				int ranDomNum=jLib.getRanDomNumber();
				
				//read data from excel file
				String orgname=eLib.getDataFromExcel("Sheet1",1,2)+ ranDomNum;
				String industries=eLib.getDataFromExcel("Sheet1",1,3);
				String type=eLib.getDataFromExcel("Sheet1",1,4);
		
				//org module
				HomePage hp=new HomePage(driver);
				hp.clickOnOrganizationsLink();
				
				// create org button
				OrganizationsPage op=new OrganizationsPage(driver);
				op.clickOnCreateOrg();
				
				//details
				CreateOrganizationPage cop=new CreateOrganizationPage(driver);
				cop.createOrgWithIndustry(orgname, industries, type);
				
				//verify
				//OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				//String Actmsg = oip.getIndusInfo();
				
				//if(Actmsg.contains(industries))
				//{
					//System.out.println(Actmsg+" added successfully");
				//}else {
				//	System.out.println("fail");
				//}
				
				//String Actmsg1 = oip.getTypInfo();
				//if(Actmsg1.contains(type))
				//{
					//System.out.println(Actmsg1+" added successfully");
				//}else {
					//System.out.println("fail");
				//}
				
				OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				String Actmsg = oip.getIndusInfo();
				
				SoftAssert sa=new SoftAssert();
				sa.assertTrue(Actmsg.equals(industries));
				
				String actType=oip.getTypInfo();
				
				
				Assert.assertTrue(actType.equals(type));
				
				sa.assertAll();
	}	
				
	}
	
	
	
	

	
