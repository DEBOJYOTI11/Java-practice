package com.nissan.training.advancedjava.project.servlets;

import java.io.IOException;
import java.net.Inet4Address;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nissan.training.corejava.project.doa.DatabaseWrapper;
import com.nissan.training.corejava.project.models.CustomerModel;

/**
 * Servlet implementation class CustomerUpdate
 */
@WebServlet("/customerUpdate")
public class CustomerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdate() {
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
		//this is done for sake of simplicity only
		response.setContentType("text/html");
		CustomerModel c = new CustomerModel();
		c.setCustName(request.getParameter("name"));
		c.setCustEmail( request.getParameter("email"));
		
		c.setCustDob(request.getParameter("dob"));
		c.setCustContactNumber(request.getParameter("number"));
		
		c.setId(Integer.parseInt(request.getParameter("id")));
		
		String q = "update customer set cust_name='%s' , cust_email='%s', cust_dob='%s', cust_contactNumber='%s' where cust_id=%s";
		q =String.format(q, c.getCustName(), c.getCustEmail(), c.getCustDob(),c.getCustContactNumber(),c.getId() );
		System.out.println(q);
		DatabaseWrapper db = new DatabaseWrapper();
		try {
			db.executeSqlQueryUpdate(q);
			request.setAttribute("data", c);
			request.getSession(false).setAttribute("name", c.getCustEmail());
			response.getWriter().println("Succesfully modifies account");
			request.getRequestDispatcher("updateProfile.jsp").include(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
