package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	@FindBy(id="dtlview_Industry")
	private WebElement indusVeryfy;
	
	@FindBy(id="dtlview_Type")
	private WebElement typeVerify;
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	
	}
	
	public WebElement getIndusVeryfy() {
		return indusVeryfy;
	}

	public WebElement getTypeVerify() {
		return typeVerify;
	}

	//business
	public String getOrgInfo() {
		return(orgHeaderText.getText());
	}
	
	public String getIndusInfo() {
		return(indusVeryfy.getText());
	}
	
	public String getTypInfo() {
		return(typeVerify.getText());
	}

}
