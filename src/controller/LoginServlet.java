package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 4249780684684026453L;
	
	private UserDao userDao = new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int userID = userDao.verifyLogin(username, password);
		if (userID == -1) {
			request.setAttribute("msg","Username and password do not match");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("userID", userID);
			request.getRequestDispatcher("/homepage").forward(request, response);
		}
	}


}
