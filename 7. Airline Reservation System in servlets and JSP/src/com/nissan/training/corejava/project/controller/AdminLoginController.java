package com.nissan.training.corejava.project.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nissan.training.corejava.project.enums.Validators;
import com.nissan.training.corejava.project.interfaces.IInputInterface;
import com.nissan.training.corejava.project.interfaces.ILoginInterface;
import com.nissan.training.corejava.project.services.AdminLoginService;
import com.nissan.training.corejava.project.utils.MD5;
import com.nissan.training.corejava.project.utils.ReadInput;
import com.nissan.traning.corejava.project.exception.UserNotFoundException;



public class AdminLoginController implements ILoginInterface  , IInputInterface{

	
	String adminEmail;
	String adminPassword;
	ReadInput readInput = null;
	AdminLoginService adminLoginService = null;
	
	public AdminLoginController() {
		// TODO Auto-generated constructor stub
		readInput = new ReadInput();
		adminLoginService = new AdminLoginService();
	}

	@Override
	public void takeInput(HttpServletRequest request, HttpServletResponse response) {
	
		this.adminEmail = request.getParameter("name");
		
		
		this.adminPassword = request.getParameter("pass");

	}

	@Override
	public int login() throws UserNotFoundException, SQLException{
		return adminLoginService.checkAdmin(this.adminEmail,MD5.getHash(this.adminPassword));
	}
}
