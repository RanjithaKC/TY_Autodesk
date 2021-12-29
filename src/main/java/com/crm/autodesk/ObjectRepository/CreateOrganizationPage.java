package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	
@FindBy(name="accountname")
private WebElement organizationNameEdt;

@FindBy(name="industry")
private WebElement industryDropDown;

@FindBy(name="accounttype")
private WebElement typeDropDown;

@FindBy(name="phone")
private WebElement phoneEdt;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

//initialize

public CreateOrganizationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

//utilize

public WebElement getOrganizationNameEdt() {
	return organizationNameEdt;
}

public WebElement getIndustryDropDown() {
	return industryDropDown;
}

public WebElement getTypeDropDown() {
	return typeDropDown;
}

public WebElement getSaveBtn() {
	return saveBtn;
}



public WebElement getPhoneEdt() {
	return phoneEdt;
}

//business library
//to create organization and save


public void createOrg(String orgName) {
	organizationNameEdt.sendKeys(orgName);
	saveBtn.click();
}

//to create org with industry and type dropdown then save
public void createOrgWithIndustry(String orgName, String industryType, String Type) {
	organizationNameEdt.sendKeys(orgName);
	select(industryDropDown, industryType);
	select(typeDropDown, Type);
	saveBtn.click();
}
}
