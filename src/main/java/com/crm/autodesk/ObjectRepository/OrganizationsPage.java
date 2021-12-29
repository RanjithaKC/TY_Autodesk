package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility{ //class name
	
	//declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;
	
	@FindBy(id="bas_searchfield")
	private WebElement dropdownBtn;
	
	//initialization
	public OrganizationsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	public WebElement getDropdownBtn() {
		return dropdownBtn;
	}
	
	//business Libraries
	
	//click on createorg+
	public void clickOnCreateOrg() {
		createOrgLookUpImg.click();
	}
	
	//click on search
	public void clickOnSearchText() {
		searchTextEdt.click();
	}
	
	//click on searchtext
	public void searchwithOrg(String orgname) {
		 searchTextEdt.sendKeys(orgname);
	}
	
	//click on Search
	public void clickOnSearchNow() {
		searchNowBtn.click();
	}
	//dropdown
	public void clickOnDropDown() {
		dropdownBtn.click();
	}
	public void searchOrgName(String orgName) {
		dropdownBtn.sendKeys(orgName);
		
	
	}
	
	
	
	
			
	}
	
	
