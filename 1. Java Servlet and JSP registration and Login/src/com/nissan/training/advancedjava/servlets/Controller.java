package com.nissan.training.advancedjava.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nissan.training.advancedjava.beans.RegistrationBean;
import com.nissan.training.advancedjava.services.RegistrationServices;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		// TODO Auto-generated method stub
		 String fullName = request.getParameter("fullname");
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		  String phoneNumber  = request.getParameter("phoneNumber");
		 
		 RegistrationBean registerBean = new RegistrationBean();

		 registerBean.setFullName(fullName);
		 registerBean.setEmail(email);
		 registerBean.setPassword(password); 
		 registerBean.setPhoneNumber(phoneNumber);
		 
		 RegistrationServices registerService = new RegistrationServices();

		 String userRegistered = registerService.registerUser(registerBean);
	 
		 if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
			 HttpSession session = request.getSession(true);
			session.setAttribute("name", fullName);
			 
			 request.getRequestDispatcher("/view.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
			 request.setAttribute("errMessage", userRegistered);
			 request.getRequestDispatcher("/Registration.jsp").forward(request, response);
		 }
	}

}
