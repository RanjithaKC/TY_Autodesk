package com.crm.Autodesk.ContactTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactsInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.genericutility.BaseClass;

public class CreateContactTest extends BaseClass {
	
	@Test(groups="smokeSuit")
	
	public void createContactTest() throws Throwable
	{
		//getRandom num
		int ranDomNum=jLib.getRanDomNumber();
		
		//read data from excel file
		String lastname=eLib.getDataFromExcel("Sheet2",1,2)+ ranDomNum;
		
		//navigate to con module
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		
		//click on create con button
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateCog();
		
		//enter all deatails
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createCon(lastname);
		
		//verification
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		   String Actmsg = cip.getConInfo();

         Assert.assertTrue(Actmsg.contains(lastname));
         System.out.println("contact created successfully");
		 
		
	}
		
		
		
	}
	

	
