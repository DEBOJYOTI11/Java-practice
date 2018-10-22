package com.nissan.training.advancedjava.project.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nissan.training.corejava.project.controller.BookingController;
import com.nissan.training.corejava.project.models.BookingModel;

/**
 * Servlet implementation class ShowCustomerBookings
 */
@WebServlet("/showCustomerBookings")
public class ShowCustomerBookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCustomerBookings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

			int custID = (int)request.getSession(false).getAttribute("id");
			BookingController b = new BookingController(custID);
			try {
				ArrayList<BookingModel> arr = b.showAllBooking(custID);
				System.out.println("dwef" + arr);
				
				request.setAttribute("data", arr);
				request.getRequestDispatcher("mybookings.jsp").forward(request, response);
				
			} catch (SQLException e) {
				response.getWriter().println("Error occurred.  Please try again later");
				request.getRequestDispatcher("customerpage.jsp").include(request, response);
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
