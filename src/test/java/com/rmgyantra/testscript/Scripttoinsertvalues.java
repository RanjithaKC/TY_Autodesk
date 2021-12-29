package com.rmgyantra.testscript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Scripttoinsertvalues {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//register
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//establish
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
		//issue statement
		Statement statement = connection.createStatement();
		
		//execute
		int result = statement.executeUpdate("insert into project(project_id,created_by,created_on,project_name,status,team_size) value('TY_PROJ_007','Priya','16/12/2021','bluebell','created','1')");
		if(result==1) {
			System.out.println("Project Created");
		}
		//else {
			//System.out.println("Project not created");	
		
		
		
		String expectedproject="bluebell";
		ResultSet result1 = statement.executeQuery("select* from project");
		while(result1.next())
			if(result1.getString(4).equals(expectedproject)) {
				System.out.println("project added");
			}
		
		connection.close();

	}

}
