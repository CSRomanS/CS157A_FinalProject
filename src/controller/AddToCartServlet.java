package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.CartDao;
import entity.CartItem;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CartDao cDao = new CartDao();
       

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
		Integer itemID = Integer.valueOf(request.getParameter("itemID"));
		
		HttpSession session = request.getSession(false); // false means don't create a new session if one doesn't exist

		if (session != null) {
			Integer userID = (Integer)session.getAttribute("userID");
		    if (userID != null) {
		    	cDao.insertCartItem(userID, itemID);
				request.getRequestDispatcher("/cart").forward(request, response);
		    } 
		} else {
			request.setAttribute("msg","Session expired.");
			request.getRequestDispatcher("/homepage").forward(request, response);
		}
	}

}
