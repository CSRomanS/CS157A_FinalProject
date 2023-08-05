package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.ItemDao;

/**
 * Servlet implementation class Homepage
 */
@WebServlet("/homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ItemDao itemDao = new ItemDao();
	

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
		request.setAttribute("items",itemDao.getFeaturedItems());
		
		request.setAttribute("electronics", itemDao.getItemsByCate(1));
		request.setAttribute("pets", itemDao.getItemsByCate(2));
		request.setAttribute("health", itemDao.getItemsByCate(3));
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

}
