package com.nissan.training.advancedjava.project.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nissan.training.corejava.project.doa.DatabaseWrapper;

/**
 * Servlet implementation class ModifyBooking
 */
@WebServlet("/modifyBooking")
public class ModifyBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	String q = "delete from booking where booking_id = "+id;
	System.out.println(q);
	try {
		new DatabaseWrapper().executeSqlQueryUpdate(q);
		response.getWriter().println("Booking deleted succesfully");
		request.getRequestDispatcher("/showCustomerBookings").include(request, response);
	} catch (SQLException e) {
		response.getWriter().println("Error occurred!. Please try again later!");
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
