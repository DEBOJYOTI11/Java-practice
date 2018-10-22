package com.nissan.training.advancedjava.project.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nissan.training.corejava.project.controller.AdminLoginController;
import com.nissan.traning.corejava.project.exception.UserNotFoundException;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		AdminLoginController adminLoginController = new AdminLoginController();
		adminLoginController.takeInput(request,response);
		try {
			int adminID = adminLoginController.login();
			HttpSession s = request.getSession(true);
			s.setAttribute("name", "admin");
			s.setAttribute("id", adminID);
			
			request.getRequestDispatcher("adminpage.jsp").forward(request, response);
		} catch (UserNotFoundException | SQLException e) {
			response.getWriter().println("Error occurred while Logging. Please try again later");
			request.getRequestDispatcher("adminLogin.jsp").include(request, response);
			e.printStackTrace();
		}
	}

}
