package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entity.CartItem;
import entity.Item;
import entity.User;

public class CartDao {

	private UserDao uDao = new UserDao();

	/**
	 * get all the cart items by userID
	 * 
	 * @param userID
	 * @return
	 */
	public List<CartItem> getCartItems(Integer userID) {

		List<CartItem> cItems = new ArrayList<CartItem>();

		Connection con = DBConnect.Connect();

		try {
			Statement statement = con.createStatement();
			statement.executeQuery(
					"SELECT s.UserID, s.ItemID, s.ItemCount, i.ItemName, i.CategoryDescription, i.Price, i.CoverPicture, i.Stock, i.SalePrice, i.SaleEnds FROM shoppingcarts s, items i WHERE i.ItemID = s.ItemID AND s.UserID = "
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

				Timestamp saleEnds = rs.getTimestamp(10);
				Timestamp now = new Timestamp(System.currentTimeMillis());

				if (saleEnds == null || saleEnds.before(now)) {
					i.setSalePrice(null);
				} else {
					i.setSalePrice(rs.getFloat(9));
				}

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

	public boolean placeOrder(Integer userID, List<CartItem> cartItems) {
		Connection con = DBConnect.Connect();

		if (con == null)
			return false;

		try {
			// Start a transaction
			con.setAutoCommit(false);

			// 1. Calculate the total cost and taxes
			float totalCost = 0;
			for (CartItem cartItem : cartItems) {
				// check if it's on sale
				if (cartItem.getItem().getSalePrice() != null) {
					cartItem.getItem().setPrice(cartItem.getItem().getSalePrice());
				}
				totalCost += cartItem.getItemCount() * cartItem.getItem().getPrice();
			}

			// Fetch tax rate for user's state
			User user = uDao.getAddressForUser(userID);
			float taxRate = uDao.getUserTaxRate(userID);
			float taxes = totalCost * taxRate;

			// 2. Insert into orders table
			String insertOrderSQL = "INSERT INTO orders (DatePlaced, Cost, Taxes, UserID, AddressLineOne, City, State, ZipCode) VALUES (NOW(), ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement psOrder = con.prepareStatement(insertOrderSQL, Statement.RETURN_GENERATED_KEYS);
			psOrder.setFloat(1, totalCost + taxes);
			psOrder.setFloat(2, taxes);
			psOrder.setInt(3, userID);
			psOrder.setString(4, user.getAddress());
			psOrder.setString(5, user.getCity());
			psOrder.setString(6, user.getState());
			psOrder.setString(7, user.getZipcode());

			psOrder.executeUpdate();
			ResultSet generatedKeys = psOrder.getGeneratedKeys();
			int orderID = 0;
			if (generatedKeys.next()) {
				orderID = generatedKeys.getInt(1);
			}

			// 3. Insert each CartItem into orderitems table
			String insertOrderItemSQL = "INSERT INTO orderitems (ItemID, ItemCount, ItemCost, OrderID) VALUES (?, ?, ?, ?)";
			PreparedStatement psOrderItem = con.prepareStatement(insertOrderItemSQL);

			for (CartItem cartItem : cartItems) {
				psOrderItem.setInt(1, cartItem.getItem().getItemID());
				psOrderItem.setInt(2, cartItem.getItemCount());
				psOrderItem.setFloat(3, cartItem.getItem().getPrice());
				psOrderItem.setInt(4, orderID);

				psOrderItem.addBatch();
			}

			psOrderItem.executeBatch();

			// 4. Delete the items from shoppingcarts for the given userID
			String deleteCartSQL = "DELETE FROM shoppingcarts WHERE UserID = ?";
			PreparedStatement psDeleteCart = con.prepareStatement(deleteCartSQL);
			psDeleteCart.setInt(1, userID);

			psDeleteCart.executeUpdate();

			// Commit the transaction
			con.commit();

			// Close the statements and connection
			psOrder.close();
			psOrderItem.close();
			psDeleteCart.close();
			con.close();

			return true;
		} catch (SQLException e) {
			// Rollback in case of any exception
			try {
				con.rollback();
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.err.println(e.getMessage());
			return false;
		}
	}

	public void insertCartItem(Integer userID, Integer itemID, Integer itemCount) {

		Connection con = DBConnect.Connect();
		try {
			// Check if the row exists
			PreparedStatement checkStmt = con
					.prepareStatement("SELECT COUNT(*) FROM shoppingcarts WHERE UserID = ? AND itemID = ?");
			checkStmt.setInt(1, userID);
			checkStmt.setInt(2, itemID);

			ResultSet rs = checkStmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			rs.close();
			checkStmt.close();

			if (count > 0) {
				// Item already exists in cart, so update its count
				PreparedStatement updateStmt = con.prepareStatement("UPDATE shoppingcarts SET itemCount = itemCount + "
						+ itemCount + " WHERE UserID = ? AND itemID = ?");
				updateStmt.setInt(1, userID);
				updateStmt.setInt(2, itemID);
				updateStmt.executeUpdate();
				updateStmt.close();
			} else {
				// Item does not exist in cart, so insert new row with count 1
				PreparedStatement insertStmt = con
						.prepareStatement("INSERT INTO shoppingcarts(UserID, itemID, itemCount) VALUES (?, ?, ?)");
				insertStmt.setInt(1, userID);
				insertStmt.setInt(2, itemID);
				insertStmt.setInt(3, itemCount);
				insertStmt.executeUpdate();
				insertStmt.close();
			}

			con.close();
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
		}

	}

}
