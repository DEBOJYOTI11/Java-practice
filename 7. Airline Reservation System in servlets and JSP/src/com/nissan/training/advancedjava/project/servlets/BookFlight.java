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
import com.nissan.training.corejava.project.controller.CustomerController;
import com.nissan.training.corejava.project.controller.FlightController;
import com.nissan.training.corejava.project.models.FlightModel;

/**
 * Servlet implementation class BookFlight
 */
@WebServlet("/bookFlight")
public class BookFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	CustomerController customerController = null;
    public BookFlight() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<FlightModel> arr  = new ArrayList<>();
		try {
			arr = FlightController.showAllAvailableFLights();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("data", arr);
		request.getRequestDispatcher("bookFlight.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int custID = (int)(request.getSession(false).getAttribute("id"));
			BookingController bookingController = new BookingController(custID);
			
			bookingController.takeInput(request,response);
			
			boolean successPayment = bookingController.makePayment(request, response);
			if(!successPayment) {
				response.getWriter().println("Payment declined. Please enter valid card details");
				request.getRequestDispatcher("dobooking.jsp").include(request, response);
			}
				
			
			//if payment done then book flight
			int bookingID;
			try {
				bookingID = bookingController.bookFlight(custID);
				String pnr = bookingController.generatePNR(bookingID);
				response.getWriter().println("\nYou flight has been booked. ");
				response.getWriter().println("\nPNR is "+pnr);
				request.getRequestDispatcher("dobooking.jsp").include(request, response);
			} catch (SQLException e) {
				request.getRequestDispatcher("dobooking.jsp").include(request, response);
				e.printStackTrace();
			}
			
		
			
			
	}

}
