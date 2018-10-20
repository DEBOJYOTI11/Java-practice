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
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import beans.UserBean;
import services.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
		
		String mail  = request.getParameter("email_id");
		String pass = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		UserBean ub = new UserBean();
		ub.setEmail_id(mail);
		ub.setPassword(pass);
		
		UserService us = new UserService();
		try {
			UserBean user = us.userlogin(mail, pass);
			
			if(user==null) {
				out.println("Wrong credentilas.. ");
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.include(request, response);
			}
			else {
				request.setAttribute("user_name", user.getEmail_id());
				
				HttpSession session = request.getSession(true);
				session.setAttribute("user_id", user.getId());
				session.setAttribute("name", user.getEmail_id());
				RequestDispatcher rd = request.getRequestDispatcher("/userpage.jsp");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			out.println("Some error occurred.. Please try again later ");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp?type=user");
			rd.include(request, response);
			System.out.println("[Error] :"+e.getMessage());
		}
	}

}
