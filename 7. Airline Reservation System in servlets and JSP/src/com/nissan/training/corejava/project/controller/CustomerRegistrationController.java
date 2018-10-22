package com.nissan.training.corejava.project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nissan.training.corejava.project.enums.Validators;
import com.nissan.training.corejava.project.interfaces.IInputInterface;
import com.nissan.training.corejava.project.interfaces.IRegistrationInterface;
import com.nissan.training.corejava.project.models.CustomerModel;
import com.nissan.training.corejava.project.utils.MD5;
import com.nissan.training.corejava.project.utils.ReadInput;

/**
 * Customer Registration class
 * implements input interface and registration interface
 * @author NDH00159
 *
 */
public class CustomerRegistrationController implements IInputInterface, IRegistrationInterface{

	public CustomerModel custModel = null;
	ReadInput readInput = null;
	public CustomerRegistrationController() {
		custModel = new CustomerModel();
		readInput = new ReadInput();
	}

	/**
	 * registers an customer
	 */
	@Override
	public void register() throws SQLException {
		custModel.save();
		
	}

	/**
	 * takes customer registration details and creates custModel object
	 */
	@Override
	public void takeInput(HttpServletRequest request, HttpServletResponse response) {
		
		
		custModel.setCustName(request.getParameter("name"));
		
		
		custModel.setCustEmail(request.getParameter("email"));
		
			String password;
		
			password = request.getParameter("pass");
			
			
			if(password.equals(request.getParameter("pass_again"))) {
				custModel.setCustPassword(MD5.getHash(password));
			}
			else {
				try {
					response.getWriter().println("\nPassword do not match. Enter Again");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		
		
	
		custModel.setCustDob(request.getParameter("dob"));

		custModel.setCustContactNumber(request.getParameter("number"));
	} 

}
