package com.nissan.training.advancedjava.project.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nissan.training.corejava.project.controller.CustomerRegistrationController;

/**
 * Servlet implementation class CustomerRegister
 */
@WebServlet("/customerRegister")
public class CustomerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegister() {
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
		CustomerRegistrationController c = new CustomerRegistrationController();
		c.takeInput(request, response);
		try {
			c.register();
			HttpSession s = request.getSession(true);
			s.setAttribute("name", c.custModel.getCustName());
			
			request.getRequestDispatcher("customerpage.jsp").forward(request,response);
		} catch (SQLException e) {
			response.getWriter().println("Error occurred while Logging. Please try again later");
			request.getRequestDispatcher("customerRegister.jsp").include(request,response);
			e.printStackTrace();
		}
		
	}

}
