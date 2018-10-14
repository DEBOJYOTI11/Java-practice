package com.nissan.training.advancedjava.services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nissan.training.advancedjava.beans.RegistrationBean;
import com.nissan.training.advancedjava.database.DBConnection;



public class RegistrationServices {
	public String registerUser(RegistrationBean registerBean)
	{
	String fullName = registerBean.getFullName();
	String email = registerBean.getEmail();
	
	String password = registerBean.getPassword();
	String phoneNumber  = registerBean.getPhoneNumber();
	
	Connection con = null;
	PreparedStatement preparedStatement = null;
	
	try
	{
		con = DBConnection.createConnection();
		String query = "insert into user() values (?,?,?,?)"; //Insert user details into the table 'USERS'
		preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		preparedStatement.setString(1, fullName);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, password);
		preparedStatement.setString(4, phoneNumber);
		
		int i= preparedStatement.executeUpdate();
		if (i!=0)  
			return "SUCCESS"; 
	}
	catch(SQLException e)
	{
		//	e.printStackTrace();
		 System.out.println("error happend " + e.getMessage());
	}

	
	return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	}
}
