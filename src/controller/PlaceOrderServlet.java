package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.CartDao;
import Database.ItemDao;
import entity.CartItem;
import entity.Item;

/**
 * Servlet implementation class PlaceOrder
 */
@WebServlet("/placeOrder")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CartDao cDao = new CartDao(); 
	
	private ItemDao iDao = new ItemDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false); // false means don't create a new session if one doesn't exist

		Integer userID = (Integer) session.getAttribute("userID");

		String[] itemCounts = request.getParameterValues("itemCount");
		String[] itemIDs = request.getParameterValues("itemID");
		
		if(null == itemIDs || itemIDs.length <= 0) {
			request.getRequestDispatcher("/cart").forward(request, response);
		}

		List<CartItem> ci = new ArrayList<CartItem>(); 
		// You can now loop through these arrays and create CartItem objects and process
		// them
		for (int i = 0; i < itemIDs.length; i++) {
			CartItem cartItem = new CartItem();
			cartItem.setUserID(userID);
			cartItem.setItemCount(Integer.parseInt(itemCounts[i]));
			Item item = iDao.getItem(Integer.parseInt(itemIDs[i]));
			cartItem.setItem(item);
			ci.add(cartItem);
		}
		
		cDao.placeOrder(userID, ci);
		//TODO Redirect to order page
	}

}
