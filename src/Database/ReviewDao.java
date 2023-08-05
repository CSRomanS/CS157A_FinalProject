package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Item;

public class ReviewDao {

	/**
	 * check if the user has already voted
	 * 
	 * @param userID
	 * @param reviewID
	 * @return
	 */
	public boolean checkIfUserHasVoted(Integer userID, Integer reviewID) {

		Connection con = DBConnect.Connect();

		try {
			Statement statement = con.createStatement();
			statement.executeQuery(
					"SELECT COUNT(*) FROM helpfulvotes WHERE UserID = " + userID + " AND ReviewID = " + reviewID + ";");
			ResultSet rs = statement.getResultSet();
			rs.next();
			int result = rs.getInt(1);
			if (result > 0) {	//user has voted
				return true;
			}

			DBConnect.close(con, statement, rs);
			return false;
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
			return true;
		}

	}

	/**
	 * insert voting data
	 * 
	 * @param userID
	 * @param reviewID
	 */
	public void voteUseful(Integer userID, Integer reviewID) {
		Connection con = DBConnect.Connect();
		try {
			Statement statement = con.createStatement();
			statement.executeUpdate("INSERT INTO helpfulvotes(ReviewID, UserID, Helpful) " + "VALUES ('" + reviewID
					+ "','" + userID + "','" + 1 + "')");
			statement.close();
			con.close();
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}
