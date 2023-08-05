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

/**
 * Servlet implementation class voteUseful
 */
@WebServlet("/voteUseful")
public class voteUseful extends HttpServlet {
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
		

		// Check if this user has already voted for this review
		if (rDao.checkIfUserHasVoted(userID, reviewID)) {
			respondWithError("You have already voted for this review.", response);
			return;
		}

		// If not, record the vote and update the review_votes table
		rDao.voteUseful(userID, reviewID);
		
		respondWithSuccess(response);
		
	}

	private void respondWithError(String message, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("success", false);
		jsonResponse.put("message", message);

		PrintWriter out = response.getWriter();
		out.write(jsonResponse.toString());
		out.close();
	}

	private void respondWithSuccess(HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("success", true);

		PrintWriter out = response.getWriter();
		out.write(jsonResponse.toString());
		out.close();
	}

}
