package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Insertdataintodatabase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate("insert into studentsinfo (id,fname, lname, address) value('4','ranjitha','kc','india')");
		if(result==1) {
			System.out.println("data added to database");
		}
		else {
			System.out.println("data not added to database");
		}
		connection.close();
		
	}

}
