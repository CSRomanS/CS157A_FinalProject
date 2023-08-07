package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.ItemDao;
import entity.Item;

/**
 * Servlet implementation class ToSearchServlet
 */
@WebServlet("/searchPage")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ItemDao iDao = new ItemDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");

		// Search for items that match or relate to the keyword
		List<Item> items = iDao.searchForItems(keyword);

		request.setAttribute("itemList", items);
		request.getRequestDispatcher("/search.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
