package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.RegulationBean;
import services.RegulationService;

/**
 * Servlet implementation class ShowRegulation
 */
@WebServlet("/showregulation")
public class ShowRegulation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRegulation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String defaultPage="/adminpage.jsp";
		if(request.getParameter("type").equals("user")) {
			defaultPage = "userpage.jsp";
		}
		RegulationService rbDao = new RegulationService();
		
		ArrayList<RegulationBean> arr = new ArrayList<>();
		
		
		try {
			arr = rbDao.getAllRegulation();
			request.setAttribute("data", arr);
			System.out.println("[INFO] records retrived succesfully");
			RequestDispatcher rd = request.getRequestDispatcher("/allRegulation.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			System.out.println("[ERROR] "+e.getMessage());
			out.println("Error occurred while retrieving records");
			RequestDispatcher rd = request.getRequestDispatcher(defaultPage);
			rd.include(request, response);
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
