package com.nissan.training.advancedjava.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nissan.training.advancedjava.beans.RegistrationBean;
import com.nissan.training.advancedjava.database.DBConnection;

public class LoginServices {

	public String loginUser(RegistrationBean registerBean) {

		String email = registerBean.getEmail();
		
		String password = registerBean.getPassword();

		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			con = DBConnection.createConnection();
			String query = "select * from user where email=? and pass=?"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			
			ResultSet rs = preparedStatement.executeQuery();
			int i=0;
			if (rs.next()) {
				i++;
			}
			if(i==1)
				return "SUCCESS"; 
			else
				return "Incorrect Credentials";
		}
		catch(SQLException e)
		{
			//	e.printStackTrace();
			 System.out.println("error happend " + e.getMessage());
		}

		
		return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
		}
	}


