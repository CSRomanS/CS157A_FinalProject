package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entity.Item;
import entity.Review;
import entity.Util;

public class ItemDao {

	/**
	 * get item by itemID
	 * 
	 * @return item
	 */
	public Item getItem(Integer itemID) {

		Connection con = DBConnect.Connect();
		Item item = new Item();
		List<String> photos = new ArrayList<String>();
		List<Review> reviews = new ArrayList<Review>();

		try {
			Statement statement = con.createStatement();
			statement.executeQuery(
					"SELECT ItemID, ItemName, MainDescription, CategoryDescription, Price, SalePrice, SaleEnds, ScheduledPrice, Stock, CoverPicture, CategoryID, IsFeatured, ItemRating FROM items "
							+ "WHERE ItemID=" + itemID + ";");
			ResultSet rs = statement.getResultSet();

			while (rs.next()) {
				item.setItemID(rs.getInt(1));
				item.setItemName(rs.getString(2));
				item.setMainDescription(rs.getString(3));
				item.setCategoryDescription(rs.getString(4));
				item.setPrice(rs.getFloat(5));
				item.setSaleEnds(rs.getTimestamp(7));

				Timestamp saleEnds = rs.getTimestamp(7);
				Timestamp now = new Timestamp(System.currentTimeMillis());

				if (saleEnds == null || saleEnds.before(now)) {
					item.setSalePrice(null);
				} else {
					item.setSalePrice(rs.getFloat(6));
				}

				item.setScheduledPrice(rs.getFloat(8));
				item.setStock(rs.getInt(9));
				item.setCoverPicture(rs.getString(10));
				item.setCategoryID(rs.getInt(11));
				item.setIsFeatured(rs.getInt(12));
				item.setItemRating(rs.getFloat(13));
			}

			// get item photos
			statement.executeQuery("SELECT Link FROM pictures WHERE ItemID =" + itemID + ";");
			ResultSet rs2 = statement.getResultSet();
			while (rs2.next()) {
				photos.add(rs2.getString(1));
			}

			item.setPhotos(photos);

			statement.executeQuery(
					"SELECT r.ReviewsID, r.StarRating, r.ReviewText, r.Picture, r.AuthorID, u.FirstName, u.LastName, r.ReviewTime, (select COUNT(h.ReviewID) from helpfulvotes h where h.ReviewID = r.ReviewsID AND helpful=1), (select COUNT(h.ReviewID) from helpfulvotes h where h.ReviewID = r.ReviewsID AND helpful=0) as hCount FROM reviews r, users u WHERE ItemID = "
							+ itemID + " AND r.AuthorID = u.UserID ORDER BY ReviewTime;");
			ResultSet rs3 = statement.getResultSet();
			while (rs3.next()) {
				Review r = new Review();
				r.setReviewsID(rs3.getInt(1));
				r.setStarRating(rs3.getInt(2));
				r.setReviewText(rs3.getString(3));
				r.setPicture(rs3.getString(4));
				r.setAuthorID(rs3.getInt(5));
				r.setAuthorName(rs3.getString(6) + " " + rs3.getString(7));
				r.setReviewTime(Util.datetimeToString(rs3.getTimestamp(8)));
				r.setHelpfulCount(rs3.getInt(9));
				r.setUnHelpfulCount(rs3.getInt(10));

				reviews.add(r);
			}
			item.setReviews(reviews);

			DBConnect.close(con, statement, rs);
			return item;
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * select all featured items to show on the homepage banner
	 * 
	 * @return list of featured items
	 */
	public List<Item> getFeaturedItems() {

		Connection con = DBConnect.Connect();
		List<Item> items = new ArrayList<Item>();

		try {
			Statement statement = con.createStatement();
			statement.executeQuery("SELECT ItemId, CoverPicture FROM items " + "WHERE IsFeatured=1 LIMIT 5;");
			ResultSet rs = statement.getResultSet();

			while (rs.next()) {
				Item item = new Item();
				item.setItemID(rs.getInt(1));
				item.setCoverPicture(rs.getString(2));
				items.add(item);
			}
			DBConnect.close(con, statement, rs);
			return items;
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * select items by categoryID
	 * 
	 * @return list of items under the category
	 */
	public List<Item> getItemsByCate(Integer categoryID) {

		Connection con = DBConnect.Connect();
		List<Item> items = new ArrayList<Item>();

		try {
			Statement statement = con.createStatement();
			statement.executeQuery("SELECT ItemId, CoverPicture, ItemName, Price FROM items " + "WHERE CategoryID="
					+ categoryID + " LIMIT 8;");
			ResultSet rs = statement.getResultSet();

			while (rs.next()) {
				Item item = new Item();
				item.setItemID(rs.getInt(1));
				item.setCoverPicture(rs.getString(2));
				item.setItemName(rs.getString(3));
				item.setPrice(rs.getFloat(4));
				items.add(item);
			}
			DBConnect.close(con, statement, rs);
			return items;
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	public List<Item> searchForItems(String keyword) {

		Connection con = DBConnect.Connect();
		List<Item> itemList = new ArrayList<>();

		try {
			String sql = "SELECT * FROM Items WHERE LOWER(ItemName) LIKE ? OR LOWER(MainDescription) LIKE ? OR LOWER(CategoryDescription) LIKE ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			String searchKeyword = "%" + keyword.toLowerCase() + "%";
			pstmt.setString(1, "%" + searchKeyword + "%");
			pstmt.setString(2, "%" + searchKeyword + "%");
			pstmt.setString(3, "%" + searchKeyword + "%");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Item item = new Item();
				item.setItemID(rs.getInt("ItemID"));
				item.setItemName(rs.getString("ItemName"));
				item.setMainDescription(rs.getString("MainDescription"));
				item.setCategoryDescription(rs.getString("CategoryDescription"));
				item.setPrice(rs.getFloat("Price"));
				
				Timestamp saleEnds = rs.getTimestamp("saleEnds");
				Timestamp now = new Timestamp(System.currentTimeMillis());

				if (saleEnds == null || saleEnds.before(now)) {
					item.setSalePrice(null);
				} else {
					item.setSalePrice(rs.getFloat("SalePrice"));
				}
				item.setSaleEnds(rs.getDate("SaleEnds"));
				item.setScheduledPrice(rs.getFloat("ScheduledPrice"));
				item.setStock(rs.getInt("Stock"));
				item.setCoverPicture(rs.getString("CoverPicture"));
				item.setCategoryID(rs.getInt("CategoryID"));
				item.setIsFeatured(rs.getInt("IsFeatured"));

				itemList.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itemList;

	}

}
