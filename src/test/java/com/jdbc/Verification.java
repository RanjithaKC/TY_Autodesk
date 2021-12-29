package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Verification {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String expecteddata="india";
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from studentsinfo");
		while(result.next())
		if (result.getString(4).equals(expecteddata)) {
			System.out.println("passed");
		}
		else {
			System.out.println("fail");
		}
		connection.close();

	}

}
