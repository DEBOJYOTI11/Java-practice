package com.nissan.training.advancedjava.project.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nissan.training.corejava.project.controller.CustomerLoginController;
import com.nissan.traning.corejava.project.exception.UserNotFoundException;

/**
 * Servlet implementation class CustomerLogin
 */
@WebServlet("/customerLogin")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogin() {
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
		CustomerLoginController c = new CustomerLoginController();
		c.takeInput(request, response);
		try {
			int custID = c.login();
			
			HttpSession s = request.getSession(true);
			s.setAttribute("name", c.custEmail);
			s.setAttribute("id", custID);
			
			request.getRequestDispatcher("customerpage.jsp").forward(request,response);
		} catch (UserNotFoundException e) {
			response.getWriter().println("Your credentilas are wrong. Customer does not exist");
			request.getRequestDispatcher("customerLogin.jsp").include(request,response);
			e.printStackTrace();
		} catch (SQLException e) {
			response.getWriter().println("Error occurred while Logging. Please try again later");
			request.getRequestDispatcher("customerLogin.jsp").include(request,response);
			e.printStackTrace();
		}
	}

}
