package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
	
	//declaration
	@FindBy(name="lastname")
	private WebElement conLastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement createOrgLookUpinCon;
	
	@FindBy(id="search_txt")
	private WebElement searchTxtinChild;
	
	@FindBy (name="search")
	private WebElement searchBtninChild;

	//initialization
	
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization

	public WebElement getConLastNameEdt() {
		return conLastNameEdt;
	}

	public WebElement getCreateOrgLookUpinCon() {
		return createOrgLookUpinCon;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	public WebElement getSearchTxtinChild() {
		return searchTxtinChild;
	}

	public WebElement getSearchBtninChild() {
		return searchBtninChild;
	}
	
	//business

	public void createCon(String LastName) {
		conLastNameEdt.sendKeys(LastName);
		saveBtn.click();
	}
	
	
	public void createConwithOrg(WebDriver driver,String lastname, String orgname) {
		conLastNameEdt.sendKeys(lastname);	
		createOrgLookUpinCon.click();
		switchToWindow( driver,"Accounts");
		searchTxtinChild.sendKeys(orgname);
		searchBtninChild.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		switchToWindow( driver,"contacts");
		saveBtn.click();
		
		
	}

}
