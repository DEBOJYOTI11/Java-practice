package com.nissan.training.corejava.project.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nissan.training.corejava.project.doa.DatabaseWrapper;
import com.nissan.training.corejava.project.models.CustomerModel;

public class CustomerService {

	public CustomerService() {
		
	}
	
	/**
	 * Utility for getting a customer name from customer ID
	 * @param custID
	 * @return
	 */
	public static String getCustomerName(int custID) {
		String q = "select cust_name from Customer where cust_id = "+custID;
		DatabaseWrapper db = new DatabaseWrapper();
		String customerName = null;
		try {
			ResultSet rs = db.executeSqlQuerySelect(q);
			while(rs.next()) {
				customerName = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerName;
	}
	public void saveCustomer(CustomerModel customerModel) {
		
	}
	
	public void getCustomer() {
		
	}
	
	public CustomerModel getCustomer(int custID) throws SQLException {
		String q = "select * from customer wher cust_id = "+ custID;
		DatabaseWrapper db = new DatabaseWrapper();
		ResultSet rs = db.executeSqlQuerySelect(q);
		CustomerModel c = new CustomerModel();
		c.setId(rs.getInt(1));
		c.setCustName(rs.getString(2));
		c.setCustEmail(rs.getString(3));
		c.setCustPassword(rs.getString(4));
		c.setCustDob(rs.getString(5));
		c.setCustContactNumber(rs.getString(6));
		return c;
		
	}
	
	public void getSavedCards(int custID) {
		
	}
	
	

}
