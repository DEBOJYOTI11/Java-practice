package com.nissan.tarining.advancedjava.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nissan.tarining.advancedjava.beans.RegistrationBean;
import com.nissan.training.advancedjava.services.RegistrationServices;

/**
 *  implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String fullName = request.getParameter("fullname");
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 
		 RegistrationBean registerBean = new RegistrationBean();
		 //Using Java Beans - An easiest way to play with group of related data
		 registerBean.setFullName(fullName);
		 registerBean.setEmail(email);
		 registerBean.setPassword(password); 
		 
		 RegistrationServices registerService = new RegistrationServices();
		 
		 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String userRegistered = registerService.registerUser(registerBean);
		 
		 if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("/viw.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", userRegistered);
		 request.getRequestDispatcher("/Register.jsp").forward(request, response);
		 }
	}

}
