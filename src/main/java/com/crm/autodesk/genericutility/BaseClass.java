package com.crm.autodesk.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;

public class BaseClass {
    public DataBaseUtility dLib = new DataBaseUtility();
    public FileUtility fLib = new FileUtility();
    public WebDriverUtility wLib = new WebDriverUtility();
    public JavaUtility jLib = new JavaUtility();
    public ExcelUtility eLib = new ExcelUtility();
    public WebDriver driver;
    public static WebDriver sdriver;

    @BeforeSuite (groups= {"smokeSuit","RegressionSuit"})
    public void dbConnection() 
    {
        dLib.connectToDB();
        System.out.println("======Database connection successfulass=");
    }

    @BeforeClass(groups= {"smokeSuit","RegressionSuit"})
    public void launchBrowser() throws Throwable
    {
        //read the data
        String BROWSER = fLib.getPropertyKeyValue("browser");
        String URL = fLib.getPropertyKeyValue("url");
        if(BROWSER.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if(BROWSER.equalsIgnoreCase("FireFox"))
        {
            driver = new FirefoxDriver();
        }
        else
        {
            System.out.println("invalid Browser");
        }
        
        sdriver=driver;
        
        wLib.waitForPageToLoad(driver);
        wLib.maximizeWindow(driver);
        driver.get(URL);
        System.out.println("======Browser launched=====");
    }
  
    @BeforeMethod(groups= {"smokeSuit","RegressionSuit"})
    public void loginToApp() throws Throwable
    {
        //read the data
        String USERNAME = fLib.getPropertyKeyValue("username");
        String PASSWORD = fLib.getPropertyKeyValue("password");
        LoginPage lp = new LoginPage(driver);
        lp.login(USERNAME, PASSWORD);
        System.out.println("======Login Successfull=====");
    }
    
    @AfterMethod(groups= {"smokeSuit","RegressionSuit"})
    public void logoutOfApp()
    {
        HomePage hp = new HomePage(driver);
        hp.logout(driver);
        System.out.println("======logout successful=====");
    }
    @AfterClass(groups= {"smokeSuit","RegressionSuit"})
    public void closeBrowser()
    {
        driver.quit();
        System.out.println("======browser closed=====");
    }
    @AfterSuite(groups= {"smokeSuit","RegressionSuit"})
    public void closeDbConnection() 
    {
        dLib.closeDB();
        System.out.println("======Database connection closed=====");
    }

}