package com.rmgyantra.testscript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class Scripttoaddprojectselenium {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8084/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement user = driver.findElement(By.id("usernmae"));
		user.sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		//driver.switchTo().frame(0);
		
		driver.findElement(By.name("projectName")).sendKeys("infosys");
		driver.findElement(By.name("createdBy")).sendKeys("ranju");
		
		WebElement ele = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
		Select s=new Select(ele);
		s.selectByIndex(3);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.close();
		
		String expectedproject="infosys";
		 Connection connection = null;
		try {
		
		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery("select * from project");
		while(result.next()) 
		
		if(result.getString(4).equals(expectedproject)) {
			System.out.println("project present");
			
		}
		}
		//else {
			//System.out.println("project not present");
	
		finally {
		connection.close();
	}
}
}

