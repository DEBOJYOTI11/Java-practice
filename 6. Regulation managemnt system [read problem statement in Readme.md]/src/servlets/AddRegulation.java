package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.RegulationBean;
import services.RegulationService;

/**
 * Servlet implementation class AddRegulation
 */
@WebServlet("/addregulation")
public class AddRegulation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRegulation() {
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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String heading  = request.getParameter("heading");
		String regulation  = request.getParameter("regulation");
		
		RegulationBean rb = new RegulationBean();
		rb.setRegulationHeading(heading);
		rb.setRegulationBody(regulation);
		
		RegulationService rbDao  = new RegulationService();
		
		RequestDispatcher rd = request.getRequestDispatcher("/adminpage.jsp");
		
		try {
			rbDao.addRegulation(rb);
			out.println("Succesfully added");
			System.out.println("[INFO] "+"record inserted");
			
		} catch (SQLException e) {
			out.println("Soory error occurred while adding regulation!");
			
			System.out.println("[Error] "+e.getMessage());
		}
		rd.include(request, response);
	}

}
