package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import Database.ReviewDao;
import entity.Util;

/**
 * Servlet implementation class voteUseful
 */
@WebServlet("/voteUseful")
public class VoteUsefulServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReviewDao rDao = new ReviewDao();

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

		Integer userID = Integer.valueOf(request.getParameter("userID"));
		Integer reviewID = Integer.valueOf(request.getParameter("reviewID"));
		Integer helpful = Integer.valueOf(request.getParameter("helpful"));
		

		// Check if this user has already voted for this review
		if (rDao.checkIfUserHasVoted(userID, reviewID)) {
			Util.respondWithError("You have already voted for this review.", response);
			return;
		}

		// If not, record the vote and update the review_votes table
		rDao.voteUseful(userID, reviewID, helpful);
		
		Util.respondWithSuccess(response);
		
	}

}
