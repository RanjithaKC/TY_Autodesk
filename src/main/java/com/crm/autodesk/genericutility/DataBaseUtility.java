package com.crm.autodesk.genericutility;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	//public Connection connection;
	//public void connectToDB() throws SQLException {
		//Driver driver = new Driver();
		//DriverManager.registerDriver(driver);
		
		//establish the connection
	 // connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root","root");
	//}
		
		//close connection
		//public void closeDB() throws SQLException {
		//connection.close();
		//}

	public void connectToDB() {
		System.out.println("data base connected");
	}
	public void closeDB()
	{
		System.out.println("database closed");
	}
	
}
