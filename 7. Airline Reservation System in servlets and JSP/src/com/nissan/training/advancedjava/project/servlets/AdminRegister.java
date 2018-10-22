package com.nissan.training.advancedjava.project.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nissan.training.corejava.project.controller.AdminRegistrationController;

/**
 * Servlet implementation class AdminRegister
 */
@WebServlet("/adminRegister")
public class AdminRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegister() {
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
		AdminRegistrationController adminRegistrationController = new AdminRegistrationController();
		adminRegistrationController.takeInput(request,response);
		try {
			adminRegistrationController.register();
			request.getRequestDispatcher("adminpage.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.getWriter().println("Error occurred while registering. Please try again later");
			request.getRequestDispatcher("adminRegister.jsp").include(request, response);
			e.printStackTrace();
		}
	}

}
