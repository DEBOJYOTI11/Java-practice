package com.nissan.training.advancedjava.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DBConnection {
		public static Connection createConnection()
		{
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/jsp?autoReconnect=true&useSSL=false"; //MySQL URL followed by the database name
		String username = "root"; //MySQL username
		String password = "root"; //MySQL password
		 try {
		        DriverManager.registerDriver(new Driver());
		         return DriverManager.getConnection(url, username, password);
		      } catch (SQLException ex) {
		          throw new RuntimeException("Error connecting to the database", ex);
		      }
		}
}
