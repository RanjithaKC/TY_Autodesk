package com.crm.Autodesk.OrgTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.BaseClass;

public class CreateOrgTest extends BaseClass {
	
	@Test
	
	public void createOrgTest() throws Throwable
	{
	
	//getRandom num
	int ranDomNum=jLib.getRanDomNumber();
	
	//read data from excel file
	String orgname=eLib.getDataFromExcel("Sheet1",2,2)+ ranDomNum;
	
	//navigate to org module
	HomePage hp=new HomePage(driver);
	hp.clickOnOrganizationsLink();
	
	//create org button
	OrganizationsPage op=new OrganizationsPage(driver);
	op.clickOnCreateOrg();
	
	//enter all details and create org
	CreateOrganizationPage cop=new CreateOrganizationPage(driver);
	cop.createOrg(orgname);
	
	//verify orgname in header
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String ActMsg = oip.getOrgInfo();
	
	 Assert.assertTrue(ActMsg.contains(orgname));
     System.out.println("contact created successfully");
	}

//@Test
//public void rrdemo() {
	//System.out.println("reginal regression testing");
//}
}

	
	
	
	

	