package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.CartItem;
import entity.Item;

public class CartDao {

	/**
	 * get all the cart items by userID
	 * @param userID
	 * @return
	 */
	public List<CartItem> getCartItems(Integer userID) {

		List<CartItem> cItems = new ArrayList<CartItem>();

		Connection con = DBConnect.Connect();

		try {
			Statement statement = con.createStatement();
			statement.executeQuery(
					"SELECT s.UserID, s.ItemID, s.ItemCount, i.ItemName, i.CategoryDescription, i.Price, i.CoverPicture, i.Stock FROM shoppingcarts s, items i WHERE i.ItemID = s.ItemID AND s.UserID = "
							+ userID + ";");
			ResultSet rs = statement.getResultSet();
			while (rs.next()) {
				CartItem c = new CartItem();
				Item i = new Item();
				c.setUserID(rs.getInt(1));
				i.setItemID(rs.getInt(2));
				c.setItemCount(rs.getInt(3));
				i.setItemName(rs.getString(4));
				i.setCategoryDescription(rs.getString(5));
				i.setPrice(rs.getFloat(6));
				i.setCoverPicture(rs.getString(7));
				i.setStock(rs.getInt(8));
				c.setItem(i);
				cItems.add(c);
				
			}

			DBConnect.close(con, statement, rs);
			
			return cItems;
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
		
	}

	public void placeOrder(Integer userID, List<CartItem> ci) {
		
	}

	public void insertCartItem(Integer userID, Integer itemID) {
		
		Connection con = DBConnect.Connect();
		try {
		    // Check if the row exists
		    PreparedStatement checkStmt = con.prepareStatement(
		        "SELECT COUNT(*) FROM shoppingcarts WHERE UserID = ? AND itemID = ?");
		    checkStmt.setInt(1, userID);
		    checkStmt.setInt(2, itemID);

		    ResultSet rs = checkStmt.executeQuery();
		    rs.next();
		    int count = rs.getInt(1);
		    rs.close();
		    checkStmt.close();

		    if(count > 0) {
		        // Item already exists in cart, so update its count
		        PreparedStatement updateStmt = con.prepareStatement(
		            "UPDATE shoppingcarts SET itemCount = itemCount + 1 WHERE UserID = ? AND itemID = ?");
		        updateStmt.setInt(1, userID);
		        updateStmt.setInt(2, itemID);
		        updateStmt.executeUpdate();
		        updateStmt.close();
		    } else {
		        // Item does not exist in cart, so insert new row with count 1
		        PreparedStatement insertStmt = con.prepareStatement(
		            "INSERT INTO shoppingcarts(UserID, itemID, itemCount) VALUES (?, ?, 1)");
		        insertStmt.setInt(1, userID);
		        insertStmt.setInt(2, itemID);
		        insertStmt.executeUpdate();
		        insertStmt.close();
		    }

            con.close();
        } catch (java.sql.SQLException e){
            System.err.println(e.getMessage());
        }
		
	}

}
