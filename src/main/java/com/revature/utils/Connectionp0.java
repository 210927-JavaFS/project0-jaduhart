package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionp0{
	public static Connection getConnection() throws SQLException{
	
	//mant 
	try {
		Class.forName("org.postgresql.Driver");
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	String url = "jdbc:postgresql://javafs-210927.ccbckc6vn84n.us-east-1.rds.amazonaws.com:5432/postgres";
	String username = "postgres"; //possibe to use env variable to hide this stuff
	String password = "Jjdd6246!";//System.getenv("var-name")
	
	return DriverManager.getConnection(url, username, password);
	}
}
