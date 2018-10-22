package com.nissan.training.corejava.project.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nissan.training.corejava.project.doa.DatabaseWrapper;
import com.nissan.training.corejava.project.enums.BookingStatus;
import com.nissan.training.corejava.project.enums.Validators;
import com.nissan.training.corejava.project.interfaces.IInputInterface;
import com.nissan.training.corejava.project.models.BookingModel;
import com.nissan.training.corejava.project.models.TicketsModel;
import com.nissan.training.corejava.project.services.BookingService;
import com.nissan.training.corejava.project.services.FlightService;
import com.nissan.training.corejava.project.services.PaymentGatewayService;
import com.nissan.training.corejava.project.utils.MD5;
import com.nissan.training.corejava.project.utils.ReadInput;
import com.nissan.training.corejava.project.utils.Utility;
import com.nissan.traning.corejava.project.exception.CardNotFoundException;

/**
 * The class implements all methods necessary for booking 
 * @author NDH00159
 *
 */
public class BookingController implements IInputInterface{

	BookingModel bookingModel = null;
	BookingService bookingService = null;
	ReadInput readInput = null;
	ArrayList<TicketsModel> ticketsModelsList = null;
	
	private int customerID;
	private int numberOfTickets;
	private int totalCost;
	public BookingController(int custtomerID) {
		bookingModel = new BookingModel();
		bookingService = new BookingService();
		readInput = new ReadInput();
		this.customerID = custtomerID;
		ticketsModelsList = new ArrayList<>();
	}

	/**
	 * Show all bookings for a customer
	 * @param customerId
	 * @throws SQLException
	 */
	public ArrayList<BookingModel> showAllBooking(int customerId) throws SQLException {
		
		ArrayList<BookingModel> bookings = bookingService.getAllBookingsByCustomer(customerId);
		return bookings;
//		Utility.printLabelsBookings();
//		for(BookingModel booking:bookings) {
//			System.out.print(" "+ booking.getBookingID() + "  ");
//			System.out.print(" "+booking.getTicketID()+" ");
//			System.out.print(booking.getBookingDate() + " ");
//			System.out.print(booking.getCustomerName()+ "  ");
//			System.out.print(booking.getCustomerContactNumber()+" ");
//			
//			System.out.print(booking.getFlightNumber()+" ");
//			System.out.print(booking.getFlightArrival()+" ");
//			System.out.print(booking.getFlightDeparture()+" ");
//			System.out.print(booking.getPassengerName() + "  ");
//			System.out.print(booking.getPassengerEmail() + "  ");
//			System.out.print(booking.getPassengerDOB() + "  ");
//			System.out.println();
//		}
	}


	/**
	 * books a flights
	 * saves individual ticket model
	 * @param customerID
	 * @return
	 * @throws SQLException
	 */
	public int bookFlight(int customerID) throws SQLException {
		
		int bookingID = BookingService.saveBooking(customerID);
		for(TicketsModel ticketModel:ticketsModelsList) {
			ticketModel.setBookingID(bookingID);
			ticketModel.save();
		}
		
		FlightService.bookSeats(numberOfTickets,ticketsModelsList.get(0).getFlightID());
		return bookingID;
	}

	@Override
	public void takeInput(HttpServletRequest request, HttpServletResponse response){
		
				
		String flightNumber = null;
	
			flightNumber = request.getParameter("flightnumber");
			if(FlightService.checkValidFlight(flightNumber)) {
				
			}else {
				try {
					response.getWriter().println("\nPlease enter a valid flight Number");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		
		ResultSet rs = null;
		try {
			rs = FlightService.getFlightDetails(flightNumber);
			rs.next();

			
			numberOfTickets = 2;
			System.out.println(request.getParameter("howmany"));   
			
			//get cost of the each ticket and calculates total amount
			totalCost = numberOfTickets * rs.getInt(3);
			
			//checking to see if there are available seats
			if(numberOfTickets > rs.getInt(2)){
				try {
					response.getWriter().println("Number of tickets exceeding the number of available seats!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
				
			for(int i=0;i<numberOfTickets;i++) {
				System.out.println("Ticket "+ String.valueOf(i+1));
				
				TicketsModel ticketsModel = new TicketsModel();
				ticketsModel.setCustomerID(this.customerID);
				
			
				try {
					ticketsModel.setFlightID(rs.getInt(1));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ticketsModel.setBookingTime(LocalDateTime.now().toString());
				ticketsModel.setBookingStatus(BookingStatus.ACTIVE);
				
			
				ticketsModel.setPassengerName(request.getParameter("p1"));
				
			
				ticketsModel.setPassengerDOB(request.getParameter("p2"));
				
			
				ticketsModel.setPassengerEmail(request.getParameter("p3"));
				
				ticketsModelsList.add(ticketsModel);
			}
			
			//Printing the total bill
			 try {
				response.getWriter().println("\n\n<h1>Your total bill  is Rs "+totalCost+"</h1>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * generate pnr
	 * @param bookingID
	 * @return
	 */
	public String generatePNR(int bookingID) {
		
		String query = "select b.booking_id, b.cust_id, t.booking_time, f.flight_number from Booking as b inner join Ticket as t on b.booking_id=t.ticket_id " + 
					"inner join Flight as f on f.flight_id = t.flight_id where b.booking_id="+bookingID;
		
		DatabaseWrapper db = new DatabaseWrapper();
		String pnr = null;
		try {
			ResultSet rs = db.executeSqlQuerySelect(query);
			while(rs.next()) {
				String pnrFormat = "%s-%s-%s-%s";
				pnr = String.format(pnrFormat, rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pnr;
	}

	/**
	 * takes card details and makes payment
	 * @return
	 */
	public boolean makePayment(HttpServletRequest request, HttpServletResponse response) {
		PaymentGatewayService paymentGatewayService = new PaymentGatewayService();
		
	
			
			String cardNumber = request.getParameter("cardnumber");
			System.out.print("Enter Pin Code : ");
			String pin  = request.getParameter("pin");
			
			try {
				paymentGatewayService.verifyCardDetails(cardNumber, MD5.getHash(pin));
				response.getWriter().println("\n<h1>Payment of "+totalCost + " succesfully made. Thank you</h1>");
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (CardNotFoundException e) {
				try {
					response.getWriter().println("***Error. Card not found");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
	}

	public void modifyBooking(int bookingID) {
		
		
	}


}
