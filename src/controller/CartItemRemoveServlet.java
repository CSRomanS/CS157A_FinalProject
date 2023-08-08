package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.CartDao;
import entity.Util;

/**
 * Servlet implementation class CartItemRemoveServlet
 */
@WebServlet("/removeCartItem")
public class CartItemRemoveServlet extends HttpServlet {
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
		HttpSession session = request.getSession(false);

		if (session != null) {
			Integer userID = (Integer) session.getAttribute("userID");
			Integer itemID = Integer.valueOf(request.getParameter("itemID"));
			if (userID != null) {
				cDao.removeFromCart(userID, itemID);
				request.getRequestDispatcher("/cart").forward(request, response);
			}
		} else {
			request.setAttribute("msg","Item remove failed.");
			request.getRequestDispatcher("/homepage").forward(request, response);
		}
	}

}
