package com.nissan.training.advancedjava.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nissan.training.advancedjava.beans.RegistrationBean;
import com.nissan.training.advancedjava.services.LoginServices;
import com.nissan.training.advancedjava.services.RegistrationServices;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
	
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
	
		 
		 RegistrationBean registerBean = new RegistrationBean();


		 registerBean.setEmail(email);
		 registerBean.setPassword(password); 
	
		 
		 LoginServices registerService = new LoginServices();

		 String userLoggedIn = registerService.loginUser(registerBean);
	 
		 if(userLoggedIn.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
			 HttpSession session = request.getSession(true);
			 session.setAttribute("name", email);
			 
			 request.getRequestDispatcher("/view.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
			 request.setAttribute("errMessage", userLoggedIn);
			 request.getRequestDispatcher("/Login.jsp").forward(request, response);
		 }
	}

}
