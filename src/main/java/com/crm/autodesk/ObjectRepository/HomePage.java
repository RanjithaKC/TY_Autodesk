package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility { //step 1 create class
	
	//step 2 : declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	//step3 : initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step4 utilization

	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}

	public WebElement getContactsLnk() {
		System.out.println(contactsLnk);
		return contactsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	//business library to click on organizations
	public void clickOnOrganizationsLink()
	{
		organizationsLnk.click();
	}
	
	//business library to click on contacts
	public void clickOnContactsLink()
	{
		contactsLnk.click();
	}
	
	//business library for logout
	public void logout(WebDriver driver)
	{
		mouseOverOnElemnet(driver,administratorImg);
		signOutLnk.click();
	}
}
