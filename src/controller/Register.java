package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DBAccess;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phonenum = request.getParameter("phonenum");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		Integer zip = null;
		if(null != zipcode) {
			zip = Integer.valueOf(zipcode);
		}

		
		//insert user
		boolean flag = DBAccess.createAccount(username, password, firstname, lastname, phonenum, email, address, city, state, zip);
		
		//response
		if(flag) {
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		} else {
			request.setAttribute("msg","Register failed.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

}
