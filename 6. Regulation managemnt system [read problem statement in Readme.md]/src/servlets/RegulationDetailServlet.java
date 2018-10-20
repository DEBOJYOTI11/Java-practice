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
 * Servlet implementation class RegulationDetailServlet
 */
@WebServlet("/regulationDetail")
public class RegulationDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegulationDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		RegulationService rDao  = new RegulationService();
		
		try {
			request.setAttribute("data", rDao.getRegulationDetail(id));
			
		} catch (SQLException e) {
			out.println("Error ocuured while retrieving regulation details");
			System.out.println("[Error] error occurred while inserting record");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/regulationdetail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
