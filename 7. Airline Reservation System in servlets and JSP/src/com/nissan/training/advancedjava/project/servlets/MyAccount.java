package com.nissan.training.advancedjava.project.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nissan.training.corejava.project.models.CustomerModel;
import com.nissan.training.corejava.project.services.CustomerService;

/**
 * Servlet implementation class MyAccount
 */
@WebServlet("/myaccount")
public class MyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in myaccount");
		response.setContentType("text/html");
		// TODO Auto-generated method stub
		int custID = 0;
		try {
			 custID = (int)request.getSession(true).getAttribute("id");
		}catch(NullPointerException e) {
			response.getWriter().println("your session expired. You are being redirected!");
			request.getRequestDispatcher("index.jsp").include(request, response);
			return;
		}
		
		try {
			CustomerModel customerModel = new CustomerService().getCustomer(custID);
			request.setAttribute("data", customerModel);
			request.getRequestDispatcher("updateProfile.jsp").forward(request, response);
			
		} catch (SQLException e) {
			response.getWriter().println("Error occurred. try again later");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
