package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//declaration
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement createConLookUpImg;
		
		//initialization
		public ContactsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			}
		
		//utilization

		public WebElement getCreateConLookUpImg() {
			return createConLookUpImg;
		}
		
		//business library
		
		//click on createcon
		public void clickOnCreateCog() {
			createConLookUpImg.click();
		
		}
		

}
