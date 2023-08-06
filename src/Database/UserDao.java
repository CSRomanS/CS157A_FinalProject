package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.User;

public class UserDao {

	/**
	 * Verifies a username/password combo
	 * 
	 * @param username string containing the username
	 * @param password string containing the password
	 * @return -1 on failure (incorrect password/username, sqlerror), the userID on
	 *         success
	 */
	public int verifyLogin(String username, String password) {
		Connection con = DBConnect.Connect();
		if (con == null)
			return -1;
		try {
			Statement statement = con.createStatement();
			statement.executeQuery("SELECT UserID FROM logins " + "WHERE username='" + username + "' AND PassWord='"
					+ password + "';");
			ResultSet rs = statement.getResultSet();
			if (!rs.next())
				return -1; // return -1 if no match found
			int userID = rs.getInt(1); // get userID
			DBConnect.close(con, statement, rs);
			return userID;
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
			return -1;
		}
	}

	/**
	 * Creates a new account by inserting into accounts and login
	 * 
	 * @param username
	 * @param pass
	 * @param fName    firstname
	 * @param lName    lastName
	 * @param aLine    Address Line one
	 * @param city
	 * @param state
	 * @param zip
	 * @return
	 */
	public int createAccount(String username, String pass, String fName, String lName, String phoneNum,
			String email, String aLine, String city, String state, int zip) {
		// SQL Statements
		Connection con = DBConnect.Connect();
		if (con == null)
			return -1;
		try {
			con.setAutoCommit(false);
			Statement statement = con.createStatement();
			statement.executeUpdate(
					"INSERT INTO Users(FirstName, LastName, PhoneNum, Email, AddressLineOne, City, State, ZipCode)"
							+ "VALUES ('" + fName + "','" + lName + "','" + phoneNum + "','" + email + "','" + aLine
							+ "','" + city + "','" + state + "','" + zip + "')",
					Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys();
			rs.next();
			int userID = rs.getInt(1);
			statement.executeUpdate("INSERT INTO Logins(UserName, PassWord, UserID)" + "VALUES ('" + username + "','"
					+ pass + "','" + userID + "')");

			// close and return
			rs.close();
			statement.close();
			con.commit();
			return userID;
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException sqle) {
				System.err.println(e.getMessage());
			} finally {
				try {
					con.commit();
					con.close();
				} catch (SQLException sqle) {
					System.err.println(e.getMessage());
				}
			}
			return -1;
		}
	}
	
	public User getAddressForUser(Integer userID) throws SQLException {
	    User user = new User();

	    Connection con = DBConnect.Connect();
	    if(con == null) return user;

	    PreparedStatement ps = con.prepareStatement("SELECT AddressLineOne, City, State, ZipCode FROM users WHERE UserID = ?");
	    ps.setInt(1, userID);
	    
	    ResultSet rs = ps.executeQuery();
	    
	    if (rs.next()) {
	        user.setAddress(rs.getString("AddressLineOne"));
	        user.setCity(rs.getString("City"));
	        user.setState(rs.getString("State"));
	        user.setZipcode(rs.getString("ZipCode"));
	    }

	    rs.close();
	    ps.close();
	    con.close();

	    return user;
	}

	public Float getUserTaxRate(int userID) {
		Connection con = DBConnect.Connect();
		Float tax = null;
		try {
			Statement statement = con.createStatement();
			statement.executeQuery(
					"SELECT t.Tax FROM taxes t, users u WHERE u.state = t.state AND u.UserID = " + userID + ";");
			ResultSet rs = statement.getResultSet();
			rs.next();
			tax = rs.getFloat(1); // return -1 if no match found
			DBConnect.close(con, statement, rs);
			
			return tax;
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

}
