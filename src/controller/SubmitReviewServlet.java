package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.ReviewDao;
import entity.Util;

/**
 * Servlet implementation class SubmitReviewServlet
 */
@WebServlet("/submitReview")
public class SubmitReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private ReviewDao rDao = new ReviewDao(); 

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

		Integer userID = (Integer) session.getAttribute("userID");
		Integer itemID = Integer.valueOf(request.getParameter("itemID"));
		Integer starRating = Integer.valueOf(request.getParameter("starRating"));
		String reviewText = request.getParameter("reviewText");
		String reviewPicURL = request.getParameter("reviewPicURL");
		
		boolean flag = rDao.createReview(starRating, reviewText, reviewPicURL, userID, itemID);
		if(flag) {
			Util.respondWithSuccess(response);
		} else {
			Util.respondWithError("You've already reviewed this item.", response);
		}
		
	}

}
