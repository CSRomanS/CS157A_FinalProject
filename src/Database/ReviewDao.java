package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReviewDao {
	
	/**
     * Create a review between a user and item
     * @param sRating The star rating 1-5
     * @param rText Review text (optional)
     * @param picture Picture Link (optional)
     * @param authID userID of the author
     * @param itemID itemID the user is reviewing
     * @return true if successful, false otherwise
     */
    public static boolean createReview(int sRating, String rText, String picture, int authID, int itemID){
        Connection con = DBConnect.Connect();
        if(con == null) return false;
        try {
        	String sql = "INSERT INTO Reviews(StarRating, ReviewText, Picture, AuthorID, ItemID, ReviewTime) VALUES (?, ?, ?, ?, ?, NOW())";
        	PreparedStatement pstmt = con.prepareStatement(sql);
        	pstmt.setInt(1, sRating);
        	pstmt.setString(2, rText);
        	pstmt.setString(3, picture);
        	pstmt.setInt(4, authID);
        	pstmt.setInt(5, itemID);
        	pstmt.executeUpdate();
        	pstmt.close();
            con.close();
            return true;
        } catch (java.sql.SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }

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
			if (result > 0) { // user has voted
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
	public void voteUseful(Integer userID, Integer reviewID, int helpful) {
		if (helpful != 1) {
			helpful = 0;
		}
		Connection con = DBConnect.Connect();
		try {
			Statement statement = con.createStatement();
			statement.executeUpdate("INSERT INTO helpfulvotes(ReviewID, UserID, Helpful) " + "VALUES ('" + reviewID
					+ "','" + userID + "','" + helpful + "')");
			statement.close();
			con.close();
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}
