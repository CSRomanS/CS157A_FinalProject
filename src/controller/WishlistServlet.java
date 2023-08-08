package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.WishListDao;
import entity.CartItem;

/**
 * Servlet implementation class WishlistServlet
 */
@WebServlet("/wishlist")
public class WishlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private WishListDao wDao = new WishListDao();
       

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
		
		HttpSession session = request.getSession(false); // false means don't create a new session if one doesn't exist

		if (session != null) {
			Integer userID = (Integer)session.getAttribute("userID");
		    if (userID != null) {
		    	
		    	List<CartItem> wishlist = wDao.getWishListByUserID(userID);
		    	request.setAttribute("wishlist", wishlist);
		    	request.getRequestDispatcher("/wishlist.jsp").forward(request, response);
		    } 
		} else {
			request.setAttribute("msg","Please login.");
			request.getRequestDispatcher("/homepage").forward(request, response);
		}
		
	}

}
